package com.example.mygrocerystore.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.mygrocerystore.R;

public class OrdersActivity extends BaseActivity {

    ImageButton back_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialiseViews();

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(OrdersActivity.this, MainActivity.class));
            }
        });
    }

    private void initialiseViews() {
        back_button = findViewById(R.id.back_button);
    }

    @Override
    int getContentViewId() {
        return R.layout.activity_orders;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.orders;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        startActivity(new Intent(OrdersActivity.this, MainActivity.class));
    }

}
