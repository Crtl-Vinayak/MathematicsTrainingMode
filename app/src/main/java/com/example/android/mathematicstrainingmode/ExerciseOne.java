package com.example.android.mathematicstrainingmode;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciseOne extends AppCompatActivity {

    // TODO make the questions and set the line in the middle of the screen...
    // TODO line is made out 60 (seconds) Linear layouts with the gray background inside a parent layout, in this case linear layout...

    final int totalSec = 5;
    private LinearLayout[] _sixtyOfALine = new LinearLayout[totalSec];

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

        final TextView tvTime = findViewById(R.id.testtv);
        final boolean[] isTimerDone = {false};
        final int[] stop = {0};

        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            long startTime = System.currentTimeMillis();
            public void run() {

                // button a (and b too in the future...) resets the (line) timer.
                Button butA = findViewById(R.id.button_A);
                butA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startTime = System.currentTimeMillis() - 1000;
                        for (int i = 0; i < totalSec; i++) {
                            _sixtyOfALine[i].setVisibility(View.VISIBLE);
                        }
                    }
                });

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
                                System.out.println(startTime);
                                _sixtyOfALine[(int) (totalSec - ((System.currentTimeMillis() - startTime) / 1000))].setVisibility(View.INVISIBLE);
                                tvTime.setText("" + (int) (totalSec - ((System.currentTimeMillis() - startTime) / 1000)));
                            } else {
                                isTimerDone[0] = true;
                                if (isTimerDone[0]) {
                                    if (stop[0] == 0) {
                                        Intent intent = new Intent(ExerciseOne.this, LevelSelectionExerciseOne.class);
                                        startActivity(intent);
                                        stop[0]++;
                                    }
                                }
                            }
                        }
                    });
                }
            }
        };
        new Thread(runnable).start();
    }

    private void buttonIntents() {
        findViewById(R.id.exercise_one_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExerciseOne.this, LevelSelectionExerciseOne.class);
                startActivity(intent);
            }
        });
    }
}