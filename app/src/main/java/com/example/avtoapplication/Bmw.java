package com.example.avtoapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bmw extends AppCompatActivity {

    private HorizontalScrollView horizontalScrollView;

    private ImageButton buttonScrollLeft;
    private ImageButton buttonScrollRight;

    private ImageButton buttonBmwClickFoto;
    private ImageButton buttonBmwClickFoto1;

    boolean flag = true;

//    private boolean isImageScaled = false;

    private boolean isImageFitToScreen = false;
    public static final int SCROLL_DELTA = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmw);
        
        ImageButton button = findViewById(R.id.imageBmw); // Здесь «button» — идентификатор кнопки в XML-макете.  
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Если кнопка мыши находится за пределами области изображения, вызывается метод `setVisibility(View.GONE)`.  
                // Если кнопка мыши входит в область изображения, вызывается метод `
                 setVisibility(View.VISIBLE); 
            }

            private void setVisibility(int visible) {

            }
        });


        horizontalScrollView = findViewById(R.id.sroll);

        buttonScrollLeft =  findViewById(R.id.leftButton);
        buttonScrollRight =  findViewById(R.id.rightButton);


        buttonBmwClickFoto = findViewById(R.id.imageBmw);
        buttonBmwClickFoto1 = findViewById(R.id.imagebmw2);


        ImageButton imageButton = findViewById(R.id.imagebmw2); // Здесь «button» — идентификатор кнопки в XML-макете.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                 Если кнопка мыши находится за пределами области изображения, вызывается метод
            view.setVisibility(View.GONE);
                // Если кнопка мыши входит в область изображения, вызывается метод
                view.setVisibility(View.VISIBLE);
            }
        });


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

//        // увелиение миниатуры фото прокрутки
//            buttonBmwClickFoto.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (!isImageScaled) v.animate().scaleX(5.4f).scaleY(5.4f).setDuration(500);
//                    if (isImageScaled) v.animate().scaleX(1f).scaleY(1f).setDuration(500);
//                    isImageScaled = !isImageScaled;

        buttonBmwClickFoto.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (isImageFitToScreen) {
                isImageFitToScreen = false;

                buttonBmwClickFoto.setLayoutParams(new LinearLayout.LayoutParams(200, 200));
                buttonBmwClickFoto.setAdjustViewBounds(true);
            } else {
                isImageFitToScreen = true;
                buttonBmwClickFoto.setLayoutParams(new LinearLayout.LayoutParams(600, 600));

                buttonBmwClickFoto.setScaleType(ImageView.ScaleType.FIT_START);
//                buttonBmwClickFoto.setImageResource(R.drawable.bmw_m5_vnut6);
            }


        }

            });

        buttonBmwClickFoto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isImageFitToScreen) {
                    isImageFitToScreen = false;

                    buttonBmwClickFoto1.setLayoutParams(new LinearLayout.LayoutParams(200, 200));
                    buttonBmwClickFoto1.setAdjustViewBounds(true);
                } else {
                    isImageFitToScreen = true;
                    buttonBmwClickFoto1.setLayoutParams(new LinearLayout.LayoutParams(600, 600));

                    buttonBmwClickFoto1.setScaleType(ImageView.ScaleType.FIT_START);
//
                }
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


//        Dialog dialog = new Dialog(this) {
//            @Override
//            public boolean onTouchEvent(MotionEvent event) {
//// Коснитесь в любом месте, чтобы закрыть диалоговое окно
//                this.dismiss();
//                return true;
//            }
//        };
    }
}