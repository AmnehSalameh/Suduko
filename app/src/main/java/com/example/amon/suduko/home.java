package com.example.amon.suduko;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;

public class home extends AppCompatActivity {
    EditText[][] textViewArray = new EditText[9][9];
   /* int[][] c = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 7},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };*/
   int[][] c;

    //    TextView t=(TextView)findViewById(R.id.textView2);
    public final int CODE = 101;
    TextView time;
    private long startTime = 0L;
    private Handler customHandler = new Handler();
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;
    boolean stopTimer = false;
    private Runnable updateTimerThread = new Runnable() {
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            updatedTime = timeSwapBuff + timeInMilliseconds;
            int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            secs = secs % 60;
            int milliseconds = (int) (updatedTime % 1000);
            String localtime = "" + mins + ":" + String.format("%02d", secs)
                    + ":" + String.format("%03d", milliseconds);
            time.setText(localtime);
            if (!stopTimer)
                customHandler.postDelayed(this, 0);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        time = (TextView) findViewById(R.id.toto);
        startTime = SystemClock.uptimeMillis();
        customHandler.postDelayed(updateTimerThread, 0);

        c=FillDataRandomlly();
        //declare array

        textViewArray[0][0] = (EditText) findViewById(R.id.a1);
        textViewArray[0][1] = (EditText) findViewById(R.id.a2);
        textViewArray[0][2] = (EditText) findViewById(R.id.a3);
        textViewArray[1][0] = (EditText) findViewById(R.id.a4);
        textViewArray[1][1] = (EditText) findViewById(R.id.a5);
        textViewArray[1][2] = (EditText) findViewById(R.id.a6);
        textViewArray[2][0] = (EditText) findViewById(R.id.a7);
        textViewArray[2][1] = (EditText) findViewById(R.id.a8);
        textViewArray[2][2] = (EditText) findViewById(R.id.a9);
        //////////
        textViewArray[0][3] = (EditText) findViewById(R.id.b1);
        textViewArray[0][4] = (EditText) findViewById(R.id.b2);
        textViewArray[0][5] = (EditText) findViewById(R.id.b3);
        textViewArray[1][3] = (EditText) findViewById(R.id.b4);
        textViewArray[1][4] = (EditText) findViewById(R.id.b5);
        textViewArray[1][5] = (EditText) findViewById(R.id.b6);
        textViewArray[2][3] = (EditText) findViewById(R.id.b7);
        textViewArray[2][4] = (EditText) findViewById(R.id.b8);
        textViewArray[2][5] = (EditText) findViewById(R.id.b9);
        /////////
        textViewArray[0][6] = (EditText) findViewById(R.id.editText);
        textViewArray[0][7] = (EditText) findViewById(R.id.editText4);
        textViewArray[0][8] = (EditText) findViewById(R.id.editText2);
        textViewArray[1][6] = (EditText) findViewById(R.id.editText3);
        textViewArray[1][7] = (EditText) findViewById(R.id.editText5);
        textViewArray[1][8] = (EditText) findViewById(R.id.editText6);
        textViewArray[2][6] = (EditText) findViewById(R.id.editText7);
        textViewArray[2][7] = (EditText) findViewById(R.id.editText8);
        textViewArray[2][8] = (EditText) findViewById(R.id.editText9);
        ////////////
        textViewArray[3][0] = (EditText) findViewById(R.id.d1);
        textViewArray[3][1] = (EditText) findViewById(R.id.d2);
        textViewArray[3][2] = (EditText) findViewById(R.id.d3);
        textViewArray[4][0] = (EditText) findViewById(R.id.D4);
        textViewArray[4][1] = (EditText) findViewById(R.id.d5);
        textViewArray[4][2] = (EditText) findViewById(R.id.d6);
        textViewArray[5][0] = (EditText) findViewById(R.id.d7);
        textViewArray[5][1] = (EditText) findViewById(R.id.d8);
        textViewArray[5][2] = (EditText) findViewById(R.id.d9);
        //////////
        textViewArray[3][3] = (EditText) findViewById(R.id.editText19);
        textViewArray[3][4] = (EditText) findViewById(R.id.editText22);
        textViewArray[3][5] = (EditText) findViewById(R.id.editText20);
        textViewArray[4][3] = (EditText) findViewById(R.id.editText21);
        textViewArray[4][4] = (EditText) findViewById(R.id.editText23);
        textViewArray[4][5] = (EditText) findViewById(R.id.editText24);
        textViewArray[5][3] = (EditText) findViewById(R.id.editText25);
        textViewArray[5][4] = (EditText) findViewById(R.id.editText26);
        textViewArray[5][5] = (EditText) findViewById(R.id.editText27);
        /////////
        textViewArray[3][6] = (EditText) findViewById(R.id.editText55);
        textViewArray[3][7] = (EditText) findViewById(R.id.editText58);
        textViewArray[3][8] = (EditText) findViewById(R.id.editText56);
        textViewArray[4][6] = (EditText) findViewById(R.id.editText57);
        textViewArray[4][7] = (EditText) findViewById(R.id.editText59);
        textViewArray[4][8] = (EditText) findViewById(R.id.editText60);
        textViewArray[5][6] = (EditText) findViewById(R.id.editText61);
        textViewArray[5][7] = (EditText) findViewById(R.id.editText62);
        textViewArray[5][8] = (EditText) findViewById(R.id.editText63);
/////////////////
        textViewArray[6][0] = (EditText) findViewById(R.id.editText10);
        textViewArray[6][1] = (EditText) findViewById(R.id.editText13);
        textViewArray[6][2] = (EditText) findViewById(R.id.editText11);
        textViewArray[7][0] = (EditText) findViewById(R.id.editText12);
        textViewArray[7][1] = (EditText) findViewById(R.id.editText14);
        textViewArray[7][2] = (EditText) findViewById(R.id.editText15);
        textViewArray[8][0] = (EditText) findViewById(R.id.editText16);
        textViewArray[8][1] = (EditText) findViewById(R.id.editText17);
        textViewArray[8][2] = (EditText) findViewById(R.id.editText18);
        //////////
        textViewArray[6][3] = (EditText) findViewById(R.id.x1);
        textViewArray[6][4] = (EditText) findViewById(R.id.x2);
        textViewArray[6][5] = (EditText) findViewById(R.id.x3);
        textViewArray[7][3] = (EditText) findViewById(R.id.x4);
        textViewArray[7][4] = (EditText) findViewById(R.id.x5);
        textViewArray[7][5] = (EditText) findViewById(R.id.x6);
        textViewArray[8][3] = (EditText) findViewById(R.id.x7);
        textViewArray[8][4] = (EditText) findViewById(R.id.x8);
        textViewArray[8][5] = (EditText) findViewById(R.id.x9);
        ////////
        textViewArray[6][6] = (EditText) findViewById(R.id.y1);
        textViewArray[6][7] = (EditText) findViewById(R.id.y2);
        textViewArray[6][8] = (EditText) findViewById(R.id.y3);
        textViewArray[7][6] = (EditText) findViewById(R.id.y4);
        textViewArray[7][7] = (EditText) findViewById(R.id.y5);
        textViewArray[7][8] = (EditText) findViewById(R.id.y6);
        textViewArray[8][6] = (EditText) findViewById(R.id.y7);
        textViewArray[8][7] = (EditText) findViewById(R.id.y8);
        textViewArray[8][8] = (EditText) findViewById(R.id.y9);

        Fill();
        Button check = (Button) findViewById(R.id.check);
        Button back = (Button) findViewById(R.id.back);
        Button clear = (Button) findViewById(R.id.clear);
        Button solve = (Button) findViewById(R.id.slove);

        check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (isUniqe(textViewArray)) {
                    Intent i = new Intent(getApplicationContext(), RightansActivity.class);
                    i.putExtra("FSF", 3);
                    startActivity(i);
                } else {
                    Intent i = new Intent(getApplicationContext(), wrongAnswer.class);
                    i.putExtra("FSF", 3);
                    startActivity(i);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("FSF", 3);
                startActivity(i);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        textViewArray[i][j].setText("");
                    }
                }
                Fill();
            }
        });

        solve.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int[][] arr = new int[9][9];

                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if(!textViewArray[i][j].getText().toString().equals(""))
                        arr[i][j] = Integer.parseInt(textViewArray[i][j].getText().toString());
                        else
                            arr[i][j]=0;

                    }
                }

                    BackTracking c = new BackTracking();
                if (c.BackTracking(arr)) {
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            textViewArray[i][j].setText(arr[i][j] + "");
                        }
                    }
                }
                stopTimer=true;
                  time.setText(time.getText());

            }
        });
        //   h.postDelayed(updateTimerThread, 0);

    }
    private boolean isUniqe(TextView[][] text) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if(textViewArray[r][c].getText().toString().equals(""))
                    return false;
            }
        }
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if((Integer.parseInt(textViewArray[r][c].getText().toString())<0)||(Integer.parseInt(textViewArray[r][c].getText().toString())>10))
                    return false;
                if (!(UniqeC(Integer.parseInt(textViewArray[r][c].getText().toString()), c) || UniqeR(Integer.parseInt(textViewArray[r][c].getText().toString()), r) || UniqeP(Integer.parseInt(textViewArray[r][c].getText().toString()), r - r % 3, c - c % 3))) {
                    return false;

                }
            }
        }

        return true;
    }

    private boolean UniqeC(int x, int c) {
        int count = 0;

        for (int r = 0; r < 9; r++) {
            if ((Integer.parseInt(textViewArray[r][c].getText().toString())) == x) {
                count++;
            }
        }
        return count == 1;
    }

    private boolean UniqeR(int x, int r) {
        int count = 0;

        for (int c = 0; c < 9; c++) {
            if (Integer.parseInt(textViewArray[r][c].getText().toString()) == x) {
                count++;
            }
        }
        return count == 1;
    }

    private boolean UniqeP(int x, int ri, int ci) {
        ri = ri - (ri % 3);
        ci = ci - (ci % 3);
        int count = 0;
        for (int r = ri; r < ri + 3; r++) {
            for (int c = ci; c < ci + 3; c++) {
                if (Integer.parseInt(textViewArray[r][c].getText().toString()) == x) {
                    count++;
                }
            }
        }
        return count == 1;
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
        int cstart = c - (c % 3);
        for (int j = rstart; j < rstart + 3; j++) {
            for (int k = cstart; k < cstart + 3; k++) {
                if (game[j][k] == i) {
                    return false;
                }
            }
        }

        return true;
    }

    public void Fill() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                if (i < 3) {
                    if (c[i][j] == 0)
                        textViewArray[i][j].append("");
                    else {
                        textViewArray[i][j].append(c[i][j] + "");
                        textViewArray[i][j].setEnabled(false);
                    }
                } else if (i < 6) {
                    if (c[i][j] == 0)
                        textViewArray[i][j].append("");
                    else {
                        textViewArray[i][j].append(c[i][j] + "");
                        textViewArray[i][j].setEnabled(false);
                    }
                } else {
                    if (c[i][j] == 0)
                        textViewArray[i][j].append("");
                    else {
                        textViewArray[i][j].append(c[i][j] + "");
                        textViewArray[i][j].setEnabled(false);
                    }
                }
            }//end for
        }//end for
        //first three grids filled
        ///////////////////////////////

        for (int i = 0; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                if (i < 3) {
                    if (c[i][j] == 0)
                        textViewArray[i][j].append("");
                    else {
                        textViewArray[i][j].append(c[i][j] + "");
                        textViewArray[i][j].setEnabled(false);
                    }
                } else if (i < 6) {
                    if (c[i][j] == 0)
                        textViewArray[i][j].append("");
                    else {
                        textViewArray[i][j].append(c[i][j] + "");
                        textViewArray[i][j].setEnabled(false);
                    }
                } else {
                    if (c[i][j] == 0)
                        textViewArray[i][j].append("");
                    else {
                        textViewArray[i][j].append(c[i][j] + "");
                        textViewArray[i][j].setEnabled(false);
                    }
                }
            }//end for
        }//end for
        for (int i = 0; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                if (i < 3) {
                    if (c[i][j] == 0)
                        textViewArray[i][j].append("");
                    else {
                        textViewArray[i][j].append(c[i][j] + "");
                        textViewArray[i][j].setEnabled(false);
                    }
                } else if (i < 6) {
                    if (c[i][j] == 0)
                        textViewArray[i][j].append("");
                    else {
                        textViewArray[i][j].append(c[i][j] + "");
                        textViewArray[i][j].setEnabled(false);
                    }
                } else {
                    if (c[i][j] == 0)
                        textViewArray[i][j].append("");
                    else {
                        textViewArray[i][j].append(c[i][j] + "");
                        textViewArray[i][j].setEnabled(false);
                    }
                }
            }//end for
        }//end for
    }

    public int[][] FillDataRandomlly() {
        int[][] g = new int[9][9];
        int[][] game = new int[9][9];
        int r = 0, r2 = 0;
        int count = 0;
        int i = 0;
        int minumam= 17 + (int)(Math.random() * ((25 - 17) + 1));
        while (count < minumam) {
            r = (int) (Math.random() * 8);
            r2 = (int) (Math.random() * 8);
            i = 1 + (int) (Math.random() * 9);
            if (InRightPalce(i, game, r, r2)) {
                game[r][r2] = i;
                count++;
            }
        }

        BackTracking b=new BackTracking();
        if(b.BackTracking(game)==false){
            FillDataRandomlly();
        }
   for(int z=0;z<45;z++){
            int x = (int) (Math.random() * 8);
            int y = (int) (Math.random() * 8);
        game[x][y]=0;
        }
// System.out.print(g[0][2]);
        return game;

    }

}