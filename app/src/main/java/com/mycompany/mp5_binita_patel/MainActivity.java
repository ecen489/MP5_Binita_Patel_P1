package com.mycompany.mp5_binita_patel;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;
import android.media.Image;

public class MainActivity extends AppCompatActivity {
    int id;
    String duration ="0";
    MediaPlayer fall_apart;
    MediaPlayer psycho;
    MediaPlayer white_iverson;
    boolean play = false;
    //Play Songs
    public void Play(View view){
        if(id == R.id.Fall_Apart){
            fall_apart.start();
            play = true;
        }
        else if(id == R.id.Psycho){
            psycho.start();
            play = true;
        }
        else if(id == R.id.White_Iverson){
            white_iverson.start();
            play = true;
        }
    }
    //Pause Songs
    public void Pause(View view){
        if(id == R.id.Fall_Apart){
            fall_apart.stop();
            fall_apart.release();
            fall_apart = null;
            fall_apart = MediaPlayer.create(this, R.raw.fall_apart);
        }
        else if(id == R.id.Psycho){
            psycho.stop();
            psycho.release();
            psycho = null;
            psycho = MediaPlayer.create(this, R.raw.psycho);
        }
        else if(id == R.id.White_Iverson){
            white_iverson.stop();
            white_iverson.release();
            white_iverson = null;
            white_iverson = MediaPlayer.create(this, R.raw.white_iverson);
        }
    }
    //Radio Click
    public void radioClick(View view){
        ImageView image = (ImageView) findViewById(R.id.pic);
        id = view.getId();
        TextView msg = (TextView) findViewById(R.id.msg);

        if(fall_apart.isPlaying() || psycho.isPlaying() || white_iverson.isPlaying()){
            play = false;
        }
        if(id == R.id.Fall_Apart){
            image.setImageResource(R.drawable.capture);
            if(!play){
                fall_apart.start();
            }
            if(psycho.isPlaying()){
                psycho.stop();
                psycho.release();
                psycho = null;
                psycho = MediaPlayer.create(this, R.raw.psycho);
            }
            if(white_iverson.isPlaying()){
                white_iverson.stop();
                white_iverson.release();
                white_iverson = null;
                white_iverson = MediaPlayer.create(this, R.raw.white_iverson);
            }
            duration = Integer.toString(fall_apart.getDuration());
            msg.setText(msg.getText()+duration);
        }
        else if(id == R.id.Psycho){
            image.setImageResource(R.drawable.song2);
            if(!play){
                psycho.start();
            }
            if(fall_apart.isPlaying()){
                fall_apart.stop();
                fall_apart.release();
                fall_apart = null;
                fall_apart = MediaPlayer.create(this, R.raw.fall_apart);
            }
            if(white_iverson.isPlaying()){
                white_iverson.stop();
                white_iverson.release();
                white_iverson = null;
                white_iverson = MediaPlayer.create(this, R.raw.white_iverson);
            }
            duration = Integer.toString(psycho.getDuration());
            msg.setText(msg.getText()+duration);
        }
        else if(id == R.id.White_Iverson){
            image.setImageResource(R.drawable.song3);
            if(!play){
                white_iverson.start();
            }
            if(fall_apart.isPlaying()){
                fall_apart.stop();
                fall_apart.release();
                fall_apart = null;
                fall_apart = MediaPlayer.create(this, R.raw.fall_apart);
            }
            if(psycho.isPlaying()){
                psycho.stop();
                psycho.release();
                psycho = null;
                psycho = MediaPlayer.create(this, R.raw.psycho);
            }
            duration = Integer.toString(white_iverson.getDuration());
            msg.setText(msg.getText()+duration);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fall_apart = MediaPlayer.create(this, R.raw.fall_apart);
        psycho = MediaPlayer.create(this, R.raw.psycho);
        white_iverson = MediaPlayer.create(this, R.raw.white_iverson);
    }
}
