package com.arifrizkihidayat.moviecatalogue.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arifrizkihidayat.moviecatalogue.R;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieEntity;
import com.arifrizkihidayat.moviecatalogue.databinding.ItemViewMovieCatalogueBinding;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import lombok.Setter;

import static com.arifrizkihidayat.moviecatalogue.utils.UtilizationClass.getImageUrl;
import static com.arifrizkihidayat.moviecatalogue.utils.UtilizationClass.getUserScore;

public class MoviesCatalogueAdapter extends RecyclerView.Adapter<MoviesCatalogueAdapter.HolderView> {

    @Setter
    private Context context;
    private final ArrayList<MovieEntity> movieEntityArrayList = new ArrayList<>();

    @Setter
    private OnClickItemMovieCatalogue onClickItemMovieCatalogue;

    public MoviesCatalogueAdapter() {
    }

    public void setMovieEntityArrayList(ArrayList<MovieEntity> movieEntityArrayList) {
        this.movieEntityArrayList.clear();
        this.movieEntityArrayList.addAll(movieEntityArrayList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MoviesCatalogueAdapter.HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        setContext(parent.getContext());
        ItemViewMovieCatalogueBinding binding = ItemViewMovieCatalogueBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MoviesCatalogueAdapter.HolderView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesCatalogueAdapter.HolderView holder, int position) {
        MovieEntity movieEntity = movieEntityArrayList.get(position);
        holder.bind(context, movieEntity);
        holder.itemView.setOnClickListener(v -> onClickItemMovieCatalogue.
                onClickItemMovie(movieEntity));
    }

    @Override
    public int getItemCount() {
        return movieEntityArrayList.size();
    }

    public interface OnClickItemMovieCatalogue {
        void onClickItemMovie(MovieEntity movieEntity);
    }

    public static class HolderView extends RecyclerView.ViewHolder {

        private final ItemViewMovieCatalogueBinding binding;
        public HolderView(ItemViewMovieCatalogueBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Context context, MovieEntity movieEntity) {
            Glide.with(context).
                    load(getImageUrl(movieEntity.getMoviePoster())).
                    error(R.drawable.ic_round_broken_image_24).
                    placeholder(R.drawable.ic_round_hourglass_bottom_24).
                    into(binding.ivImageMovie);

            binding.tvTitleMovie.setText(movieEntity.getMovieTitle());
            binding.tvMovieOverview.setText(movieEntity.getMovieOverview());
            binding.tvMovieScore.setText(getUserScore(context,
                    movieEntity.getMovieUserScore()));
        }
    }
}
