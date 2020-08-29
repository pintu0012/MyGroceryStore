package com.example.mygrocerystore.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.mygrocerystore.Adapter.CategoryListViewAdapter;
import com.example.mygrocerystore.Adapter.OffersRecyclerVIewAdapter;
import com.example.mygrocerystore.Common.ExpandableHeightGridView;
import com.example.mygrocerystore.Model.CategoryModel;
import com.example.mygrocerystore.Model.OffersModel;
import com.example.mygrocerystore.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private RecyclerView offersrecylerView;
    private ExpandableHeightGridView category_listview;
    private ImageButton menu_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialiseViews();
        OFFERS_RECYLER();
        CATEGORY_LISTVIEW();

        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDrawer.isDrawerOpen(navigationView)) {
                    mDrawer.closeDrawer(navigationView);
                } else {
                    mDrawer.openDrawer(navigationView);
                }
            }
        });
    }

    private void CATEGORY_LISTVIEW() {

        ArrayList<CategoryModel> categoryModelArrayList = new ArrayList<>();
        categoryModelArrayList.add(new CategoryModel(0, R.drawable.vegetable, R.color.bbd_red, "Vegetables"));
        categoryModelArrayList.add(new CategoryModel(1, R.drawable.vegetable, R.color.yellow, "Bakery"));
        categoryModelArrayList.add(new CategoryModel(2, R.drawable.vegetable, R.color.green, "Milk"));
        categoryModelArrayList.add(new CategoryModel(3, R.drawable.vegetable, R.color.blue, "Soft drinks"));
        categoryModelArrayList.add(new CategoryModel(4, R.drawable.vegetable, R.color.bbd_pink, "Vegetables"));
        categoryModelArrayList.add(new CategoryModel(5, R.drawable.vegetable, R.color.purple, "Vegetables"));
        categoryModelArrayList.add(new CategoryModel(6, R.drawable.vegetable, R.color.bbd_gray, "Vegetables"));
        categoryModelArrayList.add(new CategoryModel(7, R.drawable.vegetable, R.color.bbd_pink, "Vegetables"));

        category_listview.setExpanded(true);
        CategoryListViewAdapter categoryListViewAdapter = new CategoryListViewAdapter(MainActivity.this, categoryModelArrayList);
        category_listview.setAdapter(categoryListViewAdapter);

    }

    private void OFFERS_RECYLER() {
        ArrayList<OffersModel> offersModelArrayList = new ArrayList<>();
        offersModelArrayList.add(new OffersModel(0, R.drawable.bread, "Get Special Offers on Bakery", R.color.bbd_red));
        offersModelArrayList.add(new OffersModel(0, R.drawable.bread, "Get Special Offers on Bakery", R.color.yellow));
        offersModelArrayList.add(new OffersModel(0, R.drawable.bread, "Get Special Offers on Bakery", R.color.green));
        OffersRecyclerVIewAdapter offersRecyclerVIewAdapter = new OffersRecyclerVIewAdapter(MainActivity.this, offersModelArrayList);
        LinearLayoutManager linearManagerV = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        offersrecylerView.setLayoutManager(linearManagerV);
        offersrecylerView.setAdapter(offersRecyclerVIewAdapter);

    }

    private void initialiseViews() {
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        menu_button = findViewById(R.id.menu_button);
        category_listview = findViewById(R.id.category_listview);
        offersrecylerView = findViewById(R.id.offers_recycler);
    }

    @Override
    int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.home;
    }

}
