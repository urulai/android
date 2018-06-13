package io.github.urulai.fragmentexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class CuisineDescription extends Fragment {

    private int index = 0;

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

        if(id >= FragmentData.items.length)
            return;

        index = id;

        View view = getView();

        if(view != null) {
            FragmentData item = FragmentData.items[(int) index];

            if(item != null) {
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
}
