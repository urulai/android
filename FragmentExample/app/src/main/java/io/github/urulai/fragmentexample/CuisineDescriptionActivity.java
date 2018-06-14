package io.github.urulai.fragmentexample;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;

public class CuisineDescriptionActivity extends AppCompatActivity {

    private final String TAG = CuisineDescriptionActivity.class.getSimpleName();

    private boolean isRunning = false;

    private int idx = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, "Oncreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine_description);

        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE)
            finish();

        Intent intent = getIntent();
        idx = intent.getIntExtra(Constants.INDEX_VAL, 0);

        Log.d(TAG, "index recvd: " + idx);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "resume");
        isRunning = true;
        CuisineDescription cuisineDesc = (CuisineDescription) getFragmentManager().findFragmentById(R.id.fragCuisineDescription);
        if (cuisineDesc != null)
            cuisineDesc.setIndex(idx);
//        CuisineDescription cuisineDesc = (CuisineDescription) getSupportFragmentManager().findFragmentById(R.id.fragCuisineDescription);

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "pause");
        isRunning = false;
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "Destroyed");
    }


}
