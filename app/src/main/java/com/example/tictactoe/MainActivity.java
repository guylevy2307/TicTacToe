package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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


    }

public void checkWin(){



}

    @Override
    public void onClick(View v) {
       Button b=(Button) v;
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
       if(turn%2==0) {
           b.setBackgroundResource(R.drawable.o);
          // char placeC=b.getText().charAt(6);
           Log.d("TAG", "onClick: "+b.getTag());

       }
       else {
           b.setBackgroundResource(R.drawable.x);
          // char placeC=b.getText().charAt(6);
           Log.d("TAG", "onClick: "+b.getTag());
       }
       turn++;
        b.setText("");
        if(turn>3){
            checkWin();
        }
    }
}