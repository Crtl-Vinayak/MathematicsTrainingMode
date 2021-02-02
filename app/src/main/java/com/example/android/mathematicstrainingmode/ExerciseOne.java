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

public class ExerciseOne extends AppCompatActivity {

    // TODO make the questions...

    final int totalSec = 60;
    private LinearLayout[] _sixtyOfALine = new LinearLayout[totalSec];

    boolean isAbig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_one);
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
        Runnable runnable = new Runnable() {
            long startTime = System.currentTimeMillis();
            public void run() {

                Button butA = findViewById(R.id.button_A);
                butA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!isAbig) {
                            Intent intent = new Intent(ExerciseOne.this, LevelSelectionExerciseOne.class);
                            startActivity(intent);
                        } else {
                            tvTime.setText(mathematicsQuestions(levelNum));
                        }
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
                        if (isAbig) {
                            Intent intent = new Intent(ExerciseOne.this, LevelSelectionExerciseOne.class);
                            startActivity(intent);
                        } else {
                            tvTime.setText(mathematicsQuestions(levelNum));
                        }
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

    // --------------------------------------------------------- <MAKE MATHEMATICAL QUESTIONS! (BEGINS) -------------------------------------------------------
    
    private String mathematicsQuestions(int levelNum) {
        String question = "Which is larger, ";
        double num1, num2;
        double min, max;
        boolean isNegativeNum1, isNegativeNum2;

        if (levelNum >= 1 && levelNum < 20) {
            // phase 1 (natural numbers)

            min = levelNum;
            max = levelNum * 2 + 1;
            num1 = (int) (Math.random() * (max - min + 1) + min);
            num2 = (int) (Math.random() * (max - min + 1) + min);
            if (num1 == num2) {
                num1 = (int) (Math.random() * (max - min + 1) + min);
                num2 = (int) (Math.random() * (max - min + 1) + min);
                if (num1 == num2) {
                    num2 -= min;
                    num1 += 1;
                }
            }

            checkAnswer(num1, num2);

            DecimalFormat df = new DecimalFormat("###.#");
            question += ("A = " + df.format(num1) + " or B = " + df.format(num2));

        } else if (levelNum >= 20 && levelNum < 40) {
            // phase 2 (integers)

            // TODO fix this phase 2...

//            min = levelNum;
//            max = levelNum * 2 + 1;
//
//            if ((int) (Math.random() * (max - min + 1) + min) % 2 == 0) {
//                isNegativeNum1 = true;
//                num1 = (Math.random() * (max - min + 1) + min) * -1;
//            } else {
//                isNegativeNum1 = false;
//                num1 = Math.random() * (max - min + 1) + min;
//            }
//
//            if ((int) (Math.random() * (max - min + 1) + min) % 2 == 1) {
//                isNegativeNum2 = true;
//                num2 = (Math.random() * (max - min + 1) + min) * -1;
//            } else {
//                isNegativeNum2 = false;
//                num2 = Math.random() * (max - min + 1) + min;
//            }
//
//            if (num1 == num2) {
//                if (isNegativeNum1) {
//                    num1 = Math.random() * (max - min + 1) + min;
//                } else {
//                    num1 = (Math.random() * (max - min + 1) + min) * -1;
//                }
//                if (isNegativeNum2) {
//                    num2 = Math.random() * (max - min + 1) + min;
//                } else {
//                    num2 = (Math.random() * (max - min + 1) + min) * -1;
//                }
//                if (num1 == num2) {
//                    num2 -= (min - 5);
//                    num1 += 5;
//                }
//            }
//
//            checkAnswer(num1, num2);
//
//            DecimalFormat df = new DecimalFormat("###.#");
//            question += ("A = " + df.format(num1) + " or B = " + df.format(num2));

        } else if (levelNum >= 40 && levelNum < 60) {
            // phase 3 (decimals)

            min = levelNum;
            max = levelNum * 2 + 1;

            if ((Math.random() * (10 - 0 + 1) + 0) % 2 == 0) {
                isNegativeNum1 = true;
                num1 = (Math.random() * (max - min + 1) + min) * -1;
            } else {
                isNegativeNum1 = false;
                num1 = Math.random() * (max - min + 1) + min;
            }

            if ((Math.random() * (10 - 0 + 1) + 0) % 2 == 1) {
                isNegativeNum2 = true;
                num2 = (Math.random() * (max - min + 1) + min) * -1;
            } else {
                isNegativeNum2 = false;
                num2 = Math.random() * (max - min + 1) + min;
            }

            if (num1 == num2) {
                if (isNegativeNum1) {
                    num1 = Math.random() * (max - min + 1) + min;
                } else {
                    num1 = (Math.random() * (max - min + 1) + min) * -1;
                }
                if (isNegativeNum2) {
                    num2 = Math.random() * (max - min + 1) + min;
                } else {
                    num2 = (Math.random() * (max - min + 1) + min) * -1;
                }
                if (num1 == num2) {
                    num2 -= (min - 5);
                    num1 += 5;
                }
            }

            checkAnswer(num1, num2);

            DecimalFormat df = new DecimalFormat("#.#");
            question += ("A = " + df.format(num1) + " or B = " + df.format(num2));

        } else if (levelNum >= 60 && levelNum < 80) {
            // phase 4 (fractions)

        } else if (levelNum >= 80 && levelNum < 100) {
            // phase 5 (mix of all 4 phases)

        } else if (levelNum == 100) {
            // phase 6 (final phase - all phases but on max difficulty)

        }

        return question;
    }

    private boolean checkAnswer(double num1, double num2) {
        if (num1 > num2) {
            isAbig = true;
            return true;
        } else {
            isAbig = false;
            return false;
        }
    }
    
    // --------------------------------------------------------- <<MAKE MATHEMATICAL QUESTIONS! (ENDS) -------------------------------------------------------
    
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