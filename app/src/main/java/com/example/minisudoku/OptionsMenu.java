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



    }
    public void onColorSelected(View view) {
        int colorId = R.color.white;    //initially, MainActivity background will be white

        if (view.getId() == R.id.radio_green) {
            colorId = R.color.green;
        } else if (view.getId() == R.id.radio_blue) {
            colorId = R.color.blue;
        } else if (view.getId() == R.id.radio_pink) {
            colorId = R.color.pink;
        } else if (view.getId() == R.id.radio_purple) {
            colorId = R.color.purple_200;
        }


        Intent intent = new Intent();
        intent.putExtra(EXTRA_COLOR, colorId);
        setResult(RESULT_OK, intent);
        finish();


    }
}




