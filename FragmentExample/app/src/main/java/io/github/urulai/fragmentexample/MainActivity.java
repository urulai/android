package io.github.urulai.fragmentexample;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;


public class MainActivity extends AppCompatActivity implements ListUpdater {

    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListItemClicked(int idx) {
        CuisineDescription cuisineDesc = (CuisineDescription) getSupportFragmentManager().findFragmentById(R.id.fragCuisineDescription);
        if(cuisineDesc != null)
            cuisineDesc.setIndex(idx);
    }
}
