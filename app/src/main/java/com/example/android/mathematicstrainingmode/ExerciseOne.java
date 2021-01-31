package com.example.android.mathematicstrainingmode;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciseOne extends AppCompatActivity {

    // TODO make the questions...

    final int totalSec = 60;
    private LinearLayout[] _sixtyOfALine = new LinearLayout[totalSec];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_one);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getApplicationContext().getResources().getColor(R.color.dark_bg));
        }

        buttonIntents();

        int levelNum = getIntent().getIntExtra("levelnum", 1);
        TextView actionbarTitle = findViewById(R.id.action_bar_title_exercise_one);
        actionbarTitle.setText(getApplicationContext().getString(R.string.assigning_numbers_their_places) + ". Level: " + levelNum + " / " + 100);

        // ------------------- <Make Mathematical Questions! (begins) -----------------

        String question = "Which is larger, ";
        double num1, num2;

        if (levelNum >= 1 && levelNum < 20) {
            // fase 1 (natural numbers)
            num1 = Math.random() + 1;
            num2 = Math.random() + 1;
        } else if (levelNum >= 20 && levelNum < 40) {
            // fase 2 (integers)

        } else if (levelNum >= 40 && levelNum < 60) {
            // fase 3 (decimals)

        } else if (levelNum >= 60 && levelNum < 80) {
            // fase 4 (fractions)

        } else if (levelNum >= 80 && levelNum < 100) {
            // fase 5 (mix of all 4 fases)

        } else if (levelNum == 100) {
            // fase 6 (final fase - all fases but on max difficulty)

        }

        // ------------------- <Make Mathematical Questions! (ends) -----------------

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

        final TextView tvTime = findViewById(R.id.question);
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

                Button butB = findViewById(R.id.button_B);
                butB.setOnClickListener(new View.OnClickListener() {
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
                                _sixtyOfALine[(int) (totalSec - ((System.currentTimeMillis() - startTime) / 1000))].setVisibility(View.INVISIBLE);
//                                tvTime.setText("" + (int) (totalSec - ((System.currentTimeMillis() - startTime) / 1000)));
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