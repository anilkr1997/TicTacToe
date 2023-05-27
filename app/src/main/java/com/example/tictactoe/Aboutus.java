package com.example.tictactoe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class Aboutus extends AppCompatActivity {
    Button rateus;
    private AdView mAdView;
    InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("About Us");

        mAdView = (AdView) findViewById(R.id.adView);
      //  mAdView.setAdSize(AdSize.BANNER);
      //  mAdView.setAdUnitId(getString(R.string.banner_home_footer));

        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
       interstitialAd=new InterstitialAd(this);
       interstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));
        interstitialAd.loadAd(adRequest);


        TextView rateus =  findViewById(R.id.rateus);
        TextView mail = (TextView) findViewById(R.id.mail);
        TextView website = (TextView) findViewById(R.id.website);


        website.setText("https://vividtechno.com");
        mail.setText("sales.vividtechno@gmail.com");

        findViewById(R.id.subscribe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.youtube.com/user/vikasch01";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
               // i.putExtra(Intent.EXTRA_EMAIL, new String[]{""});
                i.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
                i.putExtra(Intent.EXTRA_TEXT, "Hey! I have downloded  "+getResources().getString(R.string.app_name)+" Cool Game. Its has Fun, strategic, and good for practice!" +
                        "Let's download this FREE Cool Game...." +
                        ".\n\n\nhttps://play.google.com/store/apps/details?id=com.vivid.tictactoe");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                }

                catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(Aboutus.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://vividtechno.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        rateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.vivid.tictactoe");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


         mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"sales.vividtechno@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "User Enquiry From App: "+getResources().getString(R.string.app_name));
                i.putExtra(Intent.EXTRA_TEXT, "Dear Vivid Technical Support, I downloaded your App "+getResources().getString(R.string.app_name)+" and I have following query:");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                }

                catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(Aboutus.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }

        });



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;

        }
        return super.onOptionsItemSelected(item);
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
