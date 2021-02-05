package com.example.android.mathematicstrainingmode;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciseTwo extends AppCompatActivity {

    // TODO make the questions...

    final int totalSec = 60;
    private LinearLayout[] _sixtyOfALine = new LinearLayout[totalSec];

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

                RelativeLayout butOne = findViewById(R.id.one);
                butOne.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        tvTime.setText(tvTime.getText() + "1");
//                        startTime = System.currentTimeMillis() - 1000;
//                        for (int i = 0; i < totalSec; i++) {
//                            _sixtyOfALine[i].setVisibility(View.VISIBLE);
//                        }
                    }
                });

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

    private String mathematicsQuestions(int levelNum) {
        String question = "";
        double num;
        double min, max;

        if (levelNum >= 1 && levelNum <= 100) {
            // phase 2 (integers)

            min = levelNum;
            max = levelNum * 5 + 15;
            num = (int) (Math.random() * (max - min + 1) + min);

            int ranNegPosNum1 = (int) (Math.random() * 2 + 1);
            int ranNegPosNum2 = (int) (Math.random() * 2 + 1);

            String neg1, neg2;
            if (ranNegPosNum1 == 2) { neg1 = "-"; } else { neg1 = ""; }
            if (ranNegPosNum2 == 2) { neg2 = "-"; } else { neg2 = ""; }

            checkAnswer(num, ranNegPosNum1);
            question = neg1 + "|" + neg2 + num + "| = ";
        }

        return question;
    }

    private double checkAnswer(double num, int ranNegPosSign1) {
        Math.abs(num);
        if (ranNegPosSign1 == 2) { num *= -1; }
        System.out.println("answer = " + num);
        return num;
    }

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