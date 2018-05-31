package io.github.urulai.layoutexample;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Subramanian.N on 5/30/2018.
 */

public class DescriptionActivity extends AppCompatActivity {

    private final String TAG = DescriptionActivity.class.getSimpleName();
    private final int DEFAULT_POS = 0;
    private int images[] = {
            R.drawable.donut,
            R.drawable.eclairs,
            R.drawable.pumpkin_pie,
            R.drawable.mars,
            R.drawable.snickers,
            R.drawable.marshmallows,
            R.drawable.nougat,
            R.drawable.oreo,
            R.drawable.jellybean,
            R.drawable.kitkat,
            R.drawable.lollipops
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", DEFAULT_POS);

        ImageView imgView = (ImageView) findViewById(R.id.image_dessert);
        imgView.setImageResource(images[position]);

        String descriptionValues[] = getResources().getStringArray(R.array.listItemsDescription);
        TextView textview = (TextView) findViewById(R.id.item_description);
        textview.setText(descriptionValues[position]);
    }
}