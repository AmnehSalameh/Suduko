package com.example.amon.suduko;

/**
 * Created by amm on 5/23/2016.
 */
public class BackTracking {

    public BackTracking() {
    }

    public boolean BackTracking(int[][] game) {
        int r = 0, c = 0;

        if (EmptyPlace(game)) {
            int[] x = FindEmptyLocation(game, r, c);
            r = x[0];//the row which contain the balck cell
            c = x[1];//
            //  if(r<9&& c<9){
            for (int i = 1; i < 10; i++) {
                //assign the empty grid with value (i)

                if (InRightPalce(i, game, r, c)) {
                    //no numbers exists in same rows & same columns same as (i) & 3x3 square (i) is currently in)

                    game[r][c] = i;
                    if (BackTracking(game)) {
                        return true;
                    } else {
                        game[r][c] = 0;
                        // Solution=false;
                    }  }}
        }  else { //all cells are filled
            //solution found
            return true;
        }
        return false;//
    }

    boolean EmptyPlace(int[][] game) {
        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < 9; k++) {
                if (game[i][k] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    int[] FindEmptyLocation(int[][] game, int r, int c) {
        int[][] location = new int[9][9];
        for (r = 0; r < 9; r++) {
            for (c = 0; c < 9; c++) {
                if (game[r][c] == 0) {

                    return new int[]{r, c};
                }
            }
        }

        return null;//no empty place
    }

    boolean InRightPalce(int i, int[][] game, int r, int c) {
        //check if there is an element equal to the new we wanna to add
        //column
        for (int k = 0; k < 9; k++) {
            if (game[r][k] == i) {  // if element found in the row
                return false;
            }
        }
        //row
        for (int k = 0; k < 9; k++) {
            if (game[k][c] == i) {
                return false;
            }

        }
        //panel
        int rstart = r - (r % 3);
        int cstart = c- (c % 3);
        for (int j = rstart; j < rstart+3; j++) {
            for (int k = cstart; k < cstart+3; k++) {
                if(game[j][k]==i)
                    return false;
            }
        }

        return true;
    }

}


