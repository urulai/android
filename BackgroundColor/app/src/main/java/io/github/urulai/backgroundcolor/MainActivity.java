package io.github.urulai.backgroundcolor;

import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;

import android.graphics.Color;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    private int color_R = 0, color_G = 0, color_B = 0;
    private char chooseColorComponent = 'R'; // by default start with Red.
    private final int ALPHA = 255;

    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (ConstraintLayout) findViewById(R.id.mainWindow);
        if (layout != null) {
            runBackgroundColorChanger();
        }
    }

    private void runBackgroundColorChanger() {
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override

            public void run() {
                if(color_R >= 255)
                    chooseColorComponent = 'G';

                if(color_G >= 255)
                    chooseColorComponent = 'B';

                if(color_B >= 255) {
                    Log.d(TAG, "Stop changing colors");
                    return;
                }

                if(chooseColorComponent == 'R')
                    color_R++;
                else if(chooseColorComponent == 'G')
                    color_G++;
                else if(chooseColorComponent == 'B')
                    color_B++;

                layout.setBackgroundColor(Color.argb(ALPHA, color_R, color_G, color_B));

                handler.postDelayed(this, 50);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
