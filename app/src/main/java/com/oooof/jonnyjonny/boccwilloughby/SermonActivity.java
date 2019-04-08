package com.oooof.jonnyjonny.boccwilloughby;

import android.content.ClipData;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class SermonActivity extends AppCompatActivity   {
    private SeekBar mSeekbar;
    private Button playBtn;
    private TextView sermonLink;
    private TextView devotionLink;
    private MediaPlayer mediaPlayer;



    int sermon_list[]={R.raw.dec24sermon,R.raw.dec30sermon,R.raw.jan6sermon,R.raw.jan13bocsermon,R.raw.january20sermon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sermon);
         mediaPlayer=new MediaPlayer();
        mediaPlayer=MediaPlayer.create(SermonActivity.this,R.raw.mar_3serm);
        mSeekbar=(SeekBar)findViewById(R.id.mSeekbar);
        mSeekbar.setMax(mediaPlayer.getDuration());
        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser){
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        playBtn=findViewById(R.id.playBtn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    pauseSermon();
                }else {
                    startSermon();
                }
            }
        });
        sermonLink=findViewById(R.id.sermonTLink);
        devotionLink=findViewById(R.id.txtDevotionLink);
        devotionLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent devotionIntent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.intouch.org/read/magazine/daily-devotions"));
                startActivity(devotionIntent);
            }
        });
        sermonLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sermonIntent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.bodyofchristcommunity.org/Messages.html"));
                startActivity(sermonIntent);
            }
        });

        }
        public void startSermon(){
        if(mediaPlayer!=null){
            mediaPlayer.start();
            playBtn.setBackgroundResource(R.drawable.ic_pause);
        }



        }
        public void pauseSermon(){
        if (mediaPlayer!=null){
            mediaPlayer.pause();
            playBtn.setBackgroundResource(R.drawable.ic_play_circle_filled_black_24dp);
        }

        }
    }


