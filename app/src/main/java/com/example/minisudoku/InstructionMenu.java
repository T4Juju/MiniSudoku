package com.example.minisudoku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class InstructionMenu extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

    }
    public void onBackClick (View view){
        Intent intent = new Intent(this, StartMenu.class);
        startActivity(intent);
    }
}
