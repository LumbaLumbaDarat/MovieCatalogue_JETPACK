package com.arifrizkihidayat.moviecatalogue.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.arifrizkihidayat.moviecatalogue.R;
import com.arifrizkihidayat.moviecatalogue.databinding.FragmentMoviesCatalogueBinding;
import com.arifrizkihidayat.moviecatalogue.ui.activity.MovieDetailActivity;
import com.arifrizkihidayat.moviecatalogue.ui.adapter.MoviesCatalogueAdapter;
import com.arifrizkihidayat.moviecatalogue.ui.viewmodel.MoviesCatalogueViewModel;
import com.arifrizkihidayat.moviecatalogue.ui.viewmodel.factory.ViewModelFactory;
import com.google.android.material.snackbar.Snackbar;

import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.IS_FAVORITE;
import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.IS_FRAGMENT_MOVIES;
import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.MOVIES_MODEL;
import static com.arifrizkihidayat.moviecatalogue.utils.AppsConstants.MOVIE_TYPE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MoviesCatalogueFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoviesCatalogueFragment extends Fragment {

    private FragmentMoviesCatalogueBinding binding;
    private Intent intent;

    private MoviesCatalogueViewModel moviesCatalogueViewModel;
    private MoviesCatalogueAdapter moviesCatalogueAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MoviesCatalogueFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MoviesCatalogueFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MoviesCatalogueFragment newInstance(String param1, String param2) {
        MoviesCatalogueFragment fragment = new MoviesCatalogueFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        ViewModelFactory viewModelFactory = ViewModelFactory.getInstance(getActivity());
        moviesCatalogueViewModel = new ViewModelProvider(this, viewModelFactory).
                get(MoviesCatalogueViewModel.class);

        moviesCatalogueAdapter = new MoviesCatalogueAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMoviesCatalogueBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        moviesCatalogueAdapter.setOnClickItemMovieCatalogue(movieEntity -> {
            intent = new Intent(getActivity(), MovieDetailActivity.class);
            intent.putExtra(MOVIES_MODEL, movieEntity.getMovieId());
            intent.putExtra(MOVIE_TYPE, movieEntity.getMovieType());
            intent.putExtra(IS_FAVORITE, movieEntity.isFavorite());
            startActivity(intent);
        });

        Log.e("TAG", "onViewCreated: ".concat(mParam1).concat(" - ").concat(mParam2));

        if (mParam2.equalsIgnoreCase(IS_FAVORITE)) loadFavoriteMoviesCatalogues();
        else loadMoviesCatalogues();

        binding.rvMoviesCatalogues.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvMoviesCatalogues.setHasFixedSize(true);
        binding.rvMoviesCatalogues.setAdapter(moviesCatalogueAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    private void loadMoviesCatalogues()
    {
        if (mParam1.equalsIgnoreCase(IS_FRAGMENT_MOVIES))
        {
            moviesCatalogueViewModel.getMoviesCatalogue().observe(getViewLifecycleOwner(),
                    listResource ->
                    {
                        if (listResource != null)
                        {
                            switch (listResource.status)
                            {
                                case LOADING:
                                    binding.pbMoviesCatalogue.setVisibility(View.VISIBLE);
                                    break;
                                case SUCCESS:
                                    moviesCatalogueAdapter.submitList(listResource.data);
                                    binding.pbMoviesCatalogue.setVisibility(View.GONE);
                                    break;
                                case ERROR:
                                    Log.e("TAG", "onViewCreated: ERROR ".
                                            concat(listResource.status.toString()).
                                            concat(" - ").concat(listResource.message));
                                    binding.pbMoviesCatalogue.setVisibility(View.GONE);
                                    Toast.makeText(getActivity(), getResources().
                                                    getString(R.string.error_message_something_wrong).
                                                    concat("\n").
                                                    concat(listResource.status.toString()).
                                                    concat(" - ").concat(listResource.message),
                                            Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                    });
        } else {
            moviesCatalogueViewModel.getTvShowsCatalogue().observe(getViewLifecycleOwner(),
                    listResource ->
                    {
                        if (listResource != null)
                        {
                            switch (listResource.status)
                            {
                                case LOADING:
                                    binding.pbMoviesCatalogue.setVisibility(View.VISIBLE);
                                    break;
                                case SUCCESS:
                                    moviesCatalogueAdapter.submitList(listResource.data);
                                    binding.pbMoviesCatalogue.setVisibility(View.GONE);
                                    break;
                                case ERROR:
                                    Log.e("TAG", "onViewCreated: ERROR ".
                                            concat(listResource.status.toString()).
                                            concat(" - ").concat(listResource.message));
                                    binding.pbMoviesCatalogue.setVisibility(View.GONE);
                                    Toast.makeText(getActivity(), getResources().
                                                    getString(R.string.error_message_something_wrong).
                                                    concat("\n").
                                                    concat(listResource.status.toString()).
                                                    concat(" - ").concat(listResource.message),
                                            Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                    });
        }
    }

    private void loadFavoriteMoviesCatalogues()
    {
        if (mParam1.equalsIgnoreCase(IS_FRAGMENT_MOVIES))
        {
            binding.pbMoviesCatalogue.setVisibility(View.VISIBLE);
            moviesCatalogueViewModel.getFavoriteMoviesCatalogue().
                    observe(getViewLifecycleOwner(), movieEntities ->
            {
                Log.e("TAG", "loadFavoriteMoviesCatalogues: ".concat(movieEntities.toString()).concat("-").concat(String.valueOf(movieEntities.size())));
                if (movieEntities.size() == 0)
                    notifyNoFavoriteMovie();

                binding.pbMoviesCatalogue.setVisibility(View.GONE);
                moviesCatalogueAdapter.submitList(movieEntities);
                moviesCatalogueAdapter.notifyDataSetChanged();
            });
        } else {
            binding.pbMoviesCatalogue.setVisibility(View.VISIBLE);
            moviesCatalogueViewModel.getFavoriteTvShowsCatalogue().
                    observe(getViewLifecycleOwner(), movieEntities ->
                    {
                        if (movieEntities.size() == 0)
                            notifyNoFavoriteMovie();

                        binding.pbMoviesCatalogue.setVisibility(View.GONE);
                        moviesCatalogueAdapter.submitList(movieEntities);
                        moviesCatalogueAdapter.notifyDataSetChanged();
                    });
        }
    }

    private void notifyNoFavoriteMovie() {
        Snackbar snackbar = Snackbar.make(binding.getRoot(),
                getResources().getString(R.string.message_no_movie_favorite),
                Snackbar.LENGTH_SHORT);
        snackbar.setAction(getResources().getString(R.string.label_ok),
                v -> snackbar.dismiss());
        snackbar.show();
    }
}