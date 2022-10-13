package com.example.tercerparcial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tercerparcial.R;
import com.example.tercerparcial.bean.Movie;

import java.util.List;

public class MoviesAdapter  extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {


    private List<Movie> mMovies;
    private Context context;

    public MoviesAdapter(List<Movie> mBooks) {
        this.mMovies = mBooks;
    }

    public void reloadData(List<Movie> books) {
        this.mMovies = books;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(this.context);

        View contactView = inflater.inflate(R.layout.item_movie, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Movie movie = mMovies.get(position);

        // Set item views based on your views and data model
        holder.title.setText(movie.title);
        Glide.with(this.context).load(movie.posterUrl).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title;
        private TextView year;
        private TextView runtime;
        private TextView director;
        private TextView actors;
        private ImageView poster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            poster = itemView.findViewById(R.id.imageMovie);
            title = itemView.findViewById(R.id.titleMovie);
            year = itemView.findViewById(R.id.yearMovie);
            runtime = itemView.findViewById(R.id.runtimeMovie);
            director = itemView.findViewById(R.id.directorMovie);
            actors = itemView.findViewById(R.id.actorsMovie);

        }

        @Override
        public void onClick(View view) {

        }
    }
}
