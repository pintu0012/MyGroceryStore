package com.example.mygrocerystore.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygrocerystore.Model.OffersModel;
import com.example.mygrocerystore.R;

import java.util.ArrayList;

public class OffersRecyclerVIewAdapter extends RecyclerView.Adapter<OffersRecyclerVIewAdapter.ViewHolder> {

    private ArrayList<OffersModel> itemList;
    private Context context;
    private CardView cardView;


    public OffersRecyclerVIewAdapter(Context context, ArrayList<OffersModel> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        // Calling this function will help you to change the card view background color dynamically.
        applyCategoryCardViewBackgroundColor(position);
//        cardView.setCardBackgroundColor(itemList.get(position).getColor());
        viewHolder.imageView.setImageResource(itemList.get(position).getImage());
        viewHolder.title.setText(itemList.get(position).getTitle());

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_pager_layout, parent, false);
        cardView = v.findViewById(R.id.cardview);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    // Change the card background color dynamically
    private void applyCategoryCardViewBackgroundColor(int position) {
        int incrementalPosition = position + 1;
        if (incrementalPosition % 3 == 0) {
            cardView.setCardBackgroundColor(Color.parseColor("#29D0A8"));
        } else if ((incrementalPosition - 2) % 3 == 0) {
            cardView.setCardBackgroundColor(Color.parseColor("#F65053"));
        } else {
            cardView.setCardBackgroundColor(Color.parseColor("#594CF5"));
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imageView;

        public ViewHolder(final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            title= itemView.findViewById(R.id.title);

        }

    }

}
