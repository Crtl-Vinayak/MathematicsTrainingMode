package com.example.android.mathematicstrainingmode;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class LevelSelectionExerciseOne extends AppCompatActivity {

    private LinearLayout _linearLayout;
    private LinearLayout _rowOfLevels[] = new LinearLayout[34];
    private Button _buttonLevel[] = new Button[100];
    private LinearLayout.LayoutParams _buttonParams;
    private ImageView _backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection_exercise_one);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getApplicationContext().getResources().getColor(R.color.dark_bg));
        }

        _linearLayout = findViewById(R.id.level_selection_exercise_one_contents);
        _linearLayout.setWeightSum(34);

//        LinearLayout rowtest = new LinearLayout(this);
//        rowtest.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        rowtest.setOrientation(LinearLayout.HORIZONTAL);
//        rowtest.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.neon_blue)); // setbackground is a test, don't use it for full release in this code.
//        rowtest.setWeightSum(3);
//        _linearLayout.addView(rowtest);
//
//        Button but1 = new Button(this);
//        Button but2 = new Button(this);
//        Button but3 = new Button(this);
//        but1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
//        but2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
//        but3.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
//        but1.setText("1");
//        but2.setText("2");
//        but3.setText("3");
//        but1.setTextSize(25);
//        but2.setTextSize(25);
//        but2.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.neon_orange));
//        but3.setTextSize(25);
//
//        rowtest.addView(but1);
//        rowtest.addView(but2);
//        rowtest.addView(but3);

        for (int i = 0; i < 33; i++) {
            System.out.println("level: " + (i + 1));
            _rowOfLevels[i] = new LinearLayout(this);
            _rowOfLevels[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
            _rowOfLevels[i].setWeightSum(3);
            _rowOfLevels[i].setOrientation(LinearLayout.HORIZONTAL);

            _linearLayout.addView(_rowOfLevels[i]);

            _buttonLevel[(i * 3)] = new Button(this);
            _buttonLevel[(i * 3) + 1] = new Button(this);
            _buttonLevel[(i * 3) + 2] = new Button(this);

            _buttonParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
            _buttonParams.setMargins(30, 10, 30, 10);

            _buttonLevel[(i * 3)].setLayoutParams(_buttonParams);
            _buttonLevel[(i * 3) + 1].setLayoutParams(_buttonParams);
            _buttonLevel[(i * 3) + 2].setLayoutParams(_buttonParams);

            _buttonLevel[(i * 3)].setText("" + ((i * 3)));
            _buttonLevel[(i * 3) + 1].setText("" + ((i * 3) + 1));
            _buttonLevel[(i * 3) + 2].setText("" + ((i * 3) + 2));
            _buttonLevel[(i * 3)].setTextSize(25);
            _buttonLevel[(i * 3) + 1].setTextSize(25);
            _buttonLevel[(i * 3) + 2].setTextSize(25);

            _buttonLevel[(i * 3)].setBackgroundColor(getApplicationContext().getResources().getColor(R.color.neon_orange));
            _buttonLevel[(i * 3) + 1].setBackgroundColor(getApplicationContext().getResources().getColor(R.color.neon_orange));
            _buttonLevel[(i * 3) + 2].setBackgroundColor(getApplicationContext().getResources().getColor(R.color.neon_orange));

            _rowOfLevels[i].addView(_buttonLevel[(i * 3)]);
            _rowOfLevels[i].addView(_buttonLevel[(i * 3) + 1]);
            _rowOfLevels[i].addView(_buttonLevel[(i * 3) + 2]);
        }
        System.out.println("level: " + 34);
        _rowOfLevels[33] = new LinearLayout(this);
        _rowOfLevels[33].setWeightSum(1);
        _rowOfLevels[33].setOrientation(LinearLayout.HORIZONTAL);
        _linearLayout.addView(_rowOfLevels[33]);

        _buttonLevel[99] = new Button(this);
        _buttonLevel[99].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        _buttonLevel[99].setText("100");
        _buttonLevel[99].setTextSize(25);
        _buttonLevel[99].setBackgroundColor(getApplicationContext().getResources().getColor(R.color.neon_orange));
        _rowOfLevels[33].addView(_buttonLevel[99]);



        _backButton = findViewById(R.id.level_selection_exercise_one_back_button);
        _backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelSelectionExerciseOne.this, TrainingModeBeginScreen.class);
                startActivity(intent);
            }
        });
    }
}