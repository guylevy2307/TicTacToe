package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int turn=0;

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
        TextView tv=(TextView) this.findViewById(R.id.main_winnnig);
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(turn==0){
                            tv.setText("O start,Good luck");
                        }
                            else if(turn%2==0){
                                tv.setText("It's O turn now!");
                        }else{
                            tv.setText("It's X turn now!");
                        }
                    }
                });

    }

public void checkWin(){



}

    @Override
    public void onClick(View v) {
       Button b=(Button) v;
        if(b.getText()==""){
            Toast.makeText(getApplicationContext(),"Please select another box this one is taken!",Toast.LENGTH_LONG).show();
        }
       else {
            switch (b.getId()) {
                case R.id.button1:
                    // do something
                    break;
                case R.id.button2:
                    // do something
                    break;
                case R.id.button3:
                    // do something
                    break;
                case R.id.button4:
                    // do something
                    break;
                case R.id.button5:
                    // do something
                    break;
                case R.id.button6:
                    // do something
                    break;
                case R.id.button7:
                    // do something
                    break;
                case R.id.button8:
                    // do something
                    break;
                case R.id.button9:
                    // do something
                    break;

            }
            if (turn % 2 == 0) {
                b.setBackgroundResource(R.drawable.o);
                //tv.setText("X turn");

            } else {
                b.setBackgroundResource(R.drawable.x);
                // tv.setText("O turn");
            }
            turn++;
            b.setText("");

            if (turn > 3) {
                checkWin();
            }
        }
    }
}