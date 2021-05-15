package com.arifrizkihidayat.moviecatalogue.data.source.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.arifrizkihidayat.moviecatalogue.data.source.remote.StatusResponse.EMPTY;
import static com.arifrizkihidayat.moviecatalogue.data.source.remote.StatusResponse.ERROR;
import static com.arifrizkihidayat.moviecatalogue.data.source.remote.StatusResponse.SUCCESS;

public class ApiConnectionResponse<T> {

    @NonNull
    public final StatusResponse status;

    @Nullable
    public final String message;

    @Nullable
    public final T body;

    public ApiConnectionResponse(@NonNull StatusResponse status, @Nullable T body, @Nullable String message) {
        this.status = status;
        this.body = body;
        this.message = message;
    }

    public static <T> ApiConnectionResponse<T> success(@Nullable T body) {
        return new ApiConnectionResponse<>(SUCCESS, body, null);
    }

    public static <T> ApiConnectionResponse<T> empty(String msg, @Nullable T body) {
        return new ApiConnectionResponse<>(EMPTY, body, msg);
    }

    public static <T> ApiConnectionResponse<T> error(String msg, @Nullable T body) {
        return new ApiConnectionResponse<>(ERROR, body, msg);
    }
}
