package com.example.minisudoku;

import java.lang.Math;

public class STile {

    public int digit = -1;
    public int group;
    public int position; // Group and position are there to check which tiles are in the same "box"

    public int row;
    public int col; // row and col are the actual rows and columns on the sudoku board

    public boolean visible=true;// this will be used to decide which tiles are hidden on the game board.

    public static STile[][] grid = new STile[4][4];
    public static STile[][] box = new STile[4][4];



    /*
     * To Do: Create the public boolean isSolved() method. Probably would be easiest
     * to iterate through the grid[][] array and just run the isAvailable() method
     * for each element. That way if there are multiple solutions then all of them
     * can be accepted.
     *
     * Figure out how we want to decide which tiles are visible on the sudoku
     * puzzle. We can either randomly generate this or have a predetermined set of
     * patterns to randomly choose from.
     *
     */

    public STile(int group, int position, int row, int col) {  // Constructor method
        this.group = group;
        this.position = position;
        this.row = row;
        this.col = col;


    }

    // ------------------------------------------------
    public boolean isAvailable(STile t, int num) { // This goes through the arrays to see if the generated number is
        // available or not.

        //System.out.println("1");

        for (int j = t.getCol(); j > -1; j--) {

            if (grid[t.getRow()][j].getDigit() == num) {

                return false;
            }
        }
        //System.out.println("2");

        for (int i = t.getRow(); i > -1; i--) {

            if (grid[i][t.getCol()].getDigit() == num) {

                return false;
            }
        }

        // ********************************************
        //System.out.println("3");
        if (position > 0) {

            for (int k = position; k > -1; k--) {
                if (box[group][k].digit == num) {

                    return false;
                }
            }
        }
        // ********************************************
        //System.out.println("returning");

        return true;
    }

    // -----------------------------------------------

    // ------------------------------------------------
    public boolean isValid(STile t, int num) { // This goes through the arrays to see if the generated number is
        // available or not.

        boolean first = false;
        boolean second = false;
        boolean third = false;

        for (int j = t.getCol(); j > -1; j--) {

            // System.out.println("checking "+num+" and "+grid[t.getRow()][j].getDigit());

            if (first && grid[t.getRow()][j].getDigit() == num) {

                System.out.println("1");
                return false;
            }

            first = true;
        }

        for (int i = t.getRow(); i > -1; i--) {

            // System.out.println("checking "+num+" and "+grid[i][t.getCol()].getDigit());

            if (second && grid[i][t.getCol()].getDigit() == num) {
                System.out.println("2");
                return false;
            }

            second = true;
        }

        // ********************************************
        if (position > 0) {

            for (int k = position; k > -1; k--) {

                // System.out.println("checking "+num+" and "+box[group][k].digit);

                if (third && box[group][k].digit == num) {
                    System.out.println("3");
                    return false;
                }

                third = false;
            }
        }
        // ********************************************

        return true;
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public int generate(STile t) { // Random number generator, generates 1-4. This method does not directly add the
        // number to the array, that is done in the addToArrays() method.

        int count = 0;
        int currDigit = (int) (Math.random() * 4) + 1;

        //System.out.println("Generating, curr num: "+currDigit);

        while (!isAvailable(t, currDigit)) {

            currDigit = (int) (Math.random() * 4) + 1;
            count++;

            if (count == 15) // This method has 15 tries to generate a valid number. Without this counter the
                // code gets stuck in an infinite loop sometimes.
                return -1;

        }

        return currDigit;
    }

    // -----------------------------------------------

    public int regenerate(int row, int col) { // This is used if the random number generator isn't able to find an
        // available number. It will regenerate all of the previous tiles.

        // System.out.println("regenerate"); // This will print out to let you know
        // if/how many times the method was used.
        int newTemp = -1;

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                newTemp = grid[i][j].generate(grid[i][j]);
                grid[i][j].setDigit(newTemp);
                if (newTemp == -1)
                    return newTemp;
            }
        }
        return newTemp;

    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------
    public void addToArrays(STile t) { // This method adds the tile objects to the array and then uses the
        // generate() method to assign each tile a number. The numbers are
        // assigned as soon as they are added to the arrays.
        grid[t.getRow()][t.getCol()] = t;
        box[t.getGroup()][t.getPosition()] = t;

        int temp = t.generate(t);

        if (temp != -1)
            t.setDigit(temp);
        else {
            while (temp == -1) {
                temp = t.regenerate(t.getRow(), t.getCol()); // This calls the regenerate method if necessary.
            }
        }

        // All of the rest of the code in this method is just there to print the
        // grid[][] array to the screen in a way that is easy to read.

        if (t.getRow() == 3 && t.getCol() == 3) {

            for (int i = 0; i < 4; i++) {

                for (int j = 0; j < 4; j++) {

                    System.out.print(grid[i][j].getDigit() + " ");
                    if (grid[i][j].getCol() == 1) {
                        System.out.print("|");
                    }

                    if (j == 3)
                        System.out.println();

                    if (grid[i][j].getRow() == 1 && grid[i][j].getCol() == 3) {
                        System.out.print("---------");
                        System.out.println();
                    }
                }
            }
        }

    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Setter/Getter methods.

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public int getDigit() {
        return digit;
    }

    public int getGroup() {
        return group;
    }



    public int getPosition() {
        return position;
    }



    public int getRow() {
        return row;
    }



    public int getCol() {
        return col;
    }



    public void setVisible(boolean value) {
        this.visible = value;
    }

    public boolean getVisible() {
        return visible;
    }


    // -----------------------------------------------------
    /*
     * public boolean isGameOver(Tile start) {
     *
     * for (int row = 0; row < 4; row++) { for (int col = 0; col < 4; col++) {
     *
     * if (!isValid(grid[row][col], grid[row][col].getDigit())) {
     *
     * return false; }
     *
     * } } return true; }
     */
    // -----------------------------------------------------

    public void hideTile() {
        int hiddenNum;
        int prevNum;
        int count = 0;
        int thirdNum;
        int group = (int) (Math.random() * 4);

        for (int row = 0; row < 4; row++) {

            hiddenNum = (int) (Math.random() * 4);
            box[row][hiddenNum].setVisible(false);

            prevNum = hiddenNum;
            hiddenNum = (int) (Math.random() * 4);

            if (hiddenNum == prevNum) {
                while (hiddenNum == prevNum) {
                    hiddenNum = (int) (Math.random() * 4);
                    box[row][hiddenNum].setVisible(false);
                }
            } else {
                box[row][hiddenNum].setVisible(false);
                prevNum = hiddenNum;
                hiddenNum = (int) (Math.random() * 4);
                while (hiddenNum == prevNum) {
                    hiddenNum = (int) (Math.random() * 4);
                    box[row][hiddenNum].setVisible(false);

                }

            }

        }

        // ----------------------------------------------------

        // The following code guarantees that at least 1 box will have 3 hidden numbers

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (!grid[row][col].getVisible()) {
                    count++;
                }
            }
        }

        // System.out.println("COUNT: " + count);

        if (count == 8) {

            thirdNum = (int) (Math.random() * 4);
            while (!box[group][thirdNum].getVisible()) {
                thirdNum = (int) (Math.random() * 4);
            }
            box[group][thirdNum].setVisible(false);
            // System.out.println(" GROUP: " + group);
        }

    }

    // --------------------------------------------------------
    public int getGame(int row, int col) { // This is used to generate the numArray in the main method
        return grid[row][col].getDigit();
    }

}


