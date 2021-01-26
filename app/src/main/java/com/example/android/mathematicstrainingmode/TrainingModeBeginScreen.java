package com.example.android.mathematicstrainingmode;

import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class TrainingModeBeginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_mode_begin_screen);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getApplicationContext().getResources().getColor(R.color.dark_bg));
        }
    }

    public void button1() {

    }

    public void button2() {

    }

    public void button3() {

    }

    public void button4() {

    }

    public void button5() {

    }

    public void button6() {

    }

    public void button7() {

    }

    public void button8() {

    }

    public void button9() {

    }

    public void button10() {

    }
}