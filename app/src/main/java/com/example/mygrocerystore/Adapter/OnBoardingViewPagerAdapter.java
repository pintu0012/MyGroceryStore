package com.example.mygrocerystore.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.mygrocerystore.Model.OnBoardingModel;
import com.example.mygrocerystore.R;

import java.util.ArrayList;

public class OnBoardingViewPagerAdapter extends PagerAdapter {

    Context context;
    private ArrayList<OnBoardingModel> itemList;
//    int[] bgColor = {
//            R.color.intro_color_first,
//            R.color.intro_color_second,
//            R.color.intro_color_third
//    };
//    int[] mResources = {
//            R.drawable.first_intro_image,
//
//            R.drawable.second_intro_image,
//
//            R.drawable.third_intro_image};
//    int[] images = {
//            R.drawable.intro_one,
//
//            R.drawable.intro_second,
//
//            R.drawable.intro_third};


    public OnBoardingViewPagerAdapter(Context context, ArrayList<OnBoardingModel> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View item = LayoutInflater.from(container.getContext()).inflate(R.layout.on_boarding_viepager_item, container, false);
        ImageView imageView = item.findViewById(R.id.imageview);
//        RelativeLayout mainRelative = item.findViewById(R.id.view_pager_main_relative);
        TextView titleText = item.findViewById(R.id.pager_title);
//        TextView descText = item.findViewById(R.id.pager_desc);
//        CircleImageView introImages = item.findViewById(R.id.image_for_intro);
//        imageView.setImageResource(mResources[position]);
////        introImages.setImageResource(images[position]);
//        descText.setText(itemList.get(position).getTitle());
//        Log.e("IMAGEEurl==", itemList.get(position).getUrl());
//
//        String imageLink = itemList.get(position).getUrl()+"/"+itemList.get(position).getImage();
//        System.out.println("BannerImageLink==" + imageLink);
//        final ProgressBar progressBar = item.findViewById(R.id.view_pager_progress);
//        if (itemList.get(position).getImage() != null && !itemList.get(position).getImage().equals("")) {
//            System.out.println("BannerImageLink==" + imageLink);
//            progressBar.setVisibility(View.VISIBLE);
//            Picasso
//                    .get()
//                    .load(imageLink)
//                    .placeholder(R.drawable.placeholder)
//                    .error(R.drawable.placeholder)
//                    .into(introImages, new Callback() {
//                        @Override
//                        public void onSuccess() {
//                            progressBar.setVisibility(View.GONE);
//                        }
//
//                        @Override
//                        public void onError(Exception e) {
//                            progressBar.setVisibility(View.GONE);
//                        }
//                    });
//        }
        titleText.setText(itemList.get(position).getTitle());
//        descText.setText(itemList.get(position).getDescription());

//       cardView.setCardBackgroundColor(ContextCompat.getColor(container.getContext(), (items.get(position).color)));

//        container.addView(item);
        return item;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
