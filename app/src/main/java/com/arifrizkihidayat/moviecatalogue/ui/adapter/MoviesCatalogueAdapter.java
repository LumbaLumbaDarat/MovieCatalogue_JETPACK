package com.arifrizkihidayat.moviecatalogue.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.arifrizkihidayat.moviecatalogue.R;
import com.arifrizkihidayat.moviecatalogue.data.source.local.entity.MovieEntity;
import com.arifrizkihidayat.moviecatalogue.databinding.ItemViewMovieCatalogueBinding;
import com.bumptech.glide.Glide;

import lombok.Setter;

import static com.arifrizkihidayat.moviecatalogue.utils.UtilizationClass.getImageUrl;
import static com.arifrizkihidayat.moviecatalogue.utils.UtilizationClass.getUserScore;

public class MoviesCatalogueAdapter extends PagedListAdapter<MovieEntity, MoviesCatalogueAdapter.HolderView> {

    @Setter
    private OnClickItemMovieCatalogue onClickItemMovieCatalogue;

    public MoviesCatalogueAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<MovieEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MovieEntity>() {
        @Override
        public boolean areItemsTheSame(@NonNull MovieEntity oldItem, @NonNull MovieEntity newItem) {
            return oldItem.getMovieId() == newItem.getMovieId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull MovieEntity oldItem, @NonNull MovieEntity newItem) {
            return oldItem.equals(newItem);
        }
    };

    @NonNull
    @Override
    public MoviesCatalogueAdapter.HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemViewMovieCatalogueBinding binding = ItemViewMovieCatalogueBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new HolderView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesCatalogueAdapter.HolderView holder, int position) {
        MovieEntity movieEntity = getItem(position);
        if (movieEntity != null) {
            holder.bind(movieEntity);
            holder.itemView.setOnClickListener(v ->
                    onClickItemMovieCatalogue.onClickItemMovie(movieEntity));
        }
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

        public void bind(MovieEntity movieEntity) {
            Glide.with(itemView.getContext()).
                    load(getImageUrl(movieEntity.getMoviePoster())).
                    error(R.drawable.ic_round_broken_image_24).
                    placeholder(R.drawable.ic_round_hourglass_bottom_24).
                    into(binding.ivImageMovie);

            binding.tvTitleMovie.setText(movieEntity.getMovieTitle());
            binding.tvMovieOverview.setText(movieEntity.getMovieOverview());
            binding.tvMovieScore.setText(getUserScore(itemView.getContext(),
                    movieEntity.getMovieUserScore()));
        }
    }
}
