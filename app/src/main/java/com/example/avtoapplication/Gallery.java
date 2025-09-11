package com.example.avtoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Gallery extends AppCompatActivity {



//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_gallery);

    private HorizontalScrollView horizontalScrollView;

    private ImageButton buttonScrollLeft;
    private ImageButton buttonScrollRight;
    private ImageButton bmwbutton; // кнопка перехода на bmw


    private ImageButton bmwprev; // кнопка перехода назад



    private  ImageButton bmwgalleryClick;

    public static final int SCROLL_DELTA = 100; // Pixel.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        horizontalScrollView = findViewById(R.id.sroll);

        buttonScrollLeft =  findViewById(R.id.leftButton);
        buttonScrollRight =  findViewById(R.id.rightButton);

        bmwbutton = findViewById(R.id.bmv_gallery);

        bmwgalleryClick =findViewById(R.id.imageBmw);

        bmwprev = findViewById(R.id.preview);




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

       bmwbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(Gallery.this,Bmw.class);
               startActivity(intent);
           }
       });
//  кнопка на галлерею БМВ
       bmwgalleryClick.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(Gallery.this,Bmw.class);
               startActivity(intent);
           }
       });
    // Кнопка назажд на главную

        bmwprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gallery.this,MainActivity.class);
                startActivity(intent);
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


