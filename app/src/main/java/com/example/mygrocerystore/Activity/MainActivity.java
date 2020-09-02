package com.example.mygrocerystore.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.mygrocerystore.Adapter.CategoryListViewAdapter;
import com.example.mygrocerystore.Adapter.OffersRecyclerVIewAdapter;
import com.example.mygrocerystore.Common.ExpandableHeightGridView;
import com.example.mygrocerystore.Model.CategoryItemModel;
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
        ArrayList<CategoryItemModel> categoryItemModelArrayList = new ArrayList<>();

        categoryItemModelArrayList.add(new CategoryItemModel(0,R.drawable.onion, "Onion", "1KG","$80", true));
        categoryItemModelArrayList.add(new CategoryItemModel(0,R.drawable.potato, "Potato", "1KG","$45", true));
        categoryItemModelArrayList.add(new CategoryItemModel(0,R.drawable.tomato, "Tomato", "1KG","$40", false));
        categoryItemModelArrayList.add(new CategoryItemModel(0,R.drawable.capsicum, "Capsicum", "1KG","$35", true));
        categoryItemModelArrayList.add(new CategoryItemModel(0,R.drawable.mushroom, "Mushrooms", "500GM","$55", true));
        categoryItemModelArrayList.add(new CategoryItemModel(0,R.drawable.broccoli, "Broccoli", "250GM","$25", true));
        categoryItemModelArrayList.add(new CategoryItemModel(0,R.drawable.carrot, "Carrot", "500GM","$45", true));
        categoryItemModelArrayList.add(new CategoryItemModel(0,R.drawable.cabbage, "Cabbage", "1KG","$75", true));
        categoryItemModelArrayList.add(new CategoryItemModel(0,R.drawable.eggplant, "Egg Plant", "500GM","$65", true));


        categoryModelArrayList.add(new CategoryModel(0, R.drawable.vegetable, R.color.bbd_red, "Vegetables", categoryItemModelArrayList));

        categoryItemModelArrayList = new ArrayList<>();
        categoryItemModelArrayList.add(new CategoryItemModel(0,R.drawable.bread_icon, "Bread", "250GM","$40", true));
        categoryItemModelArrayList.add(new CategoryItemModel(0,R.drawable.cake, "Cake", "100GM","$250", true));
        categoryItemModelArrayList.add(new CategoryItemModel(0,R.drawable.cookies, "Cookies", "200GM","$120", true));
        categoryItemModelArrayList.add(new CategoryItemModel(0,R.drawable.cheese, "Cheese", "150GM","$60", true));
        categoryItemModelArrayList.add(new CategoryItemModel(0,R.drawable.muffin, "Muffin", "250GM","$70", true));
        categoryModelArrayList.add(new CategoryModel(1, R.drawable.bread, R.color.yellow, "Bakery", categoryItemModelArrayList));

        categoryItemModelArrayList = new ArrayList<>();
        categoryItemModelArrayList.add(new CategoryItemModel(0,R.drawable.bread_icon, "Bread", "500GM","$65", true));
        categoryItemModelArrayList.add(new CategoryItemModel(0,R.drawable.cake, "Cake", "500GM","$65", true));
        categoryItemModelArrayList.add(new CategoryItemModel(0,R.drawable.cookies, "Cookies", "500GM","$65", true));
        categoryItemModelArrayList.add(new CategoryItemModel(0,R.drawable.cheese, "Cheese", "500GM","$65", true));

        categoryModelArrayList.add(new CategoryModel(2, R.drawable.milk, R.color.green, "Milk", categoryItemModelArrayList));
        categoryModelArrayList.add(new CategoryModel(3, R.drawable.soft_drink, R.color.blue, "Soft drinks", categoryItemModelArrayList));
        categoryModelArrayList.add(new CategoryModel(4, R.drawable.detergent, R.color.bbd_pink, "Detergents", categoryItemModelArrayList));
        categoryModelArrayList.add(new CategoryModel(5, R.drawable.snack, R.color.purple, "Breakfast Snacks", categoryItemModelArrayList));

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
