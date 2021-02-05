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

import java.text.DecimalFormat;

public class ExerciseTwo extends AppCompatActivity {

    // TODO make the questions...

    final int totalSec = 60;
    private LinearLayout[] _sixtyOfALine = new LinearLayout[totalSec];

    Thread thread;

    boolean isBackButtonPressed = false;
    boolean isWrongAnswered = false;

    String answer = "";
    String userInput = "";

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

        final RelativeLayout butOne = findViewById(R.id.one);
        final RelativeLayout butTwo = findViewById(R.id.two);
        final RelativeLayout butThree = findViewById(R.id.three);
        final RelativeLayout butFour = findViewById(R.id.four);
        final RelativeLayout butFive = findViewById(R.id.five);
        final RelativeLayout butSix = findViewById(R.id.six);
        final RelativeLayout butSeven = findViewById(R.id.seven);
        final RelativeLayout butEight = findViewById(R.id.eight);
        final RelativeLayout butNine = findViewById(R.id.nine);
        final RelativeLayout butZero = findViewById(R.id.zero);
        final RelativeLayout butMinus = findViewById(R.id.minus);
        final RelativeLayout butBackspace = findViewById(R.id.backspace);

        final TextView tvTime = findViewById(R.id.question);
        tvTime.setText(mathematicsQuestions(levelNum));
        final boolean[] isTimerDone = {false};
        final int[] stop = {0};

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            long startTime = System.currentTimeMillis();
            public void run() {

                // TODO use now the number pad and not the button a or b!

                butOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        userInput += "1";
                        tvTime.setText(tvTime.getText() + "1");
                        if (answer == userInput) {
                            startTime = System.currentTimeMillis() - 1000;
                            for (int i = 0; i < totalSec; i++) {
                                _sixtyOfALine[i].setVisibility(View.VISIBLE);
                            }
                        }
                        testUserInputAnswer();
                    }
                });

                butTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        userInput += "2";
                        tvTime.setText(tvTime.getText() + "2");
                        if (answer == userInput) {
                            startTime = System.currentTimeMillis() - 1000;
                            for (int i = 0; i < totalSec; i++) {
                                _sixtyOfALine[i].setVisibility(View.VISIBLE);
                            }
                        }
                        testUserInputAnswer();
                    }
                });

                butThree.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        userInput += "3";
                        tvTime.setText(tvTime.getText() + "3");
                        if (answer == userInput) {
                            startTime = System.currentTimeMillis() - 1000;
                            for (int i = 0; i < totalSec; i++) {
                                _sixtyOfALine[i].setVisibility(View.VISIBLE);
                            }
                        }
                        testUserInputAnswer();
                    }
                });

                butFour.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        userInput += "4";
                        tvTime.setText(tvTime.getText() + "4");
                        if (answer == userInput) {
                            startTime = System.currentTimeMillis() - 1000;
                            for (int i = 0; i < totalSec; i++) {
                                _sixtyOfALine[i].setVisibility(View.VISIBLE);
                            }
                        }
                        testUserInputAnswer();
                    }
                });

                butFive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        userInput += "5";
                        tvTime.setText(tvTime.getText() + "5");
                        if (answer == userInput) {
                            startTime = System.currentTimeMillis() - 1000;
                            for (int i = 0; i < totalSec; i++) {
                                _sixtyOfALine[i].setVisibility(View.VISIBLE);
                            }
                        }
                        testUserInputAnswer();
                    }
                });

                butSix.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        userInput += "6";
                        tvTime.setText(tvTime.getText() + "6");
                        if (answer == userInput) {
                            startTime = System.currentTimeMillis() - 1000;
                            for (int i = 0; i < totalSec; i++) {
                                _sixtyOfALine[i].setVisibility(View.VISIBLE);
                            }
                        }
                        testUserInputAnswer();
                    }
                });

                butSeven.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        userInput += "7";
                        tvTime.setText(tvTime.getText() + "7");
                        if (answer == userInput) {
                            startTime = System.currentTimeMillis() - 1000;
                            for (int i = 0; i < totalSec; i++) {
                                _sixtyOfALine[i].setVisibility(View.VISIBLE);
                            }
                        }
                        testUserInputAnswer();
                    }
                });

                butEight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        userInput += "8";
                        tvTime.setText(tvTime.getText() + "8");
                        if (answer == userInput) {
                            startTime = System.currentTimeMillis() - 1000;
                            for (int i = 0; i < totalSec; i++) {
                                _sixtyOfALine[i].setVisibility(View.VISIBLE);
                            }
                        }
                        testUserInputAnswer();
                    }
                });

                butNine.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        userInput += "9";
                        tvTime.setText(tvTime.getText() + "9");
                        if (answer == userInput) {
                            startTime = System.currentTimeMillis() - 1000;
                            for (int i = 0; i < totalSec; i++) {
                                _sixtyOfALine[i].setVisibility(View.VISIBLE);
                            }
                        }
                        testUserInputAnswer();
                    }
                });

                butZero.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        userInput += "0";
                        tvTime.setText(tvTime.getText() + "0");
                        if (answer == userInput) {
                            startTime = System.currentTimeMillis() - 1000;
                            for (int i = 0; i < totalSec; i++) {
                                _sixtyOfALine[i].setVisibility(View.VISIBLE);
                            }
                        }
                        testUserInputAnswer();
                    }
                });

                butMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        userInput += "-";
                        tvTime.setText(tvTime.getText() + "-");
                        if (answer == userInput) {
                            startTime = System.currentTimeMillis() - 1000;
                            for (int i = 0; i < totalSec; i++) {
                                _sixtyOfALine[i].setVisibility(View.VISIBLE);
                            }
                        }
                        testUserInputAnswer();
                    }
                });

                butBackspace.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (userInput.length() > 0) {
                            userInput = userInput.substring(0, userInput.length() - 1);
                            tvTime.setText(tvTime.getText().toString().substring(0, tvTime.getText().length() - 1));
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

    private void testUserInputAnswer() {
        System.out.println(userInput + " x " + answer);
        System.out.println(userInput == answer);
    }

    // --------------------------------------------------------- <MAKE MATHEMATICAL QUESTIONS! (BEGINS) -------------------------------------------------------

    private String mathematicsQuestions(int levelNum) {
        String question = "";
        int num;
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

    private void checkAnswer(int num, int ranNegPosSign1) {
        Math.abs(num);
        if (ranNegPosSign1 == 2) { num *= -1; }
        System.out.println("answer = " + num);
        answer = num + "";
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