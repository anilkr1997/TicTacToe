package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class ComputerActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9;
    int term=1;
    String firstp="X";
    String secondp="Y";
    int value=0;
    TextView turn;
    Button reset;
    String c1="",c2="",c3="",c4="",c5="",c6="",c7="",c8="",c9="";
    String currentplayer;
    private AdView mAdView;
    InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);
        mAdView = (AdView) findViewById(R.id.adView);
        //  mAdView.setAdSize(AdSize.BANNER);
      //  mAdView.setAdUnitId(getString(R.string.banner_home_footer));

        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
        interstitialAd=new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));
        interstitialAd.loadAd(adRequest);

        try{
            firstp=getIntent().getExtras().getString("1");
            secondp=getIntent().getExtras().getString("2");}
        catch (Exception e){
            firstp="You";
            secondp="Computer";
        }
        currentplayer=firstp;
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        tv5=findViewById(R.id.tv5);
        tv6=findViewById(R.id.tv6);
        tv7=findViewById(R.id.tv7);
        tv8=findViewById(R.id.tv8);
        tv9=findViewById(R.id.tv9);
        turn=findViewById(R.id.turn);
        reset=findViewById(R.id.reset);
        turn.setText(currentplayer+" Terms");
        reset();
        applyclick();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
                applyclick();
                turn.setText(currentplayer+" Terms");
            }
        });
    }

    private void applyclick() {
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv6.setOnClickListener(this);
        tv7.setOnClickListener(this);
        tv8.setOnClickListener(this);
        tv9.setOnClickListener(this);
        tv1.setEnabled(true);
        tv2.setEnabled(true);
        tv3.setEnabled(true);
        tv4.setEnabled(true);
        tv5.setEnabled(true);
        tv6.setEnabled(true);
        tv7.setEnabled(true);
        tv8.setEnabled(true);
        tv9.setEnabled(true);
    }


    private void disable() {
        tv1.setOnClickListener(null);
        tv2.setOnClickListener(null);
        tv3.setOnClickListener(null);
        tv4.setOnClickListener(null);
        tv5.setOnClickListener(null);
        tv6.setOnClickListener(null);
        tv7.setOnClickListener(null);
        tv8.setOnClickListener(null);
        tv9.setOnClickListener(null);
    }


    public void reset(){
        currentplayer=firstp;
        value=0;
        c1="";
        c2="";
        c3="";
        c4="";
        c5="";
        c6="";
        c7="";
        c8="";
        c9="";

        tv1.setText("");
        tv2.setText("");
        tv3.setText("");
        tv4.setText("");
        tv5.setText("");
        tv6.setText("");
        tv7.setText("");
        tv8.setText("");
        tv9.setText("");

    }

    @Override
    public void onClick(View v) {

        turn.setText(firstp+" Term");
        switch (v.getId()){
            case R.id.tv1:
                c1="X";
                tv1.setText(c1);
                break;


            case R.id.tv2:
                c2="X";
                tv2.setText(c2);
                break;



            case R.id.tv3:
                c3="X";
                tv3.setText(c3);
                break;



            case R.id.tv4:
                c4="X";
                tv4.setText(c4);
                break;


            case R.id.tv5:
                c5="X";
                tv5.setText(c5);
                break;



            case R.id.tv6:
                c6="X";
                tv6.setText(c6);
                break;


            case R.id.tv7:
                c7="X";
                tv7.setText(c7);
                break;


            case R.id.tv8:
                c8="X";
                tv8.setText(c8);
                break;

            case R.id.tv9:
                c9="X";
                tv9.setText(c9);
                break;
        }
        v.setEnabled(false);
        verify();

    }

 /*   public void getValue(String c1,String c2,String c3,String c4,String c5,String c6,String c7
            ,String c8,String c9,int value){
        this.c1=c1;
        this.c2=c2;
        this.c3=c3;
        this.c4=c4;
        this.c5=c5;
        this.c6=c6;
        this.c7=c7;
        this.c8=c8;
        this.c9=c9;
        this.value=value;
        tv1.setText(c1);
        tv2.setText(c2);
        tv3.setText(c3);
        tv4.setText(c4);
        tv5.setText(c5);
        tv6.setText(c6);
        tv7.setText(c7);
        tv8.setText(c8);
        tv9.setText(c9);

        verify();

    }*/

    private void verify() {
        if((c1.equals("0") && c2.equals("0") && c3.equals("0")) || (c1.equals("0") && c4.equals("0") && c7.equals("0"))
                || (c1.equals("0") && c5.equals("0") && c9.equals("0"))||
                (c2.equals("0") && c5.equals("0") && c8.equals("0"))
                || (c3.equals("0") && c6.equals("0") && c9.equals("0")) || (c3.equals("0") && c5.equals("0") && c7.equals("0"))
                || (c4.equals("0") && c5.equals("0") && c6.equals("0"))
                || (c7.equals("0") && c8.equals("0") && c9.equals("0")))

        {
            disable();
            new AlertDialog.Builder(ComputerActivity.this)
                    .setTitle("Result")
                    .setMessage(secondp+" won.")

                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Continue with delete operation
                        }
                    })

                    // A null listener allows the button to dismiss the dialog and take no further action.

                    .setIcon(R.drawable.logo)
                    .show();

            Toast.makeText(ComputerActivity.this,secondp+" won",Toast.LENGTH_SHORT).show();
            if(currentplayer.equals(firstp)){
                currentplayer=secondp;
            }
            else{
                currentplayer=firstp;
            }
            turn.setText(secondp+" Won");


        }

        else if((c1.equals("X") && c2.equals("X") && c3.equals("X")) || (c1.equals("X") && c4.equals("X") && c7.equals("X"))
                || (c1.equals("X") && c5.equals("X") && c9.equals("X"))||
                (c2.equals("X") && c5.equals("X") && c8.equals("X"))
                || (c3.equals("X") && c6.equals("X") && c9.equals("X")) || (c3.equals("X") && c5.equals("X") && c7.equals("X"))
                || (c4.equals("X") && c5.equals("X") && c6.equals("X"))
                || (c7.equals("X") && c8.equals("X") && c9.equals("X")))

        {
            disable();

            new AlertDialog.Builder(ComputerActivity.this)
                    .setTitle("Result")
                    .setMessage(firstp+" won.")

                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Continue with delete operation
                        }
                    })

                    // A null listener allows the button to dismiss the dialog and take no further action.

                    .setIcon(R.drawable.logo)
                    .show();

            Toast.makeText(ComputerActivity.this,firstp+" won",Toast.LENGTH_SHORT).show();
            if(currentplayer.equals(firstp)){
                currentplayer=secondp;
            }
            else{
                currentplayer=firstp;
            }
            turn.setText(firstp+" Won");

        }

        else if(!c1.equals("") && !c2.equals("")&& !c3.equals("")&& !c4.equals("")&& !c5.equals("")
                && !c6.equals("")&& !c7.equals("")&& !c8.equals("")&& !c9.equals("")){
            Toast.makeText(ComputerActivity.this,"Draw",Toast.LENGTH_SHORT).show();
            disable();
            if(currentplayer.equals(firstp)){
                currentplayer=secondp;
            }
            else{
                currentplayer=firstp;
            }
            new AlertDialog.Builder(ComputerActivity.this)
                    .setTitle("Result")
                    .setMessage("Match" +" is Draw.")

                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Continue with delete operation
                        }
                    })

                    // A null listener allows the button to dismiss the dialog and take no further action.

                    .setIcon(R.drawable.logo)
                    .show();

            turn.setText(" Draw");

        }
  else{
      smartcomputer();
        }

    }


    private void verify1() {
        if((c1.equals("0") && c2.equals("0") && c3.equals("0")) || (c1.equals("0") && c4.equals("0") && c7.equals("0"))
                || (c1.equals("0") && c5.equals("0") && c9.equals("0"))||
                (c2.equals("0") && c5.equals("0") && c8.equals("0"))
                || (c3.equals("0") && c6.equals("0") && c9.equals("0")) || (c3.equals("0") && c5.equals("0") && c7.equals("0"))
                || (c4.equals("0") && c5.equals("0") && c6.equals("0"))
                || (c7.equals("0") && c8.equals("0") && c9.equals("0")))

        {
            disable();
            new AlertDialog.Builder(ComputerActivity.this)
                    .setTitle("Result")
                    .setMessage(secondp+" won.")

                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Continue with delete operation
                        }
                    })

                    // A null listener allows the button to dismiss the dialog and take no further action.

                    .setIcon(R.drawable.logo)
                    .show();

            Toast.makeText(ComputerActivity.this,secondp+" won",Toast.LENGTH_SHORT).show();
            if(currentplayer.equals(firstp)){
                currentplayer=secondp;
            }
            else{
                currentplayer=firstp;
            }
            turn.setText(currentplayer+" Won");


        }

        else if((c1.equals("X") && c2.equals("X") && c3.equals("X")) || (c1.equals("X") && c4.equals("X") && c7.equals("X"))
                || (c1.equals("X") && c5.equals("X") && c9.equals("X"))||
                (c2.equals("X") && c5.equals("X") && c8.equals("X"))
                || (c3.equals("X") && c6.equals("X") && c9.equals("X")) || (c3.equals("X") && c5.equals("X") && c7.equals("X"))
                || (c4.equals("X") && c5.equals("X") && c6.equals("X"))
                || (c7.equals("X") && c8.equals("X") && c9.equals("X")))

        {
            disable();

            new AlertDialog.Builder(ComputerActivity.this)
                    .setTitle("Result")
                    .setMessage(firstp+" won.")

                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Continue with delete operation
                        }
                    })

                    // A null listener allows the button to dismiss the dialog and take no further action.

                    .setIcon(R.drawable.logo)
                    .show();

            Toast.makeText(ComputerActivity.this,firstp+" won",Toast.LENGTH_SHORT).show();
            if(currentplayer.equals(firstp)){
                currentplayer=secondp;
            }
            else{
                currentplayer=firstp;
            }
            turn.setText(currentplayer+" Won");

        }

        else if(!c1.equals("") && !c2.equals("")&& !c3.equals("")&& !c4.equals("")&& !c5.equals("")
                && !c6.equals("")&& !c7.equals("")&& !c8.equals("")&& !c9.equals("")){
            Toast.makeText(ComputerActivity.this,"Draw",Toast.LENGTH_SHORT).show();
            disable();
            if(currentplayer.equals(firstp)){
                currentplayer=secondp;
            }
            else{
                currentplayer=firstp;
            }
            new AlertDialog.Builder(ComputerActivity.this)
                    .setTitle("Result")
                    .setMessage("Match" +" is Draw.")

                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Continue with delete operation
                        }
                    })

                    // A null listener allows the button to dismiss the dialog and take no further action.

                    .setIcon(R.drawable.logo)
                    .show();

            turn.setText(" Draw");

        }


    }


    public void computerterm(){
        if(currentplayer.equals(firstp)){
            currentplayer=secondp;
        }
        else{
            currentplayer=firstp;
        }
        if(c1.equals("")){
            tv1.setEnabled(false);
            tv1.setText("0");
            c1="0";

        }
        else if(c2.equals("")){
            tv2.setEnabled(false);
            tv2.setText("0");
            c2="0";

        }
        else if(c3.equals("")){
            tv3.setEnabled(false);
            tv3.setText("0");
            c3="0";

        }
        else if(c4.equals("")){
            tv4.setEnabled(false);
            tv4.setText("0");
            c4="0";

        }
        else if(c5.equals("")){
            tv5.setEnabled(false);
            tv5.setText("0");
            c5="0";

        }
        else if(c6.equals("")){
            tv6.setEnabled(false);
            tv6.setText("0");
            c6="0";

        }
        else if(c7.equals("")){
            tv7.setEnabled(false);
            tv7.setText("0");
            c7="0";

        }
        else if(c8.equals("")){
            tv8.setEnabled(false);
            tv8.setText("0");
            c8="0";

        }
        else if(c9.equals("")){
            tv9.setEnabled(false);
            tv9.setText("0");
            c9="0";

        }

        if(currentplayer.equals(firstp)){
            currentplayer=secondp;
        }
        else{
            currentplayer=firstp;
        }

       // getValue(c1,c2,c3,c4,c5,c6,c7,c8,c9,0);
        verify1();
      /*  else if(c2.equals("")){
            c9="0";
            return;
        }*/
    }


    public void smartcomputer(){


    if(c1.equals("0")&&c2.equals("0")&&c3.equals("")){
        c3="0";
        tv3.setText(c3);
        tv3.setEnabled(false);
        Log.d("ashishsikarwar","1");

    }

  else  if(c1.equals("0")&&c2.equals("")&&c3.equals("0")){
        c2="0";
        tv2.setText(c2);
        tv2.setEnabled(false);        Log.d("ashishsikarwar","2");

    }

  else  if(c1.equals("")&&c2.equals("0")&&c3.equals("0")){
        c1="0";
        tv1.setText(c1);
        tv1.setEnabled(false);        Log.d("ashishsikarwar","3");

    }
    else  if(c4.equals("")&&c5.equals("0")&&c6.equals("0")){
        c4="0";
        tv4.setText(c4);
        tv4.setEnabled(false);        Log.d("ashishsikarwar","4");

    }
    else  if(c4.equals("0")&&c5.equals("")&&c6.equals("0")){
        c5="0";
        tv5.setText(c5);
        tv5.setEnabled(false);        Log.d("ashishsikarwar","5");

    }
    else  if(c4.equals("0")&&c5.equals("0")&&c6.equals("")){
        c6="0";
        tv6.setText(c6);
        tv6.setEnabled(false);        Log.d("ashishsikarwar","6");

    }


    else  if(c7.equals("0")&&c8.equals("")&&c9.equals("0")){
        c8="0";
        tv8.setText(c8);
        tv8.setEnabled(false);   Log.d("ashishsikarwar","7");
    }

    else  if(c7.equals("0")&&c8.equals("0")&&c9.equals("")){
        c9="0";
        tv9.setText(c9);
        tv9.setEnabled(false);        Log.d("ashishsikarwar","8");

    }

    else  if(c7.equals("")&&c8.equals("0")&&c9.equals("0")){
        c7="0";
        tv7.setText(c7);
        tv7.setEnabled(false);        Log.d("ashishsikarwar","9");

    }

    else  if(c1.equals("0")&&c4.equals("0")&&c7.equals("")){
        c7="0";
        tv7.setText(c7);
        tv7.setEnabled(false);        Log.d("ashishsikarwar","10");

    }

    else  if(c1.equals("0")&&c4.equals("")&&c7.equals("0")){
        c4="0";
        tv4.setText(c4);
        tv4.setEnabled(false);        Log.d("ashishsikarwar","11");

    }

    else  if(c1.equals("")&&c4.equals("0")&&c7.equals("0")){
        c1="0";
        tv1.setText(c1);
        tv1.setEnabled(false);        Log.d("ashishsikarwar","12");

    }


    else  if(c1.equals("")&&c5.equals("0")&&c9.equals("0")){
        c1="0";
        tv1.setText(c1);
        tv1.setEnabled(false);        Log.d("ashishsikarwar","13");

    }

    else  if(c1.equals("0")&&c5.equals("")&&c9.equals("0")){
        c5="0";
        tv5.setText(c5);
        tv5.setEnabled(false);        Log.d("ashishsikarwar","14");

    }

    else  if(c1.equals("0")&&c5.equals("0")&&c9.equals("")){
        c9="0";
        tv9.setText(c9);
        tv9.setEnabled(false);        Log.d("ashishsikarwar","15");

    }

    else  if(c2.equals("0")&&c5.equals("")&&c8.equals("0")){
        c5="0";
        tv5.setText(c5);
        tv5.setEnabled(false);        Log.d("ashishsikarwar","16");

    }

    else  if(c2.equals("0")&&c5.equals("0")&&c8.equals("")){
        c8="0";
        tv8.setText(c8);
        tv8.setEnabled(false);        Log.d("ashishsikarwar","17");

    }

    else  if(c2.equals("")&&c5.equals("0")&&c8.equals("0")){
        c2="0";
        tv2.setText(c2);
        tv2.setEnabled(false);        Log.d("ashishsikarwar","18");

    }


    else if(c3.equals("")&&c6.equals("0")&&c9.equals("0")){
        c3="0";
        tv3.setText(c3);
        tv3.setEnabled(false);        Log.d("ashishsikarwar","19");

    }

    else if(c3.equals("0")&&c6.equals("")&&c9.equals("0")){
        c6="0";
        tv6.setText(c6);
        tv6.setEnabled(false);        Log.d("ashishsikarwar","20");

    }


    else  if(c3.equals("0")&&c6.equals("0")&&c9.equals("")){
        c9="0";
        tv9.setText(c9);
        tv9.setEnabled(false);        Log.d("ashishsikarwar","21");

    }



    else  if(c3.equals("")&&c5.equals("0")&&c7.equals("0")){
        c3="0";
        tv3.setText(c3);
        tv3.setEnabled(false);        Log.d("ashishsikarwar","1");

    }



    else  if(c3.equals("0")&&c5.equals("")&&c7.equals("0")){
        c5="0";
        tv5.setText(c5);
        tv5.setEnabled(false);        Log.d("ashishsikarwar","1");

    }

    else  if(c3.equals("0")&&c5.equals("0")&&c7.equals("")){
        c7="0";
        tv7.setText(c7);
        tv7.setEnabled(false);        Log.d("ashishsikarwar","1");

    }

    else  if(c4.equals("")&&c5.equals("0")&&c6.equals("0")){
        c4="0";
        tv4.setText(c7);
        tv4.setEnabled(false);        Log.d("ashishsikarwar","1");

    }

    else  if(c4.equals("0")&&c5.equals("")&&c6.equals("0")){
        c5="0";
        tv5.setText(c5);
        tv5.setEnabled(false);        Log.d("ashishsikarwar","1");

    }

    else  if(c4.equals("0")&&c5.equals("0")&&c6.equals("")){
        c6="0";
        tv6.setText(c6);
        tv6.setEnabled(false);        Log.d("ashishsikarwar","1");

    }

    else  if(c7.equals("")&&c8.equals("0")&&c9.equals("0")){
        c7="0";
        tv7.setText(c7);
        tv7.setEnabled(false);        Log.d("ashishsikarwar","1");

    }


    else  if(c7.equals("0")&&c8.equals("")&&c9.equals("0")){
        c8="0";
        tv8.setText(c8);
        tv8.setEnabled(false);        Log.d("ashishsikarwar","1");

    }


    else  if(c7.equals("0")&&c8.equals("0")&&c9.equals("")){
        c9="0";
        tv9.setText(c9);
        tv9.setEnabled(false);        Log.d("ashishsikarwar","1");

    }












      else  if(c1.equals("X")&&c2.equals("X")&&c3.equals("")){
            c3="0";
            tv3.setText(c3);
            tv3.setEnabled(false);

        }

        else  if(c1.equals("X")&&c2.equals("")&&c3.equals("X")){
            c2="0";
            tv2.setText(c2);
            tv2.setEnabled(false);
        }

        else  if(c1.equals("")&&c2.equals("X")&&c3.equals("X")){
            c1="0";
            tv1.setText(c1);
            tv1.setEnabled(false);
        }
        else  if(c4.equals("")&&c5.equals("X")&&c6.equals("X")){
            c4="0";
            tv4.setText(c4);
            tv4.setEnabled(false);
        }
        else  if(c4.equals("X")&&c5.equals("")&&c6.equals("X")){
            c5="0";
            tv5.setText(c5);
            tv5.setEnabled(false);
        }
        else  if(c4.equals("X")&&c5.equals("X")&&c6.equals("")){
            c6="0";
            tv6.setText(c6);
            tv6.setEnabled(false);
        }


        else  if(c7.equals("X")&&c8.equals("")&&c9.equals("X")){
            c8="0";
            tv8.setText(c8);
            tv8.setEnabled(false);
        }

        else  if(c7.equals("X")&&c8.equals("X")&&c9.equals("")){
            c9="0";
            tv9.setText(c9);
            tv9.setEnabled(false);
        }

        else  if(c7.equals("")&&c8.equals("X")&&c9.equals("X")){
            c7="0";
            tv7.setText(c7);
            tv7.setEnabled(false);
        }

        else  if(c1.equals("X")&&c4.equals("X")&&c7.equals("")){
            c7="0";
            tv7.setText(c7);
            tv7.setEnabled(false);
        }

        else  if(c1.equals("X")&&c4.equals("")&&c7.equals("X")){
            c4="0";
            tv4.setText(c4);
            tv4.setEnabled(false);
        }

        else  if(c1.equals("")&&c4.equals("X")&&c7.equals("X")){
            c1="0";
            tv1.setText(c1);
            tv1.setEnabled(false);
        }


        else  if(c1.equals("")&&c5.equals("X")&&c9.equals("X")){
            c1="0";
            tv1.setText(c1);
            tv1.setEnabled(false);
        }

        else  if(c1.equals("X")&&c5.equals("")&&c9.equals("X")){
            c5="0";
            tv5.setText(c5);
            tv5.setEnabled(false);
        }

        else  if(c1.equals("X")&&c5.equals("X")&&c9.equals("")){
            c9="0";
            tv9.setText(c9);
            tv9.setEnabled(false);
        }

        else  if(c2.equals("X")&&c5.equals("")&&c8.equals("X")){
            c5="0";
            tv5.setText(c5);
            tv5.setEnabled(false);
        }

        else  if(c2.equals("X")&&c5.equals("X")&&c8.equals("")){
            c8="0";
            tv8.setText(c8);
            tv8.setEnabled(false);
        }

        else  if(c2.equals("")&&c5.equals("X")&&c8.equals("X")){
            c2="0";
            tv2.setText(c2);
            tv2.setEnabled(false);
        }


        else  if(c3.equals("")&&c6.equals("X")&&c9.equals("X")){
            c3="0";
            tv3.setText(c3);
            tv3.setEnabled(false);
        }

        else  if(c3.equals("X")&&c6.equals("")&&c9.equals("X")){
            c6="0";
            tv6.setText(c6);
            tv6.setEnabled(false);
        }


        else  if(c3.equals("X")&&c6.equals("X")&&c9.equals("")){
            c9="0";
            tv9.setText(c9);
            tv9.setEnabled(false);
        }



        else  if(c3.equals("")&&c5.equals("X")&&c7.equals("X")){
            c3="0";
            tv3.setText(c3);
            tv3.setEnabled(false);
        }



        else  if(c3.equals("X")&&c5.equals("")&&c7.equals("X")){
            c5="0";
            tv5.setText(c5);
            tv5.setEnabled(false);
        }

        else  if(c3.equals("X")&&c5.equals("X")&&c7.equals("")){
            c7="0";
            tv7.setText(c7);
            tv7.setEnabled(false);
        }

        else  if(c4.equals("")&&c5.equals("X")&&c6.equals("X")){
            c4="0";
            tv4.setText(c7);
            tv4.setEnabled(false);
        }

        else  if(c4.equals("X")&&c5.equals("")&&c6.equals("X")){
            c5="0";
            tv5.setText(c5);
            tv5.setEnabled(false);
        }

        else  if(c4.equals("X")&&c5.equals("X")&&c6.equals("")){
            c6="0";
            tv6.setText(c6);
            tv6.setEnabled(false);
        }

        else  if(c7.equals("")&&c8.equals("X")&&c9.equals("X")){
            c7="0";
            tv7.setText(c7);
            tv7.setEnabled(false);
        }


        else  if(c7.equals("X")&&c8.equals("")&&c9.equals("X")){
            c8="0";
            tv8.setText(c8);
            tv8.setEnabled(false);
        }


        else  if(c7.equals("X")&&c8.equals("X")&&c9.equals("")){
            c9="0";
            tv9.setText(c9);
            tv9.setEnabled(false);
        }



        else if(c1.equals("X")&&c2.equals("")&&c3.equals("")&&c4.equals("")&&c5.equals("")&&c6.equals("")&&c7.equals("")&&c8.equals("")&&c9.equals(""))
        {
            c5="0";
            tv5.setText(c5);
            tv5.setEnabled(false);
        }

        else if(c1.equals("")&&c2.equals("")&&c3.equals("X")&&c4.equals("")&&c5.equals("")&&c6.equals("")&&c7.equals("")&&c8.equals("")&&c9.equals(""))
        {
            c5="0";
            tv5.setText(c5);
            tv5.setEnabled(false);
        }


        else if(c1.equals("")&&c2.equals("")&&c3.equals("")&&c4.equals("")&&c5.equals("")&&c6.equals("")&&c7.equals("X")&&c8.equals("")&&c9.equals(""))
        {
            c5="0";
            tv5.setText(c5);
            tv5.setEnabled(false);
        }


        else if(c1.equals("")&&c2.equals("")&&c3.equals("")&&c4.equals("")&&c5.equals("")&&c6.equals("")&&c7.equals("")&&c8.equals("")&&c9.equals("X"))
        {
            c5="0";
            tv5.setText(c5);
            tv5.setEnabled(false);
        }

        else if(c1.equals("")&&c2.equals("")&&c3.equals("X")&&c4.equals("")&&c6.equals("")&&c7.equals("X")&&c8.equals("")&&c9.equals(""))
        {
            c2="0";
            tv2.setText(c2);
            tv2.setEnabled(false);
        }

        else if(c2.equals("")&&c3.equals("")&&c4.equals("")&&c5.equals("X")&&c6.equals("")&&c7.equals("")&&c8.equals("")&&c9.equals("X"))
        {
            c3="0";
            tv3.setText(c3);
            tv3.setEnabled(false);
        }

        else if(c2.equals("")&&c3.equals("")&&c4.equals("")&&c5.equals("X")&&c6.equals("")&&c7.equals("")&&c8.equals("")&&c9.equals("X"))
        {
            c3="0";
            tv3.setText(c3);
            tv3.setEnabled(false);
        }
    else if(c2.equals("")&&c3.equals("X")&&c4.equals("")&&c6.equals("")&&c7.equals("")&&c8.equals("X")&&c9.equals(""))
    {
        c6="0";
        tv6.setText(c6);
        tv6.setEnabled(false);
    }
    else if(c2.equals("")&&c3.equals("")&&c4.equals("")&&c6.equals("X")&&c7.equals("X")&&c8.equals("")&&c9.equals(""))
    {
        c8="0";
        tv8.setText(c8);
        tv8.setEnabled(false);
    }
























    else if(c5.equals("")){
            tv5.setEnabled(false);
            tv5.setText("0");
            c5="0";

        }

        else  if(c1.equals("")){
            tv1.setEnabled(false);
            tv1.setText("0");
            c1="0";

        }

        else if(c2.equals("")){
            tv2.setEnabled(false);
            tv2.setText("0");
            c2="0";

        }
        else if(c3.equals("")){
            tv3.setEnabled(false);
            tv3.setText("0");
            c3="0";

        }
        else if(c4.equals("")){
            tv4.setEnabled(false);
            tv4.setText("0");
            c4="0";

        }

        else if(c6.equals("")){
            tv6.setEnabled(false);
            tv6.setText("0");
            c6="0";

        }
        else if(c7.equals("")){
            tv7.setEnabled(false);
            tv7.setText("0");
            c7="0";

        }
        else if(c8.equals("")){
            tv8.setEnabled(false);
            tv8.setText("0");
            c8="0";

        }
        else if(c9.equals("")){
            tv9.setEnabled(false);
            tv9.setText("0");
            c9="0";

        }

        if(currentplayer.equals(firstp)){
            currentplayer=secondp;
        }
        else{
            currentplayer=firstp;
        }

        if(currentplayer.equals(firstp)){
            currentplayer=secondp;
        }
        else{
            currentplayer=firstp;
        }

        // getValue(c1,c2,c3,c4,c5,c6,c7,c8,c9,0);
        verify1();


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

