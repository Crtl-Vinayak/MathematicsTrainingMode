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

import java.text.DecimalFormat;

public class ExerciseTwo extends AppCompatActivity {

    // TODO make the questions...

    final int totalSec = 60;
    private LinearLayout[] _sixtyOfALine = new LinearLayout[totalSec];

    boolean isAbig;
    Thread thread;

    boolean isBackButtonPressed = false;
    boolean isWrongAnswered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_two);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getApplicationContext().getResources().getColor(R.color.dark_bg));
        }

        buttonIntents();

        final int levelNum = getIntent().getIntExtra("levelnum", 1);
        TextView actionbarTitle = findViewById(R.id.action_bar_title_exercise_one);
        actionbarTitle.setText(getApplicationContext().getString(R.string.assigning_numbers_their_places) + ". Level: " + levelNum + " / " + 100);

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
        tvTime.setText(mathematicsQuestions(levelNum));
        final boolean[] isTimerDone = {false};
        final int[] stop = {0};

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            long startTime = System.currentTimeMillis();
            public void run() {

                // TODO use now the number pad and not the button a or b!

//                Button butA = findViewById(R.id.button_A);
//                butA.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (!isAbig) {
//                            isWrongAnswered = true;
//                            Intent intent = new Intent(ExerciseTwo.this, LevelSelectionExerciseOne.class);
//                            startActivity(intent);
//                        } else {
//                            tvTime.setText(mathematicsQuestions(levelNum));
//                        }
//                        startTime = System.currentTimeMillis() - 1000;
//                        for (int i = 0; i < totalSec; i++) {
//                            _sixtyOfALine[i].setVisibility(View.VISIBLE);
//                        }
//                    }
//                });
//
//                Button butB = findViewById(R.id.button_B);
//                butB.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (isAbig) {
//                            isWrongAnswered = true;
//                            Intent intent = new Intent(ExerciseTwo.this, LevelSelectionExerciseOne.class);
//                            startActivity(intent);
//                        } else {
//                            tvTime.setText(mathematicsQuestions(levelNum));
//                        }
//                        startTime = System.currentTimeMillis() - 1000;
//                        for (int i = 0; i < totalSec; i++) {
//                            _sixtyOfALine[i].setVisibility(View.VISIBLE);
//                        }
//                    }
//                });

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
                            } else {
                                isTimerDone[0] = true;
                                if (isTimerDone[0]) {
                                    if (stop[0] == 0 && isBackButtonPressed == false && isWrongAnswered == false) {
                                        Intent intent = new Intent(ExerciseTwo.this, LevelSelectionExerciseTwo.class);
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
        thread = new Thread(runnable);
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    // --------------------------------------------------------- <MAKE MATHEMATICAL QUESTIONS! (BEGINS) -------------------------------------------------------

//    private String mathematicsQuestions(int levelNum) {
//        String question = "Which is larger, ";
//        double num;
//        double min, max;
//        int numerator1, numerator2;
//        int denominator1,  denominator2;
//        int minNumerator, maxNumerator;
//
//        if (levelNum >= 1 && levelNum <= 100) {
//        // phase 2 (integers)
//
////            int ranNegPosNum1 = (int) (Math.random() * 2 + 1);
////            int ranNegPosNum2 = (int) (Math.random() * 2 + 1);
////            if (ranNegPosNum1 == 2) { ranNegPosNum1 = -1; }
////            if (ranNegPosNum2 == 2) { ranNegPosNum2 = -1; }
//
//        min = levelNum;
//        max = levelNum * 5 + 10;
//        num1 = (int) ((Math.random() * (max - min + 1) + min) * ranNegPosNum1);
//        num2 = (int) ((Math.random() * (max - min + 1) + min) * ranNegPosNum2);
//        if (num1 == num2) {
//            num1 = (int) ((Math.random() * (max - min + 1) + min) * ranNegPosNum1);
//            num2 = (int) ((Math.random() * (max - min + 1) + min) * ranNegPosNum2);
//            if (num1 == num2) {
//                num2 -= min;
//                num1 += 2;
//            }
//        }
//
//        checkAnswer(num);
//
//        DecimalFormat df = new DecimalFormat("###.#");
//        question += ("A = " + df.format(num1) + " or B = " + df.format(num2));
//
//        }
//            return question;
//    }
//
//    private boolean checkAnswer(double num) {
//        if (num1 > num2) {
//            isAbig = true;
//            return true;
//        } else {
//            isAbig = false;
//            return false;
//        }
//    }

    // --------------------------------------------------------- <<MAKE MATHEMATICAL QUESTIONS! (ENDS) -------------------------------------------------------

    private void buttonIntents() {
        findViewById(R.id.exercise_one_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isBackButtonPressed = true;
                Intent intent = new Intent(ExerciseTwo.this, LevelSelectionExerciseTwo.class);
                startActivity(intent);
            }
        });
    }
}