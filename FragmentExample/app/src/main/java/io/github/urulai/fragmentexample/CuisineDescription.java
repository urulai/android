package io.github.urulai.fragmentexample;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.content.Context;
import android.util.Log;

/**
 * A simple {@link Fragment} subclass.
 */
public class CuisineDescription extends Fragment {

    private int index = 0;

    private final String TAG = "CuisineDescriptionFragment";

    public CuisineDescription() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cuisine_description, container, false);
    }

    public void setIndex(int id) {

        if (id >= FragmentData.items.length)
            return;

        index = id;

        View view = getView();

        if (view != null) {
            FragmentData item = FragmentData.items[(int) index];

            if (item != null) {
                TextView title = (TextView) view.findViewById(R.id.title);
                title.setText(item.getName());

                TextView description = (TextView) view.findViewById(R.id.description);
                description.setText(item.getDescription());
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.d(TAG, "Attached");

        View view = getView();
        if (view != null) {
            Log.d(TAG, "View is available");
        }
    }
}
