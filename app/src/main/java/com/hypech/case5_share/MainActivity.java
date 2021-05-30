package com.hypech.case5_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShare = findViewById(R.id.button_share);
        btnShare.setOnClickListener(new L_Click());
    }

    class L_Click implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            allShare();
        }
    }

    /**
     * Android Original Share
     * 3rd party share might be banned in Android 12.
     */
    public void allShare(){
        Intent share_intent = new Intent();         // get an intent
        share_intent.setAction(Intent.ACTION_SEND); // define action
        share_intent.setType("text/plain");         // define contents
        share_intent.putExtra(Intent.EXTRA_SUBJECT, "Enjoy Android Case");  // pass share subject
        share_intent.putExtra(Intent.EXTRA_TEXT, "Android Case Study"+"http://hypech.com");
        share_intent = Intent.createChooser(share_intent, "Share To Friends"); // title

        startActivity(share_intent);    // start sharing
    }
}