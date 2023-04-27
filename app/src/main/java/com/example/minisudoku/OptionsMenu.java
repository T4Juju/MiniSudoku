package com.example.minisudoku;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class OptionsMenu extends AppCompatActivity {



    public static final String EXTRA_COLOR = "com.example.minisudoku.color";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);

        // Get the color ID from MainActivity
        Intent intent = getIntent();
        int colorId = intent.getIntExtra(EXTRA_COLOR, R.color.blue);

        // Select the radio button matching the color ID
        int radioId = R.id.radio_blue;
        if (colorId == R. color.green) {
            radioId = R.id.radio_green;
        }
        else if (colorId == R.color.blue) {
            radioId = R.id.radio_blue;
        }
        else if (colorId == R.color.pink) {
            radioId = R.id.radio_pink;
        }
        else if (colorId == R.color.purple_200) {
            radioId = R.id.radio_purple;
        }
        else if (colorId == R.color.yellow) {
            radioId = R.id.radio_yellow;
        }
        RadioButton radio = findViewById(radioId);
        radio.setChecked(true);
    }
    public void onColorSelected(View view) {
        int colorId = R.color.blue;   //initially, MainActivity background will be blue

        if (view.getId() == R.id.radio_green) {
            colorId = R.color.green;
        } else if (view.getId() == R.id.radio_blue) {
            colorId = R.color.blue;
        } else if (view.getId() == R.id.radio_pink) {
            colorId = R.color.pink;
        } else if (view.getId() == R.id.radio_purple) {
            colorId = R.color.purple_200;
        } else if (view.getId() == R.id.radio_yellow) {
            colorId = R.color.yellow;
        }


        Intent intent = new Intent();
        intent.putExtra(EXTRA_COLOR, colorId);
        setResult(RESULT_OK, intent);
        finish();
    }
}



