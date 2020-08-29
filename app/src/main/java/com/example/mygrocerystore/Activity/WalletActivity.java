package com.example.mygrocerystore.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.mygrocerystore.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WalletActivity extends BaseActivity {


    ImageButton back_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialiseViews();

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(WalletActivity.this, MainActivity.class));
            }
        });
    }

    private void initialiseViews() {
        back_button = findViewById(R.id.back_button);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_wallet;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.wallet;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        startActivity(new Intent(WalletActivity.this, MainActivity.class));
    }
}
