package com.soric.rma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.Red> {

    private List<Game> games;
    private LayoutInflater layoutInflater;
    private ItemClickInterface itemClickInterface;

    public ListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @NonNull
    @Override
    public Red onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.red, parent, false);
        return new Red(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Red holder, int position) {
        Game game = games.get(position);
        holder.rank.setText(String.valueOf(game.getRank()));
        holder.title.setText(game.getTitle());
        holder.developer.setText(game.getDeveloper());
    }

    @Override
    public int getItemCount() {
        return games == null ? 0 : games.size();
    }

    public class Red extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView rank;
        private TextView title;
        private TextView developer;

        public Red(@NonNull View itemView) {
            super(itemView);
            rank = itemView.findViewById(R.id.rank);
            title = itemView.findViewById(R.id.title);
            developer = itemView.findViewById(R.id.developer);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickInterface == null) {
                return;
            }
            itemClickInterface.onItemClick(games.get(getAdapterPosition()));
        }
    }

    public void setItemClickInterface(ItemClickInterface itemClickInterface) {
        this.itemClickInterface = itemClickInterface;
    }
}
