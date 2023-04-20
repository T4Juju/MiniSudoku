package com.example.minisudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Tile newGame;
    private Tile currTile;
    private int gameNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);


            for(int row=0;row<4;row++){
                for(int col=0;col<4;col++) {
                    //gameNumber = grid[row][col].getDigit();
                }
            }
    }



}