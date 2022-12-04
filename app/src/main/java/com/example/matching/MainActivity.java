package com.example.matching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Handler h = new Handler();
    private MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySong = MediaPlayer.create(MainActivity.this, R.raw.jetpackjoyride);
        mySong.start();
        mySong.setLooping(true);
        h.postDelayed(() -> {
            Intent i = new Intent(MainActivity.this, Splash.class);
            startActivity(i);

        },1500);
    }

    public void play(View v)
    {
        mySong = MediaPlayer.create(MainActivity.this, R.raw.jetpackjoyride);

        mySong.start();
    }

    public void pause(View v){
        if(mySong != null){
            mySong.pause();
        }
    }

    public void stop(View v){
        stopPlayer();
    }

    private void stopPlayer(){
        if(mySong != null){
            mySong.release();
            mySong = null;
            Toast.makeText(this,"Media Player released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        stopPlayer();
    }




}