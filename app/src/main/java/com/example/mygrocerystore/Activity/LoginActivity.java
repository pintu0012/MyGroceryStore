package com.example.mygrocerystore.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.mygrocerystore.Adapter.OnBoardingViewPagerAdapter;
import com.example.mygrocerystore.Model.OnBoardingModel;
import com.example.mygrocerystore.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class LoginActivity extends AppCompatActivity {

    private ViewPager intro_viewpager;
    private TabLayout tab_layout;
    private ArrayList<OnBoardingModel> onBoardingModelArrayList;
    private int currentPage =0;
    Timer timer;
    final long DELAY_MS = 500;
    final long PERIOD_MS = 7000;
    private Button continue_login,login_now;
    RelativeLayout otp_card_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialiseViews();

        getSliderView();

        intro_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                currentPage = intro_viewpager.getCurrentItem();
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        continue_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otp_card_layout.setVisibility(View.VISIBLE);
            }
        });

        login_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
    }

    private void getSliderView() {
        onBoardingModelArrayList = new ArrayList<>();
        onBoardingModelArrayList.add(new OnBoardingModel("", "", "", ""));
        onBoardingModelArrayList.add(new OnBoardingModel("", "", "", ""));
        onBoardingModelArrayList.add(new OnBoardingModel("", "", "", ""));

        final OnBoardingViewPagerAdapter adapter = new OnBoardingViewPagerAdapter(LoginActivity.this, onBoardingModelArrayList);
        intro_viewpager.setAdapter(adapter);
        try {
            final Handler handler = new Handler();
            final Runnable Update = new Runnable() {
                public void run() {
                    if (currentPage == adapter.getCount()) {
                        currentPage = 0;
                    }
                    intro_viewpager.setCurrentItem(currentPage++, true);
                }
            };

            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(Update);
                    Log.e("Login", String.valueOf(currentPage));
                }
            }, DELAY_MS, PERIOD_MS);
        } catch (NullPointerException ne) {
            ne.printStackTrace();
        }
    }

    private void initialiseViews() {
        login_now = findViewById(R.id.login_now);
        otp_card_layout = findViewById(R.id.otp_card_layout);
        continue_login = findViewById(R.id.continue_login);
        tab_layout = findViewById(R.id.tab_layout);
        intro_viewpager = findViewById(R.id.intro_viewpager);
    }
}
