package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.net.Socket;

public class PlayerName extends AppCompatActivity {

    EditText name1,name2;
    Button play;
    int key;
    private AdView mAdView;
    InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name);
        mAdView = (AdView) findViewById(R.id.adView);
        //  mAdView.setAdSize(AdSize.BANNER);
        //mAdView.setAdUnitId(getString(R.string.banner_home_footer));

        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
        interstitialAd=new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));
        interstitialAd.loadAd(adRequest);

        key=getIntent().getExtras().getInt("key");
        name1=findViewById(R.id.name1);
        name2=findViewById(R.id.name2);
        play=findViewById(R.id.play);
        if(key==1){}
        else if(key==2){
            name2.setText("Computer");
        }
        else{
            name2.setText("Computer");
        }
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String string1=name1.getText().toString().trim();
                String string2=name2.getText().toString().trim();

                if(string1.isEmpty()  || string2.isEmpty()  )
                    Toast.makeText(PlayerName.this, "Insert Value", Toast.LENGTH_SHORT).show();
                else{
                    if(key==1){
                        startActivity(new Intent(PlayerName.this,GameActivity.class).putExtra("1",name1.getText().toString()).putExtra("2",name2.getText().toString()));

                    }
                    else if(key==2){
                        startActivity(new Intent(PlayerName.this,ComputerActivity.class).putExtra("1",name1.getText().toString()).putExtra("2",name2.getText().toString()));

                    }
                    else{
                        startActivity(new Intent(PlayerName.this,SimpleGame.class).putExtra("1",name1.getText().toString()).putExtra("2",name2.getText().toString()));

                    }
                }
               }
        });
    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==event.KEYCODE_BACK ){
            if(interstitialAd.isLoaded()){
                interstitialAd.show();
                interstitialAd.setAdListener(new AdListener(){

                    @Override
                    public void onAdClosed() {
                        super.onAdClosed();
                        finish();
                    }
                });
            }
            else{
                finish();
            }
        }

        return super.onKeyDown(keyCode, event);
    }

}
