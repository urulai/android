package io.github.urulai.fragmentexample;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.util.Log;
import android.content.res.Configuration;


/**
 * A simple {@link Fragment} subclass.
 */
public class CuisineSelector extends ListFragment {

    private final String TAG = CuisineSelector.class.getSimpleName();

    private MainActivity parentActivity = null;

    private View prevSelectedItem = null;

    public CuisineSelector() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "On Create view called");
        String[] names = new String[FragmentData.items.length];

        for (int idx = 0; idx < names.length; idx++) {
            names[idx] = FragmentData.items[idx].getName();
        }

        ArrayAdapter<String> listFragmentAdapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.fragment_selector,
                R.id.cuisine_selector, names);
        setListAdapter(listFragmentAdapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.d(TAG, "onDestroyView is called");
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.d(TAG, "onStart called");

        View view = getView();
        if (view != null)
            view.setBackgroundResource(R.drawable.border);
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);

        parentActivity = (MainActivity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (parentActivity != null) {

            int orientation = parentActivity.getCurrentOrientation();

            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                Log.d(TAG, "we would worry about this later");
            } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                if (v != null) {
                    if (prevSelectedItem != null)
                        prevSelectedItem.setBackgroundColor(Color.parseColor("#FFFFFF"));

                    v.setBackgroundColor(Color.parseColor("#999999"));
                    prevSelectedItem = v;
                }
            } else {
                Log.d(TAG, "Error in orientation");
            }

            parentActivity.onListItemClicked((int) id);
        }

    }
}
