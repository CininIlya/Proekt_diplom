package com.example.avtoapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Bmw extends AppCompatActivity {

    private HorizontalScrollView horizontalScrollView;
    private ScrollView vertScrollView;

    private ImageButton buttonScrollLeft;
    private ImageButton buttonScrollRight;
    private ImageButton buttonScrollArrow;
    private ImageButton buttonScrollDown;

    private ImageButton  buttonSell;


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


        horizontalScrollView = findViewById(R.id.sroll);
        vertScrollView = findViewById(R.id.scroll_vert);


        buttonScrollLeft = findViewById(R.id.leftButton);
        buttonScrollRight = findViewById(R.id.rightButton);

        buttonScrollArrow = findViewById(R.id.arrowbutton);
        buttonScrollDown = findViewById(R.id.downbutton);

        buttonSell =  findViewById(R.id.sell);





        buttonBmwClickFoto = (ImageButton) findViewById(R.id.imageBmw);
        buttonBmwClickFoto1 = (ImageButton) findViewById(R.id.imagebmw2);


//        ImageButton imageButton = findViewById(R.id.imagebmw2); // Здесь «button» — идентификатор кнопки в XML-макете.
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                 Если кнопка мыши находится за пределами области изображения, вызывается метод
//                view.setVisibility(View.GONE);
//                // Если кнопка мыши входит в область изображения, вызывается метод
//                view.setVisibility(View.VISIBLE);
//            }
//        });


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

        buttonScrollArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doScrollArrow();
            }
        });

        buttonScrollDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doScrollDown();
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


                    horizontalScrollView.scrollTo(250, 250); // смешение картинки вправо
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

                    horizontalScrollView.smoothScrollTo(20, 200); // смешение картинки вправо

                }


            }
        });

        final boolean[] flag = {true};
        buttonSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag[0]) {
                    buttonSell.setImageResource(R.drawable.btnbuy2);
                }else {
                    buttonSell.setImageResource(R.drawable.btnbuy2);
                    flag[0] = !flag[0];
                }
            }
        });



    }

    private void doScrollLeft() {

        int x = horizontalScrollView.getScrollX();
        int y = horizontalScrollView.getScrollY();


        if (x - SCROLL_DELTA >= 0) {
            horizontalScrollView.scrollTo(x - SCROLL_DELTA, y);
        }

    }

    private void doScrollRight() {
        int maxAmount = horizontalScrollView.getMaxScrollAmount();

        int x = this.horizontalScrollView.getScrollX();
        int y = this.horizontalScrollView.getScrollY();

        if (x + SCROLL_DELTA <= maxAmount) {
            this.horizontalScrollView.scrollTo(x + SCROLL_DELTA, y);
        }

    }

    private void doScrollArrow() {

        int x = vertScrollView.getScrollX();
        int y = vertScrollView.getScrollY();

        if (x - SCROLL_DELTA >= 0) {
            vertScrollView.scrollTo(x - SCROLL_DELTA, y);
        }

    }

    private void doScrollDown() {
        int maxAmount = vertScrollView.getMaxScrollAmount();

        int x = this.vertScrollView.getScrollX();
        int y = this.vertScrollView.getScrollY();

        if (x + SCROLL_DELTA <= maxAmount) {
            this.vertScrollView.scrollTo(x + SCROLL_DELTA, y);
        }

    }

}

