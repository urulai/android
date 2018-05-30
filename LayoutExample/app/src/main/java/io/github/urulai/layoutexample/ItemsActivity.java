package io.github.urulai.layoutexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        ListView listview = findViewById(R.id.listThings);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.textelement_layout, R.id.listText, getResources().getStringArray(R.array.listItems));
        listview.setAdapter(arrayAdapter);
    }
}
