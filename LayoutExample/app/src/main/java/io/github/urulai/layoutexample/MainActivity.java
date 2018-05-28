package io.github.urulai.layoutexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    private Context _context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _context = this;
    }

    public void onRegisterClicked(View view) {
        Log.d(TAG, "Id: " + view.getId());

        int id = view.getId();

        if (id == R.id.register) {
            Toast.makeText(_context, "Thanks for registering", Toast.LENGTH_LONG).show();
        }
    }
}
