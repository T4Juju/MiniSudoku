package com.example.minisudoku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private int mLightOnColorId;
    private int mLightOnColor;
    private GridLayout mLightGrid;

    public void onHomeClick(View view){
        Intent intent = new Intent(this, StartMenu.class);
        startActivity(intent);
    }
    public void onOptionsClick(View view) {
        Intent intent = new Intent(this, OptionsMenu.class);
        intent.putExtra(OptionsMenu.EXTRA_COLOR, mLightOnColorId);
        mColorResultLauncher.launch(intent);
    }

    ActivityResultLauncher<Intent> mColorResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            mLightOnColorId = data.getIntExtra(OptionsMenu.EXTRA_COLOR, R.color.blue);
                            mLightOnColor = ContextCompat.getColor(MainActivity.this, mLightOnColorId);
                            setButtonColors();
                        }
                    }
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLightOnColor = ContextCompat.getColor(this, R.color.blue);
        mLightOnColorId = R.color.blue;
        mLightGrid = findViewById(R.id.grid_ID);


        int[][] numArray = new int[4][4];

        // The following objects are only used for the generation of the grid, they will
        // also be used when the game is being played and numbers are changed.
        // numArray will hold the number values for the sudoku game.

        STile a = new STile(0, 0, 0, 0);
        STile b = new STile(0, 1, 0, 1);
        STile c = new STile(1, 0, 0, 2);
        STile d = new STile(1, 1, 0, 3);
        STile e = new STile(0, 2, 1, 0);
        STile f = new STile(0, 3, 1, 1);
        STile g = new STile(1, 2, 1, 2);
        STile h = new STile(1, 3, 1, 3);
        STile i = new STile(2, 0, 2, 0);
        STile j = new STile(2, 1, 2, 1);
        STile k = new STile(3, 0, 2, 2);
        STile l = new STile(3, 1, 2, 3);
        STile m = new STile(2, 2, 3, 0);
        STile n = new STile(2, 3, 3, 1);
        STile o = new STile(3, 2, 3, 2);
        STile p = new STile(3, 3, 3, 3);

        a.addToArrays(a);
        a.addToArrays(b);
        a.addToArrays(c);
        a.addToArrays(d);
        a.addToArrays(e);
        a.addToArrays(f);
        a.addToArrays(g);
        a.addToArrays(h);
        a.addToArrays(i);
        a.addToArrays(j);
        a.addToArrays(k);
        a.addToArrays(l);
        a.addToArrays(m);
        a.addToArrays(n);
        a.addToArrays(o);
        a.addToArrays(p);

        a.hideTile();

        // -------------------

        // This code here is just for testing the methods.

        // addToArrays(a);
        System.out.println("Is game over? " + isGameOver());

        // -------------------

        // =========================================================================================

        // This next part of the code fills the numArray by calling getGame() from the
        // Tile class.
        // It includes printout statements which will show how the game will look.

        System.out.println();
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (STile.grid[row][col].getVisible()) {
                    numArray[row][col] = a.getGame(row, col);
                }

                if (STile.grid[row][col].getVisible())
                    System.out.print(numArray[row][col] + " ");
                else
                    System.out.print("* ");

            }

            System.out.println();
        }

        // ---------------------------------------------------------------------------------------

        // The following for loop sets all the "invisible" tiles on the grid[][] array
        // to 0 so that the isGameOver() method doesn't automatically return true at the
        // beginning of the game

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {

                if (!STile.grid[row][col].getVisible()) {
                    STile.grid[row][col].setDigit(0);
                }
            }
        }

        System.out.println("Is game over? " + isGameOver());








    }
    private void setButtonColors() {

        int count = mLightGrid.getChildCount();
        for(int i = 0 ; i < count ; i++){
            View child = mLightGrid.getChildAt(i);
            child.setBackgroundColor(mLightOnColor);
        }

    }


// =============================================================================================

    public static boolean isGameOver() {

        STile aaa = new STile(0, 0, 0, 0); // this Tile object is necessary in order to be access the grid[][] array from
        // the Tile class and check the numbers.
        // It is not used for anything else and it is not part of the grid[][]
        // array.

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {

                if (!aaa.isValid(STile.grid[row][col], STile.grid[row][col].getDigit())) {

                    return false;
                }

                if (STile.grid[row][col].getDigit() == 0) { // if the number is equal to 0 that means that the user has
                    // not chosen a number.
                    return false;
                }

            }
        }
        return true;
    }






}

