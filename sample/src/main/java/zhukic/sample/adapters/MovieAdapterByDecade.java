package zhukic.sample.adapters;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhukic.sectionedrecyclerview.SectionedRecyclerAdapter;

import java.util.List;

import zhukic.sample.Movie;
import zhukic.sectionedrecyclerview.R;

/**
 * Created by Vladislav Zhukov on 04.09.2016.
 */
public class MovieAdapterByDecade extends BaseMovieAdapter {

    public MovieAdapterByDecade(List<Movie> itemList) {
        super(itemList);
    }

    @Override
    public boolean onItems(Movie o1, Movie o2) {
        return o1.getYear() / 10 != o2.getYear() / 10;
    }

    @Override
    public void onBindItemViewHolder(final MovieViewHolder holder, final int position) {
        final Movie movie = movieList.get(position);

        holder.textMovieName.setText(movie.getName());
        holder.textMovieGenre.setText(movie.getGenre());
        holder.textMovieYear.setText(String.valueOf(movie.getYear()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClicked(holder.getAdapterPosition(), position);
            }
        });
    }

    @Override
    public void onBindSubheaderViewHolder(SubheaderHolder subheaderHolder, int nextItemPosition) {
        final Movie nextMovie = movieList.get(nextItemPosition);
        String decade = String.valueOf(nextMovie.getYear() - nextMovie.getYear() % 10) + "s";
        subheaderHolder.mSubheaderText.setText(decade);
    }
}
