package com.example.mygrocerystore.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import com.example.mygrocerystore.Activity.CategoryActivity;
import com.example.mygrocerystore.Common.CommonActivity;
import com.example.mygrocerystore.Model.CategoryItemModel;
import com.example.mygrocerystore.Model.CategoryModel;
import com.example.mygrocerystore.R;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

public class CategoryListViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<CategoryModel> arrayList_model;
    private String contentStr = "";
    private CardView cardView;
    private ArrayList<CategoryItemModel> categoryItemModelArrayList = new ArrayList<>();



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

//            applyCategoryCardViewBackgroundColor(position);

            holder.title = convertView.findViewById(R.id.title);
            holder.imageview = convertView.findViewById(R.id.imageview);

            holder.title.setText(arrayList_model.get(position).getTitle());
            holder.imageview.setImageResource(arrayList_model.get(position).getImage());

            holder.imageview.invalidate();
            BitmapDrawable drawable = (BitmapDrawable) holder.imageview.getDrawable();
            Bitmap bitmap = drawable.getBitmap();
            int color = getDominantColor(bitmap);
            int darkColor = manipulateColor(color, 0.9f);
            cardView.setCardBackgroundColor(darkColor);


            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, CategoryActivity.class);
                    holder.title.setTransitionName("titleTransition");
                    Pair<View, String> pair1 = Pair.create((View) holder.title, holder.title.getTransitionName());
                    ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext, pair1);
                    CommonActivity.addCartData(arrayList_model.get(position).getCategoryItemModelArrayList());
                    CommonActivity.setCategoryName(arrayList_model.get(position).getTitle());
                    Log.e("catname-->",arrayList_model.get(position).getTitle());
                    intent.putExtra("title", arrayList_model.get(position).getTitle());
                    mContext.startActivity(intent, optionsCompat.toBundle());
                }
            });


        } else {
            holder = (ViewHolder) convertView.getTag();
        }



        return convertView;
    }

    public static int getDominantColor(Bitmap bitmap) {
        Bitmap newBitmap = Bitmap.createScaledBitmap(bitmap, 1, 1, true);
        final int color = newBitmap.getPixel(0, 0);
        newBitmap.recycle();
        return color;
    }

    public static int manipulateColor(int color, float factor) {
        int a = Color.alpha(color);
        int r = Math.round(Color.red(color) * factor);
        int g = Math.round(Color.green(color) * factor);
        int b = Math.round(Color.blue(color) * factor);
        return Color.argb(a,
                Math.min(r,255),
                Math.min(g,255),
                Math.min(b,255));
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