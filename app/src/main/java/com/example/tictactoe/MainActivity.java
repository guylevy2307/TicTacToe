package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int turn=0;
int[][] mat=new int[3][3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String text="button";
        for(int i=1;i<10;i++){
          String bText=text.concat(String.valueOf(i));
            //Log.d("TAG", "onCreate: "+bText);
            int resID = getResources().getIdentifier(bText, "id",getPackageName());
            //Log.d("TAG", "Find: "+resID);
          Button bt=(Button) this.findViewById(resID);
            bt.setOnClickListener(this);
        }
    }

        public boolean checkWin(){


                return false;
        }
        public void resetGame(){
            String text="button";
            for(int i=1;i<10;i++){
                String bText=text.concat(String.valueOf(i));
                //Log.d("TAG", "onCreate: "+bText);
                int resID = getResources().getIdentifier(bText, "id",getPackageName());
                //Log.d("TAG", "Find: "+resID);
                Button bt=(Button) this.findViewById(resID);
                bt.setText("Click");
                bt.setBackgroundResource(0);
                turn=0;
            }
        }

    @Override
    public void onClick(View v) {
       Button b=(Button) v;
        if(b.getText()==""){
            Toast.makeText(getApplicationContext(),"Please select another box this one is taken!",Toast.LENGTH_LONG).show();
        }
       else {
            TextView tv=(TextView) this.findViewById(R.id.main_winnnig);
            switch (b.getId()) {
                case R.id.button1:
                    mat[0][0]=turn%2;
                    break;
                case R.id.button2:
                    mat[0][1]=turn%2;
                    break;
                case R.id.button3:
                    mat[0][2]=turn%2;
                    break;
                case R.id.button4:
                    mat[1][0]=turn%2;
                    break;
                case R.id.button5:
                    mat[1][1]=turn%2;
                    break;
                case R.id.button6:
                    mat[1][2]=turn%2;
                    break;
                case R.id.button7:
                    mat[2][0]=turn%2;
                    break;
                case R.id.button8:
                    mat[2][1]=turn%2;
                    break;
                case R.id.button9:
                    mat[2][2]=turn%2;
                    break;

            }
            if (turn % 2 == 0)//now "0" play
                {
                b.setBackgroundResource(R.drawable.o);
               tv.setText("X turn");

            } else //turn%0==1 now "x" play
                {
                b.setBackgroundResource(R.drawable.x);
                 tv.setText("O turn");
            }
            turn++;
            b.setText("");

            if (turn > 3) {
               boolean win= checkWin();
               if(win){

                   resetGame();
               }
               if(turn==9){
                   Toast.makeText(getApplicationContext(),"Its tie!",Toast.LENGTH_LONG).show();

                   new android.os.Handler(Looper.getMainLooper()).postDelayed(
                           new Runnable() {
                               public void run() {
                                   resetGame();
                               }
                           },
                           2000);
               }
            }
        }
    }
}