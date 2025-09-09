package com.example.avtoapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bmw extends AppCompatActivity {

    private HorizontalScrollView horizontalScrollView;

    private ImageButton buttonScrollLeft;
    private ImageButton buttonScrollRight;

    public static final int SCROLL_DELTA = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmw);



        horizontalScrollView = findViewById(R.id.sroll);

        buttonScrollLeft =  findViewById(R.id.leftButton);
        buttonScrollRight =  findViewById(R.id.rightButton);

        buttonScrollLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doScrollLeft();
            }
        });

        buttonScrollRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doScrollRight();
            }
        });
    }
    private void doScrollLeft() {

        int x = horizontalScrollView.getScrollX();
        int y = horizontalScrollView.getScrollY();

        if(x - SCROLL_DELTA >= 0) {
            horizontalScrollView.scrollTo(x - SCROLL_DELTA, y);
        }

    }

    private void doScrollRight() {
        int maxAmount = horizontalScrollView.getMaxScrollAmount();

        int x = this.horizontalScrollView.getScrollX();
        int y = this.horizontalScrollView.getScrollY();

        if(x + SCROLL_DELTA <= maxAmount) {
            this.horizontalScrollView.scrollTo(x + SCROLL_DELTA, y);
        }
    }
}