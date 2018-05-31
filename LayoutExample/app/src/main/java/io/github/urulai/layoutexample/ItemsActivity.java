package io.github.urulai.layoutexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ItemsActivity extends AppCompatActivity {

    private final String TAG = ItemsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        ListView listview = findViewById(R.id.listThings);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.textelement_layout, R.id.listText, getResources().getStringArray(R.array.listItems));
        listview.setAdapter(arrayAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String arrayvalues[] = getResources().getStringArray(R.array.listItems);
                Log.d(TAG, "value at pos: " + arrayvalues[i]);

                Intent intent = new Intent(ItemsActivity.this, DescriptionActivity.class);

                intent.putExtra("position", (int) i);

                startActivity(intent);
            }
        };

        listview.setOnItemClickListener(itemClickListener);
    }


}
