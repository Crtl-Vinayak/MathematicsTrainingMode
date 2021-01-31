package com.example.android.mathematicstrainingmode;

import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class ExerciseOne extends AppCompatActivity {

    // TODO make the questions and set the line in the middle of the screen...
    // TODO line is made out 60 (seconds) Linear layouts with the gray background inside a parent layout, in this case linear layout...

    final int totalSec = 5;
    private LinearLayout[] _sixtyOfALine = new LinearLayout[totalSec];
//    private Handler _handler = new Handler();
//    private int _counter = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_one);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getApplicationContext().getResources().getColor(R.color.dark_bg));
        }

        buttonIntents();

        int levelnum = getIntent().getIntExtra("levelnum", 1);
        System.out.println("level number = " + levelnum);
        TextView actionbarTitle = findViewById(R.id.action_bar_title_exercise_one);
        actionbarTitle.setText(getApplicationContext().getString(R.string.assigning_numbers_their_places) + ". Level: " + levelnum + " / " + 100);

        //line code
        LinearLayout line = findViewById(R.id.exercise_one_line);
        line.setWeightSum(totalSec);

        for (int i = 0; i < totalSec; i++) {
            _sixtyOfALine[i] = new LinearLayout(this);
            _sixtyOfALine[i].setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1));
            _sixtyOfALine[i].setOrientation(LinearLayout.HORIZONTAL);
            _sixtyOfALine[i].setBackgroundColor(getApplicationContext().getResources().getColor(R.color.locked_button));
            line.addView(_sixtyOfALine[i]);
        }

//        try {
//            _handler.removeCallbacks(hMyTimeTask);
//            _handler.postDelayed(hMyTimeTask, 1000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        final TextView tvTime = findViewById(R.id.testtv);
        final boolean[] isTimerDone = {false};

        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            private long startTime = System.currentTimeMillis();
            public void run() {
                while (!isTimerDone[0]) {
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable(){
                        public void run() {
                            if ((int) (totalSec - ((System.currentTimeMillis() - startTime) / 1000)) >= 1) {
                                _sixtyOfALine[(int) (totalSec - ((System.currentTimeMillis() - startTime) / 1000))].setVisibility(View.INVISIBLE);
                                tvTime.setText("" + (int) (totalSec - ((System.currentTimeMillis() - startTime) / 1000)));
                            } else {
                                isTimerDone[0] = true;
                                if (isTimerDone[0]) {
                                    Intent intent = new Intent(ExerciseOne.this, LevelSelectionExerciseOne.class);
                                    startActivity(intent);
                                }
                            }
                        }
                    });
                }
            }
        };
        new Thread(runnable).start();
    }

//    private Runnable hMyTimeTask = new Runnable() {
//        @Override
//        public void run() {
//            _counter--;
//            _sixtyOfALine[_counter].setVisibility(View.INVISIBLE);
//            if (_counter == 0) {
//                _handler.removeCallbacks(hMyTimeTask);
//            }
//        }
//    };

    private void buttonIntents() {
        findViewById(R.id.exercise_one_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExerciseOne.this, LevelSelectionExerciseOne.class);
                startActivity(intent);
            }
        });
    }

//    private Thread _thread = null;
//    private volatile boolean _isRunning;
//
//    private final long MILLIS_PER_SECOND = 1000;
//    private final short FPS = 1;
//
//    @Override
//    public void run() {
//
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        _isRunning = false;
//        try {
//            _thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        _isRunning = true;
//        _thread = new Thread(this);
//        _thread.start();
//    }
}