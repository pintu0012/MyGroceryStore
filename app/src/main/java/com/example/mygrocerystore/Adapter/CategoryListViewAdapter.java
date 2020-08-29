package com.example.mygrocerystore.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.cardview.widget.CardView;

import com.example.mygrocerystore.Model.CategoryModel;
import com.example.mygrocerystore.R;

import org.w3c.dom.Comment;

import java.util.List;

public class CategoryListViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<CategoryModel> arrayList_model;
    private String contentStr = "";
    private CardView cardView;



//    private String cid;

    public CategoryListViewAdapter(Context context, List<CategoryModel> arrayList) {
        this.mContext = context;
        this.arrayList_model = arrayList;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public int getCount() {
        return arrayList_model.size();
    }

    @Override
    public Comment getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(final int position, View convertView,
                              ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            LayoutInflater layoutInflator = LayoutInflater.from(mContext);
            convertView = layoutInflator.inflate(R.layout.category_listview_adapter, null);
            cardView = convertView.findViewById(R.id.cardview);
            holder = new ViewHolder();

            applyCategoryCardViewBackgroundColor(position);
            holder.title = convertView.findViewById(R.id.title);
            holder.imageview = convertView.findViewById(R.id.imageview);

            holder.title.setText(arrayList_model.get(position).getTitle());
            holder.imageview.setImageResource(arrayList_model.get(position).getImage());

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    private class ViewHolder {
        private TextView title;
        private ImageView imageview;
    }

    // Change the card background color dynamically
    private void applyCategoryCardViewBackgroundColor(int position) {
        int incrementalPosition = position + 1;
        if (incrementalPosition % 4 == 0) {
            cardView.setCardBackgroundColor(Color.parseColor("#29D0A8"));
        } else if ((incrementalPosition - 2) % 4 == 0) {
            cardView.setCardBackgroundColor(Color.parseColor("#F65053"));
        } else if ((incrementalPosition - 3) % 4 == 0) {
            cardView.setCardBackgroundColor(Color.parseColor("#594CF5"));
        } else {
            cardView.setCardBackgroundColor(Color.parseColor("#ffc107"));
        }
    }
}