package com.example.mygrocerystore.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mygrocerystore.Adapter.CategoryTabLayoutAdapter;
import com.example.mygrocerystore.Model.CategoryItemModel;
import com.example.mygrocerystore.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView actionbar_title;
    private ImageButton back_button;
    private CategoryItemModel categoryItemModel;
    private String title="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        initialiseViews();

        if (getIntent().getExtras()!=null){
            title = getIntent().getStringExtra("title");
            actionbar_title.setText(title);
        }

        getWindow().setSharedElementEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.shared_element_transition));
        actionbar_title.setTransitionName("titleTransition");

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                supportFinishAfterTransition();
//                finish();
            }
        });

        SET_TABLAYOUT();


    }

    private void SET_TABLAYOUT() {
        tabLayout.addTab(tabLayout.newTab().setText("All"));
        tabLayout.addTab(tabLayout.newTab().setText("Organic"));
        tabLayout.addTab(tabLayout.newTab().setText("Exotic"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        CategoryTabLayoutAdapter categoryTabLayoutAdapter = new CategoryTabLayoutAdapter(categoryItemModel,CategoryActivity.this, getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(categoryTabLayoutAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initialiseViews() {
        tabLayout= findViewById(R.id.tabLayout);
        viewPager= findViewById(R.id.pager);
        actionbar_title = findViewById(R.id.actionbar_title);
        back_button = findViewById(R.id.back_button);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition();
    }
}
