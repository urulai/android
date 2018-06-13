package io.github.urulai.fragmentexample;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CuisineSelector extends ListFragment {

    private MainActivity parentActivity = null;

    public CuisineSelector() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        String[] names = new String[FragmentData.items.length];

        for (int idx = 0; idx < names.length; idx++) {
            names[idx] = FragmentData.items[idx].getName();
        }

//        ArrayAdapter<String> listFragmentAdapter = new ArrayAdapter<String>(
//                inflater.getContext(), android.R.layout.simple_list_item_1, names);


        ArrayAdapter<String> listFragmentAdapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.fragment_selector,
                R.id.cuisine_selector, names);
        setListAdapter(listFragmentAdapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        View view = getView();
        if(view != null)
            view.setBackgroundResource(R.drawable.border);
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);

        parentActivity = (MainActivity) context;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if(parentActivity != null)
            parentActivity.onListItemClicked((int) id);
    }
}
