package com.example.avtoapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Timer;
import java.util.TimerTask;

public class Bmw extends AppCompatActivity {


    private DBHelper dbhelper;

    private AdapterContact adapterContact;
    private HorizontalScrollView horizontalScrollView;
    private ScrollView vertScrollView;

    private ImageButton buttonScrollLeft;
    private ImageButton buttonScrollRight;
    private ImageButton buttonScrollArrow;
    private ImageButton buttonScrollDown;

    private ImageButton buttonSell;

    private ImageView imageReserved;


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


        dbhelper = new DBHelper(this);// инициализациия баззы данных dbhelper


        horizontalScrollView = findViewById(R.id.sroll);
        vertScrollView = findViewById(R.id.scroll_vert);


        buttonScrollLeft = findViewById(R.id.leftButton);
        buttonScrollRight = findViewById(R.id.rightButton);

        buttonScrollArrow = findViewById(R.id.arrowbutton);
        buttonScrollDown = findViewById(R.id.downbutton);

        buttonSell = findViewById(R.id.sell);

        imageReserved = (ImageView) findViewById(R.id.img_reserved);


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
//        final boolean[] flag = {true};
//        buttonSell.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                flag[0] = !flag[0];
//                if (flag[0]) {
//                    buttonSell.setImageResource(R.drawable.btnbuy);
//
//                } else {
//                    imageReserved.setImageResource(R.drawable.btnbuy2);
////                    buttonSell.setVisibility(View.INVISIBLE);

//
//                }
//
//            }
//        });
//

        // метод нажатия на кнопку с одним нажатием отрывается картика с двойным переход на заказы
        final CountDownTimer[] countDownTimer = {null};

        final int[] click_duble = {1};

        buttonSell.setOnClickListener(view -> {

            if (countDownTimer[0] == null) {
                float Second = (float) 0.25; //Detecting the type of event within a quarter of a second
                countDownTimer[0] = new CountDownTimer((long) (Second * 1000), 50) {
                    @Override
                    public void onTick(long l) {
                    }

                    @Override
                    public void onFinish() {
                        if (click_duble[0] >= 2) {
                            Toast.makeText(Bmw.this, "Double", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Bmw.this, AddEditContact.class);
                            startActivity(intent);
                            buttonSell.setVisibility(View.INVISIBLE);
                        } else {
                            Toast.makeText(Bmw.this, "Single", Toast.LENGTH_SHORT).show();
                            imageReserved.setImageResource(R.drawable.btnbuy2);
                        }
                        click_duble[0] = 1;
                        countDownTimer[0] = null;
                    }
                };
                countDownTimer[0].start();
            } else {
                click_duble[0] += 1;

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


//        buttonSell.setOnClickListener(new DoubleClickListener() {
//            @Override
//            public void onDoubleClick(View v) {
//                Toast.makeText(getApplicationContext(), "Double Click", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Bmw.this, Activity_zakaz.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//    public abstract class DoubleClickListener implements View.OnClickListener {
//        private long lastClickTime = 0;
//
//        @Override
//        public void onClick(View v) {
//            long clickTime = System.currentTimeMillis();
//            if (clickTime - lastClickTime < DOUBLE_CLICK_TIME_DELTA) {
//                onDoubleClick(v);
//            }
//            lastClickTime = clickTime;
//        }



//        public abstract void onDoubleClick(View v);
//
//        private static final long DOUBLE_CLICK_TIME_DELTA = 300; // milliseconds

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

