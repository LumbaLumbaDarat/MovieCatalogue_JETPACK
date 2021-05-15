package com.arifrizkihidayat.moviecatalogue.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.arifrizkihidayat.moviecatalogue.data.source.remote.ApiConnectionResponse;
import com.arifrizkihidayat.moviecatalogue.utils.AppsExecutors;
import com.arifrizkihidayat.moviecatalogue.vo.Resource;

public abstract class NetworkBoundResource<ResultType, RequestType> {

    private final MediatorLiveData<Resource<ResultType>> resourceMediatorLiveData =
            new MediatorLiveData<>();

    private final AppsExecutors mExecutors;

    public NetworkBoundResource(AppsExecutors appsExecutors)
    {
        this.mExecutors = appsExecutors;
        resourceMediatorLiveData.setValue(Resource.loading(null));

        LiveData<ResultType> dbSource = loadFromDB();

        resourceMediatorLiveData.addSource(dbSource, data ->
        {
            resourceMediatorLiveData.removeSource(dbSource);
            if (shouldFetch(data))
                fetchFromNetwork(dbSource);
            else resourceMediatorLiveData.addSource(dbSource, newData ->
                    resourceMediatorLiveData.setValue(Resource.success(newData)));
        });
    }

    protected void onFetchFailed() { }

    protected abstract LiveData<ResultType> loadFromDB();

    protected abstract Boolean shouldFetch(ResultType data);

    protected abstract LiveData<ApiConnectionResponse<RequestType>> createCall();

    protected abstract void saveCallResult(RequestType data);

    private void fetchFromNetwork(LiveData<ResultType> dbSource)
    {
        LiveData<ApiConnectionResponse<RequestType>> apiResponse = createCall();

        resourceMediatorLiveData.addSource(dbSource, newData ->
                resourceMediatorLiveData.setValue(Resource.loading(newData))
        );
        resourceMediatorLiveData.addSource(apiResponse, response ->
        {
            resourceMediatorLiveData.removeSource(apiResponse);
            resourceMediatorLiveData.removeSource(dbSource);
            switch (response.status) {
                case SUCCESS:
                    mExecutors.diskIO().execute(() ->
                    {
                        saveCallResult(response.body);
                        mExecutors.mainThread().execute(() ->
                                resourceMediatorLiveData.addSource(loadFromDB(),
                                        newData -> resourceMediatorLiveData.
                                                setValue(Resource.success(newData))));
                    });
                    break;
                case EMPTY:
                    mExecutors.mainThread().execute(() ->
                            resourceMediatorLiveData.addSource(loadFromDB(),
                                    newData -> resourceMediatorLiveData.
                                            setValue(Resource.success(newData))));

                    break;
                case ERROR:
                    onFetchFailed();
                    resourceMediatorLiveData.addSource(dbSource, newData ->
                            resourceMediatorLiveData.
                                    setValue(Resource.error(response.message, newData)));
                    break;
            }
        });
    }

    public LiveData<Resource<ResultType>> asLiveData() {
        return resourceMediatorLiveData;
    }
}
