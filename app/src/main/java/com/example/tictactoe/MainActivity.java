package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Integer turn=0;
    int[][] mat={{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
    boolean wins=false;
    char winsC;
    Integer Owin=0,Xwin=0 ;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String text="button";
        for(int i=1;i<10;i++){
          String bText=text.concat(String.valueOf(i));
            int resID = getResources().getIdentifier(bText, "id",getPackageName());
             Button bt=(Button) this.findViewById(resID);
            bt.setOnClickListener(this);
        }
    Button btR=(Button) this.findViewById(R.id.resetAll);
    btR.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            resetGame();
            resetScore();

        }
    });
    }

        public void checkWin(){
                for(int i=0;i<3;i++){
                       if(mat[i][0]==0&&mat[i][1]==0&&mat[i][2]==0)
                       {
                           wins=true;
                           winsC= 'o';
                           Owin++;
                           TextView tvWin1=(TextView)this.findViewById(R.id.OScore);
                           tvWin1.setText(Owin.toString());
                            drawLine(i);
                           break;
                       }
                       if (mat[0][i]==0&&mat[1][i]==0&&mat[2][i]==0)
                       {
                           wins=true;
                           winsC= 'o';
                           Owin++;
                           TextView tvWin1=(TextView)this.findViewById(R.id.OScore);
                           tvWin1.setText(Owin.toString());
                           drawCol(i);
                           break;
                       }

                       if(mat[0][0]==0&&mat[1][1]==0&&mat[2][2]==0)
                       {
                           wins=true;
                           winsC= 'o';
                           Owin++;
                           TextView tvWin1=(TextView)this.findViewById(R.id.OScore);
                           tvWin1.setText(Owin.toString());
                           drawLtR();
                           break;
                       }
                       if (mat[0][2]==0&&mat[1][1]==0&&mat[2][0]==0)
                       {
                           wins=true;
                           winsC= 'o';
                           Owin++;
                           TextView tvWin1=(TextView)this.findViewById(R.id.OScore);
                           tvWin1.setText(Owin.toString());
                           drawRtL();
                           break;
                       }
                        if(mat[i][0]==1&&mat[i][1]==1&&mat[i][2]==1) {
                            wins=true;
                            winsC= 'x';
                            Xwin++;
                            TextView tvWin=(TextView) this.findViewById(R.id.XScore);
                            tvWin.setText(Xwin.toString());
                            drawLine(i);
                            break;
                        }
                        if(mat[0][i]==1&&mat[1][i]==1&&mat[2][i]==1) {
                            wins=true;
                            winsC= 'x';
                            Xwin++;
                            TextView tvWin=(TextView) this.findViewById(R.id.XScore);
                            tvWin.setText(Xwin.toString());
                            drawCol(i);
                            break;
                        }
                        if( mat[0][0]==1&&mat[1][1]==1&&mat[2][2]==1) {
                            wins=true;
                            winsC= 'x';
                            Xwin++;
                            TextView tvWin=(TextView) this.findViewById(R.id.XScore);
                            tvWin.setText(Xwin.toString());
                            drawLtR();
                            break;
                        }
                      if(mat[0][2]==1&&mat[1][1]==1&&mat[2][0]==1){

                           wins=true;
                           winsC= 'x';
                           Xwin++;
                           TextView tvWin=(TextView) this.findViewById(R.id.XScore);
                           tvWin.setText(Xwin.toString());
                          drawRtL();
                          break;
                      }
                }
        }

     void drawLine(int i) {
         int j=i*3+1;
         int lim=j+3;
        String text="button";
        for(;j<lim;j++){
            String bText=text.concat(String.valueOf(j));
            int resID = getResources().getIdentifier(bText, "id",getPackageName());
            Button bt=(Button) this.findViewById(resID);
           bt.setText("???");
           bt.setTextSize(60);
        }
    }
    public  void drawCol(int i) {
        i+=1;
        String text="button";
        for( int time=0;time<3;i+=3,time++){
            String bText=text.concat(String.valueOf(i));
            int resID = getResources().getIdentifier(bText, "id",getPackageName());
            Button bt=(Button) this.findViewById(resID);
            bt.setText("???");
            bt.setTextSize(50);
        }
    }
    public void drawLtR() {
        Button bt;
        bt=(Button) this.findViewById(R.id.button1);
        bt.setText("???"  );
        bt.setTextSize(50);
        bt=(Button) this.findViewById(R.id.button5);
        bt.setText("???"  );
        bt.setTextSize(50);
        bt=(Button) this.findViewById(R.id.button9);
        bt.setText("???"  );
        bt.setTextSize(50);
    }
    public void drawRtL() {
        Button bt;
        bt=(Button) this.findViewById(R.id.button3);
        bt.setText("???"  );
        bt.setTextSize(50);
        bt=(Button) this.findViewById(R.id.button5);
        bt.setText("???"  );
        bt.setTextSize(50);
        bt=(Button) this.findViewById(R.id.button7);
        bt.setText("???"  );
        bt.setTextSize(50);
    }

    public void resetGame(){
            String text="button";
            for(int i=1;i<10;i++){
                String bText=text.concat(String.valueOf(i));
                //Log.d("TAG", "onCreate: "+bText);
                int resID = getResources().getIdentifier(bText, "id",getPackageName());
                //Log.d("TAG", "Find: "+resID);
                Button bt=(Button) this.findViewById(resID);
                bt.setText("Click!");
                bt.setTextSize(20);
                bt.setBackgroundResource(0);
                bt.setSelected(false);
                turn=0;
                for(int z=0;z<3;z++){
                    for(int q=0;q<3;q++){
                        mat[q][z]=2;
                    }


                }
                wins=false;
                winsC= 's';
                TextView tv=(TextView) this.findViewById(R.id.main_winnnig);
                tv.setText("O strat,good luck!");
            }
        }
    public void resetScore(){
        Owin=0;
        TextView tvWin1=(TextView) this.findViewById(R.id.OScore);
        tvWin1.setText(Owin.toString());
        Xwin=0;
        TextView tvWin2=(TextView) this.findViewById(R.id.XScore);
        tvWin2.setText(Xwin.toString());

    }
    @Override
    public void onClick(View v)
    {
       Button b=(Button) v;
       if(!wins){



           if (b.getText() == "") {
               Toast.makeText(getApplicationContext(), "Please select another box this one is taken!", Toast.LENGTH_LONG).show();
           } else {
               TextView tv = (TextView) this.findViewById(R.id.main_winnnig);
               switch (b.getId()) {
                   case R.id.button1:
                       mat[0][0] = turn % 2;
                       break;
                   case R.id.button2:
                       mat[0][1] = turn % 2;
                       break;
                   case R.id.button3:
                       mat[0][2] = turn % 2;
                       break;
                   case R.id.button4:
                       mat[1][0] = turn % 2;
                       break;
                   case R.id.button5:
                       mat[1][1] = turn % 2;
                       break;
                   case R.id.button6:
                       mat[1][2] = turn % 2;
                       break;
                   case R.id.button7:
                       mat[2][0] = turn % 2;
                       break;
                   case R.id.button8:
                       mat[2][1] = turn % 2;
                       break;
                   case R.id.button9:
                       mat[2][2] = turn % 2;
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
                   checkWin();
                   if (wins) {
                       tv.setText("The winner is: " + winsC + ",Thank you! :-) new round in 4 sec...");
                       new android.os.Handler(Looper.getMainLooper()).postDelayed(
                               new Runnable() {
                                   public void run() {
                                       resetGame();
                                   }
                               },
                               4000);
                   } else if (turn == 9 && !wins) {
                       tv.setText("Its tie! :-| new round in 4 sec...");


                       new android.os.Handler(Looper.getMainLooper()).postDelayed(
                               new Runnable() {
                                   public void run() {
                                       resetGame();
                                   }
                               },
                               4000);
                   }
               }
           }
       }
    }
}