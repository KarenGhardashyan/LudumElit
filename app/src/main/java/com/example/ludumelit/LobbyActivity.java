package com.example.ludumelit;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class LobbyActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;

    static int delay = 5000;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        viewFlipper = findViewById(R.id.viewFlipper);
        handler = new Handler();

        startImageSlideshow();
    }

    private void startImageSlideshow() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                viewFlipper.showNext();
                handler.postDelayed(this, delay);
            }
        };

        handler.postDelayed(runnable, delay);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
