package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class StageActivity extends AppCompatActivity {
     Button playc,playf,simpleplay,about;
    private AdView mAdView;
    InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage);
        new NotificationHelper(StageActivity.this).createNotification("ashish","Sikarwar");
        mAdView = (AdView) findViewById(R.id.adView);
        //  mAdView.setAdSize(AdSize.BANNER);
//        mAdView.setAdUnitId(getString(R.string.banner_home_footer));

        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
        interstitialAd=new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));
        interstitialAd.loadAd(adRequest);

        playc=findViewById(R.id.playc);
        playf=findViewById(R.id.playf);
        simpleplay=findViewById(R.id.simpleplay);
        about=findViewById(R.id.about);
        Typeface font = Typeface.createFromAsset(getAssets(), "b.otf");
        about.setTypeface(font);
        playf.setTypeface(font);
        playc.setTypeface(font);
        simpleplay.setTypeface(font);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StageActivity.this,Aboutus.class).putExtra("key",1));
            }
        });

        playf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StageActivity.this,PlayerName.class).putExtra("key",1));
            }
        });
        playc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StageActivity.this,PlayerName.class).putExtra("key",2));
            }
        });
        simpleplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StageActivity.this,PlayerName.class).putExtra("key",3));
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
                        new AlertDialog.Builder(StageActivity.this)
                                .setTitle("Close")
                                .setMessage("Do you really want to close this Game?")

                                // Specifying a listener allows you to take an action before dismissing the dialog.
                                // The dialog is automatically dismissed when a dialog button is clicked.
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                }) .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Continue with delete operation
                            }
                        })

                                // A null listener allows the button to dismiss the dialog and take no further action.

                                .setIcon(R.drawable.logo)
                                .show();
                    }
                });
            }
            else{
                new AlertDialog.Builder(StageActivity.this)
                        .setTitle("Close")
                        .setMessage("Do you really want to close this Game?")

                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                             finish();
                            }
                        }) .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                    }
                })

                        // A null listener allows the button to dismiss the dialog and take no further action.

                        .setIcon(R.drawable.logo)
                        .show();
            }
        }

        return super.onKeyDown(keyCode, event);
    }

}
