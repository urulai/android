package io.github.urulai.fragmentexample;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.app.Fragment;
import android.app.FragmentManager;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements ListUpdater {

    private final String TAG = MainActivity.class.getSimpleName();
    private int orientation = Configuration.ORIENTATION_PORTRAIT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Check for current orientation.
        orientation = getResources().getConfiguration().orientation;

        String strOrientation = null;
        if (orientation == Configuration.ORIENTATION_PORTRAIT)
            strOrientation = "Portrait";
        else if (orientation == Configuration.ORIENTATION_LANDSCAPE)
            strOrientation = "Landscape";
        else if (orientation == Configuration.ORIENTATION_UNDEFINED)
            strOrientation = "Undefined";

        Log.d(TAG, "onCreate called, orientation : " + strOrientation);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListItemClicked(int idx) {
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Intent intent = new Intent(this, CuisineDescriptionActivity.class);
            intent.putExtra(Constants.INDEX_VAL, idx);

            Log.d(TAG, "Start new activity for portrait");
            startActivity(intent);
        } else {
            CuisineDescription cuisineDesc = null;
            FragmentManager fragManager = getFragmentManager();

            if (fragManager != null) {
                cuisineDesc = (CuisineDescription) fragManager.findFragmentById(R.id.fragCuisineDescription);

                if (cuisineDesc != null)
                    cuisineDesc.setIndex(idx);
            }
        }
    }

    public int getCurrentOrientation() {
        return orientation;
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy called");
    }
}
