package com.example.android.mathematicstrainingmode;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class TrainingModeBeginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_mode_begin_screen);

        buttonIntents();
    }

    private void buttonIntents() {
//        findViewById(R.id.single_game_btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HomeScreenActivity.this, SingleGameActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}