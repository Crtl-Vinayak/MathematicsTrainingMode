package com.example.android.mathematicstrainingmode;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicstrainingmode.LevelSelectionExerciseNum.LevelSelectionExerciseOne;
import com.example.android.mathematicstrainingmode.LevelSelectionExerciseNum.LevelSelectionExerciseTwo;
import com.example.android.mathematicstrainingmode.LevelSelectionExerciseNum.LevelSelectionExerciseThree;
import com.example.android.mathematicstrainingmode.LevelSelectionExerciseNum.LevelSelectionExerciseFour;
import com.example.android.mathematicstrainingmode.LevelSelectionExerciseNum.LevelSelectionExerciseFive;
import com.example.android.mathematicstrainingmode.LevelSelectionExerciseNum.LevelSelectionExerciseSix;
import com.example.android.mathematicstrainingmode.LevelSelectionExerciseNum.LevelSelectionExerciseSeven;
import com.example.android.mathematicstrainingmode.LevelSelectionExerciseNum.LevelSelectionExerciseEight;
import com.example.android.mathematicstrainingmode.LevelSelectionExerciseNum.LevelSelectionExerciseNine;
import com.example.android.mathematicstrainingmode.LevelSelectionExerciseNum.LevelSelectionExerciseTen;

public class TrainingModeBeginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_mode_begin_screen);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getApplicationContext().getResources().getColor(R.color.dark_bg));
        }

        buttonIntents();
    }

    private void buttonIntents() {
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingModeBeginScreen.this, LevelSelectionExerciseOne.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingModeBeginScreen.this, LevelSelectionExerciseTwo.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingModeBeginScreen.this, LevelSelectionExerciseThree.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingModeBeginScreen.this, LevelSelectionExerciseFour.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingModeBeginScreen.this, LevelSelectionExerciseFive.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingModeBeginScreen.this, LevelSelectionExerciseSix.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingModeBeginScreen.this, LevelSelectionExerciseSeven.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingModeBeginScreen.this, LevelSelectionExerciseEight.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingModeBeginScreen.this, LevelSelectionExerciseNine.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingModeBeginScreen.this, LevelSelectionExerciseTen.class);
                startActivity(intent);
            }
        });
    }
}