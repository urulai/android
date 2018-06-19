package urulai.github.io.flashcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onEnglishClick(View v) {
        TextView txt = (TextView) findViewById(R.id.textData);

        txt.setText(R.string.train);

    }

    public void onTamilClick(View v) {
        TextView txt = (TextView) findViewById(R.id.textData);

        txt.setText(R.string.train_tamil);

    }

}
