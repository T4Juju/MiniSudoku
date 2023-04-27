package com.example.minisudoku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.*;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    private final int GRID_SIZE = 4;
    private GridLayout mGridArray;
    private final int ORANGE = 0xFFFF3300;

    public int userInput00=0;
    public int userInput01=0;
    public int userInput02=0;
    public int userInput03=0;
    public int userInput10=0;
    public int userInput11=0;
    public int userInput12=0;
    public int userInput13=0;
    public int userInput20=0;
    public int userInput21=0;
    public int userInput22=0;
    public int userInput23=0;
    public int userInput30=0;
    public int userInput31=0;
    public int userInput32=0;
    public int userInput33=0;




    int[][] numArray = new int[4][4];
    String[] numList = new String[5];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numList[0] = " ";
        numList[1] = "1";
        numList[2] = "2";
        numList[3] = "3";
        numList[4] = "4";






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

        STile.grid[0][0].hideTile();

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

                setButtonText();

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

    /*public void newGame() {
        Random randomNumGenerator = new Random();
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                mGridArray[row][col]= numArray[row][col];
            }
        }
    }*/

    public void setButtonText(){
        Button button00 = (Button) findViewById(R.id.imgButton00);
        Button button01 = (Button) findViewById(R.id.imgButton01);
        Button button02 = (Button) findViewById(R.id.imgButton02);
        Button button03 = (Button) findViewById(R.id.imgButton03);
        String num00 = String.valueOf(STile.grid[0][0].getDigit());
        String num01 = String.valueOf(STile.grid[0][1].getDigit());
        String num02 = String.valueOf(STile.grid[0][2].getDigit());
        String num03 = String.valueOf(STile.grid[0][3].getDigit());
        if(numArray[0][0]!=0){
            button00.setText(num00);
            button00.setTextColor(ORANGE);
        }
        if(numArray[0][1]!=0){
            button01.setText(num01);
            button01.setTextColor(ORANGE);
        }
        if(numArray[0][2]!=0){
            button02.setText(num02);
            button02.setTextColor(ORANGE);
        }
        if(numArray[0][3]!=0){
            button03.setText(num03);
            button03.setTextColor(ORANGE);
        }

        Button button10 = (Button) findViewById(R.id.imgButton10);
        Button button11 = (Button) findViewById(R.id.imgButton11);
        Button button12 = (Button) findViewById(R.id.imgButton12);
        Button button13 = (Button) findViewById(R.id.imgButton13);
        String num10 = String.valueOf(STile.grid[1][0].getDigit());
        String num11 = String.valueOf(STile.grid[1][1].getDigit());
        String num12 = String.valueOf(STile.grid[1][2].getDigit());
        String num13 = String.valueOf(STile.grid[1][3].getDigit());
        if(numArray[1][0]!=0) {
            button10.setText(num10);
            button10.setTextColor(ORANGE);
        }
        if(numArray[1][1]!=0) {
            button11.setText(num11);
            button11.setTextColor(ORANGE);
        }
        if(numArray[1][2]!=0){
            button12.setText(num12);
            button12.setTextColor(ORANGE);
        }
        if(numArray[1][3]!=0){
            button13.setText(num13);
            button13.setTextColor(ORANGE);
        }

        Button button20 = (Button) findViewById(R.id.imgButton20);
        Button button21 = (Button) findViewById(R.id.imgButton21);
        Button button22 = (Button) findViewById(R.id.imgButton22);
        Button button23 = (Button) findViewById(R.id.imgButton23);
        String num20 = String.valueOf(STile.grid[2][0].getDigit());
        String num21 = String.valueOf(STile.grid[2][1].getDigit());
        String num22 = String.valueOf(STile.grid[2][2].getDigit());
        String num23 = String.valueOf(STile.grid[2][3].getDigit());
        if(numArray[2][0]!=0){
            button20.setText(num20);
            button20.setTextColor(ORANGE);
        }
        if (numArray[2][1] != 0){
            button21.setText(num21);
            button21.setTextColor(ORANGE);
        }
        if(numArray[2][2]!=0){
            button22.setText(num22);
            button22.setTextColor(ORANGE);
        }
        if(numArray[2][3]!=0){
            button23.setText(num23);
            button23.setTextColor(ORANGE);
        }

        Button button30 = (Button) findViewById(R.id.imgButton30);
        Button button31 = (Button) findViewById(R.id.imgButton31);
        Button button32 = (Button) findViewById(R.id.imgButton32);
        Button button33 = (Button) findViewById(R.id.imgButton33);
        String num30 = String.valueOf(STile.grid[3][0].getDigit());
        String num31 = String.valueOf(STile.grid[3][1].getDigit());
        String num32 = String.valueOf(STile.grid[3][2].getDigit());
        String num33 = String.valueOf(STile.grid[3][3].getDigit());
        if(numArray[3][0]!=0){
            button30.setText(num30);
            button30.setTextColor(ORANGE);
        }
        if(numArray[3][1]!=0){
            button31.setText(num31);
            button31.setTextColor(ORANGE);
        }
        if(numArray[3][2]!=0){
            button32.setText(num32);
            button32.setTextColor(ORANGE);
        }
        if(numArray[3][3]!=0){
            button33.setText(num33);
            button33.setTextColor(ORANGE);
        }








    }

    public void onHomeClick(View view){
        Intent intent = new Intent(this, StartMenu.class);
        startActivity(intent);
    }
    public void onOptionsClick(View view) {
        Intent intent = new Intent(this, OptionsMenu.class);
        startActivity(intent);
    }



    public void onCheckClick(View view){
        Button button = (Button)findViewById(R.id.checkButton);
        //isGameOver();

        if (isGameOver()) {
            Toast.makeText(this, R.string.congrats, Toast.LENGTH_SHORT).show();
            System.out.println("congrats");
        }
        else {
            Toast.makeText(this, R.string.tryAgain, Toast.LENGTH_SHORT).show();
            System.out.println("try again");
        }
    }

    //=========================================================================================
    // On game click methods below:
    //=========================================================================================


    public void onGameClick00(View view){
        if(!STile.grid[0][0].getVisible()) {

            if(userInput00<4){
                userInput00++;
            }
            else userInput00=0;


            Button button = (Button) findViewById(R.id.imgButton00);
            if(userInput00==0)
                button.setText(" ");
            else if(userInput00==1)
                button.setText("1");
            else if(userInput00==2)
                button.setText("2");
            else if(userInput00==3)
                button.setText("3");
            else if(userInput00==4)
                button.setText("4");

            STile.grid[0][0].setDigit(userInput00);
        }
    }
    public void onGameClick01(View view){
        if(!STile.grid[0][1].getVisible()) {

            if(userInput01<4){
                userInput01++;
            }
            else userInput01=0;


            Button button = (Button) findViewById(R.id.imgButton01);
            if(userInput01==0)
                button.setText(" ");
            else if(userInput01==1)
                button.setText("1");
            else if(userInput01==2)
                button.setText("2");
            else if(userInput01==3)
                button.setText("3");
            else if(userInput01==4)
                button.setText("4");

            STile.grid[0][1].setDigit(userInput01);
        }
    }

    public void onGameClick02(View view){
        if(!STile.grid[0][2].getVisible()) {

            if(userInput02<4){
                userInput02++;
            }
            else userInput02=0;


            Button button = (Button) findViewById(R.id.imgButton02);
            if(userInput02==0)
                button.setText(" ");
            else if(userInput02==1)
                button.setText("1");
            else if(userInput02==2)
                button.setText("2");
            else if(userInput02==3)
                button.setText("3");
            else if(userInput02==4)
                button.setText("4");

            STile.grid[0][2].setDigit(userInput02);
        }
    }

    public void onGameClick03(View view){
        if(!STile.grid[0][3].getVisible()) {

            if(userInput03<4){
                userInput03++;
            }
            else userInput03=0;


            Button button = (Button) findViewById(R.id.imgButton03);
            if(userInput03==0)
                button.setText(" ");
            else if(userInput03==1)
                button.setText("1");
            else if(userInput03==2)
                button.setText("2");
            else if(userInput03==3)
                button.setText("3");
            else if(userInput03==4)
                button.setText("4");

            STile.grid[0][3].setDigit(userInput03);
        }
    }

//------------------------------------------------------------------------------------

    public void onGameClick10(View view){
        if(!STile.grid[1][0].getVisible()) {

            if(userInput10<4){
                userInput10++;
            }
            else userInput10=0;


            Button button = (Button) findViewById(R.id.imgButton10);
            if(userInput10==0)
                button.setText(" ");
            else if(userInput10==1)
                button.setText("1");
            else if(userInput10==2)
                button.setText("2");
            else if(userInput10==3)
                button.setText("3");
            else if(userInput10==4)
                button.setText("4");

            STile.grid[1][0].setDigit(userInput10);
        }
    }
    public void onGameClick11(View view){
        if(!STile.grid[1][1].getVisible()) {

            if(userInput11<4){
                userInput11++;
            }
            else userInput11=0;


            Button button = (Button) findViewById(R.id.imgButton11);
            if(userInput11==0)
                button.setText(" ");
            else if(userInput11==1)
                button.setText("1");
            else if(userInput11==2)
                button.setText("2");
            else if(userInput11==3)
                button.setText("3");
            else if(userInput11==4)
                button.setText("4");

            STile.grid[1][1].setDigit(userInput11);
        }
    }

    public void onGameClick12(View view){
        if(!STile.grid[1][2].getVisible()) {

            if(userInput12<4){
                userInput12++;
            }
            else userInput12=0;


            Button button = (Button) findViewById(R.id.imgButton12);
            if(userInput12==0)
                button.setText(" ");
            else if(userInput12==1)
                button.setText("1");
            else if(userInput12==2)
                button.setText("2");
            else if(userInput12==3)
                button.setText("3");
            else if(userInput12==4)
                button.setText("4");

            STile.grid[1][2].setDigit(userInput12);
        }
    }

    public void onGameClick13(View view){
        if(!STile.grid[1][3].getVisible()) {

            if(userInput13<4){
                userInput13++;
            }
            else userInput13=0;


            Button button = (Button) findViewById(R.id.imgButton13);
            if(userInput13==0)
                button.setText(" ");
            else if(userInput13==1)
                button.setText("1");
            else if(userInput13==2)
                button.setText("2");
            else if(userInput13==3)
                button.setText("3");
            else if(userInput13==4)
                button.setText("4");

            STile.grid[1][3].setDigit(userInput13);
        }
    }

    //------------------------------------------------------------------------------------

    public void onGameClick20(View view){
        if(!STile.grid[2][0].getVisible()) {

            if(userInput20<4){
                userInput20++;
            }
            else userInput20=0;


            Button button = (Button) findViewById(R.id.imgButton20);
            if(userInput20==0)
                button.setText(" ");
            else if(userInput20==1)
                button.setText("1");
            else if(userInput20==2)
                button.setText("2");
            else if(userInput20==3)
                button.setText("3");
            else if(userInput20==4)
                button.setText("4");

            STile.grid[2][0].setDigit(userInput20);
        }
    }
    public void onGameClick21(View view){
        if(!STile.grid[2][1].getVisible()) {

            if(userInput21<4){
                userInput21++;
            }
            else userInput21=0;


            Button button = (Button) findViewById(R.id.imgButton21);
            if(userInput21==0)
                button.setText(" ");
            else if(userInput21==1)
                button.setText("1");
            else if(userInput21==2)
                button.setText("2");
            else if(userInput21==3)
                button.setText("3");
            else if(userInput21==4)
                button.setText("4");

            STile.grid[2][1].setDigit(userInput21);
        }
    }

    public void onGameClick22(View view){
        if(!STile.grid[2][2].getVisible()) {

            if(userInput22<4){
                userInput22++;
            }
            else userInput22=0;


            Button button = (Button) findViewById(R.id.imgButton22);
            if(userInput22==0)
                button.setText(" ");
            else if(userInput22==1)
                button.setText("1");
            else if(userInput22==2)
                button.setText("2");
            else if(userInput22==3)
                button.setText("3");
            else if(userInput22==4)
                button.setText("4");

            STile.grid[2][2].setDigit(userInput22);
        }
    }

    public void onGameClick23(View view){
        if(!STile.grid[2][3].getVisible()) {

            if(userInput23<4){
                userInput23++;
            }
            else userInput23=0;


            Button button = (Button) findViewById(R.id.imgButton23);
            if(userInput23==0)
                button.setText(" ");
            else if(userInput23==1)
                button.setText("1");
            else if(userInput23==2)
                button.setText("2");
            else if(userInput23==3)
                button.setText("3");
            else if(userInput23==4)
                button.setText("4");

            STile.grid[2][3].setDigit(userInput23);
        }
    }

    //------------------------------------------------------------------------------------

    public void onGameClick30(View view){
        if(!STile.grid[3][0].getVisible()) {

            if(userInput30<4){
                userInput30++;
            }
            else userInput30=0;


            Button button = (Button) findViewById(R.id.imgButton30);
            if(userInput30==0)
                button.setText(" ");
            else if(userInput30==1)
                button.setText("1");
            else if(userInput30==2)
                button.setText("2");
            else if(userInput30==3)
                button.setText("3");
            else if(userInput30==4)
                button.setText("4");

            STile.grid[3][0].setDigit(userInput30);
        }
    }
    public void onGameClick31(View view){
        if(!STile.grid[3][1].getVisible()) {

            if(userInput31<4){
                userInput31++;
            }
            else userInput31=0;


            Button button = (Button) findViewById(R.id.imgButton31);
            if(userInput31==0)
                button.setText(" ");
            else if(userInput31==1)
                button.setText("1");
            else if(userInput31==2)
                button.setText("2");
            else if(userInput31==3)
                button.setText("3");
            else if(userInput31==4)
                button.setText("4");

            STile.grid[3][1].setDigit(userInput31);
        }
    }

    public void onGameClick32(View view){
        if(!STile.grid[3][2].getVisible()) {

            if(userInput32<4){
                userInput32++;
            }
            else userInput32=0;


            Button button = (Button) findViewById(R.id.imgButton32);
            if(userInput32==0)
                button.setText(" ");
            else if(userInput32==1)
                button.setText("1");
            else if(userInput32==2)
                button.setText("2");
            else if(userInput32==3)
                button.setText("3");
            else if(userInput32==4)
                button.setText("4");

            STile.grid[3][2].setDigit(userInput32);
        }
    }

    public void onGameClick33(View view){
        if(!STile.grid[3][3].getVisible()) {

            if(userInput33<4){
                userInput33++;
            }
            else userInput33=0;


            Button button = (Button) findViewById(R.id.imgButton33);
            if(userInput33==0)
                button.setText(" ");
            else if(userInput33==1)
                button.setText("1");
            else if(userInput33==2)
                button.setText("2");
            else if(userInput33==3)
                button.setText("3");
            else if(userInput33==4)
                button.setText("4");

            STile.grid[3][3].setDigit(userInput33);
        }
    }

}

