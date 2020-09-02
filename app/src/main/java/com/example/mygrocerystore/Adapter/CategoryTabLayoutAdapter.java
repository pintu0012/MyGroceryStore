package com.example.mygrocerystore.Adapter;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mygrocerystore.Fragments.CategoryFirstFragment;
import com.example.mygrocerystore.Fragments.CategorySecondFragment;
import com.example.mygrocerystore.Fragments.CategoryThirdFragment;
import com.example.mygrocerystore.Model.CategoryItemModel;

import java.io.Serializable;

public class CategoryTabLayoutAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;
    private CategoryItemModel categoryItemModel;

    public CategoryTabLayoutAdapter(CategoryItemModel categoryItemModel, Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
        this.categoryItemModel = categoryItemModel;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                CategoryFirstFragment categoryFirstFragment = new CategoryFirstFragment();
                return categoryFirstFragment;
            case 1:
                CategorySecondFragment categorySecondFragment = new CategorySecondFragment();
                return categorySecondFragment;
            case 2:
                CategoryThirdFragment categoryThirdFragment = new CategoryThirdFragment();
                return categoryThirdFragment;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}