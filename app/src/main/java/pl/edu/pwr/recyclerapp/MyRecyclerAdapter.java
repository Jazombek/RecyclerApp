package pl.edu.pwr.recyclerapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private List<AnimeItem> animeList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,category;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            name =  view.findViewById(R.id.nameTextView);
            category =  view.findViewById(R.id.categoryTextView);
            image = view.findViewById(R.id.personImageView);

        }
    }


    public MyRecyclerAdapter(List<AnimeItem> moviesList) {
        this.animeList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.anime_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AnimeItem item = animeList.get(position);
        holder.name.setText(item.getName());
        holder.category.setText(item.getCategory());
        holder.image.setImageResource(item.getImage());

    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }

    public List<AnimeItem> getList(){
        return animeList;
    }

    public void removeItem(int position) {
        animeList.remove(position);

        notifyItemRemoved(position);
    }
}
