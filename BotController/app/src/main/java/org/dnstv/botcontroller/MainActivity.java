package org.dnstv.botcontroller;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    OutputStream outputStream;
    String command;
    Button up,down,left,right,kick,exit;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // Print out your letter here...
            send(command);
            // Call the runnable again
            handler.postDelayed(this, 50);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        outputStream=DataHolder.getInstance().getData();

        up = (Button) findViewById(R.id.btnup);
        up.setOnClickListener(this);
        up.setOnTouchListener(new View.OnTouchListener() {
                                  @Override
                                  public boolean onTouch(View v, MotionEvent event) {
                                      switch(event.getAction()){
                                          case MotionEvent.ACTION_DOWN:
                                              command="1";
                                              handler.post(runnable);
                                              break;
                                          case MotionEvent.ACTION_CANCEL:
                                          case MotionEvent.ACTION_UP:
                                              // Stop printing the letter
                                              handler.removeCallbacks(runnable);
                                      }
                                      return true;
                                  }

                              });

        down = (Button) findViewById(R.id.btndown);
         down.setOnClickListener(this);
        down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        command="2";
                        handler.post(runnable);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        // Stop printing the letter
                        handler.removeCallbacks(runnable);
                }
                return true;
            }

        });

        left = (Button) findViewById(R.id.btnleft);
        left.setOnClickListener(this);
        left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        command="3";
                        handler.post(runnable);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        // Stop printing the letter
                        handler.removeCallbacks(runnable);
                }
                return true;
            }

        });


        right = (Button) findViewById(R.id.btnright);
        right.setOnClickListener(this);
        right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        command="4";
                        handler.post(runnable);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        // Stop printing the letter
                        handler.removeCallbacks(runnable);
                }
                return true;
            }

        });

        kick = (Button) findViewById(R.id.btnkick);
        kick.setOnClickListener(this);

        exit = (Button) findViewById(R.id.btnexit);
        exit.setOnClickListener(this);
    }

    public void send(String command)
    {
        try
        {
            outputStream.write(command.getBytes()); // Sends the number 1 to the Arduino. For a detailed look at how the resulting command is handled, please see the Arduino Source Code
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnup)
        {
            send("1");
        }
        if(v.getId()==R.id.btndown)
        {
            send("2");
        }
        if(v.getId()==R.id.btnleft)
        {
            send("3");
        }
        if(v.getId()==R.id.btnright)
        {
            send("4");
        }
        if(v.getId()==R.id.btnkick)
        {
            send("5");
        }
        if(v.getId()==R.id.btnexit)
        {
            Intent intent = new Intent(getApplicationContext(), Pair.class);
            startActivity(intent);
        }

    }


}

