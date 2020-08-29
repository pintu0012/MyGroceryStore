package com.example.mygrocerystore.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.mygrocerystore.R;

public class ChatActivity extends AppCompatActivity {

    ImageButton back_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initialiseViews();

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(ChatActivity.this, MainActivity.class));
                overridePendingTransition(0, 0);
            }
        });
    }

    private void initialiseViews() {
        back_button = findViewById(R.id.back_button);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent intent = new Intent(ChatActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

}
