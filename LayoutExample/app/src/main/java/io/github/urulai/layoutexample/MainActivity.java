package io.github.urulai.layoutexample;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.content.Context;

import java.util.BitSet;

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

            final int BITSET_SIZE = 3;
            BitSet bitsetVal = new BitSet(BITSET_SIZE);
            bitsetVal.set(0, BITSET_SIZE, true);

            Log.d(TAG, bitsetVal.toString());

            EditText textBoxValue = (EditText) findViewById(R.id.editTextFirstName);
            String firstName = null, lastName = null, phone = null;
            if (textBoxValue != null) {
                firstName = textBoxValue.getText().toString();

                Log.d(TAG, "firstname value: " + firstName);

                if (firstName != null && !firstName.isEmpty()) {
                    bitsetVal.clear(0);
                    textBoxValue.setBackgroundResource(R.drawable.editfield_noerror);
                } else
                    textBoxValue.setBackgroundResource(R.drawable.editfield_error);
            }

            textBoxValue = (EditText) findViewById(R.id.editTextLastName);
            if (textBoxValue != null) {
                lastName = textBoxValue.getText().toString();

                Log.d(TAG, "lastname value: " + lastName);

                if (lastName != null && !lastName.isEmpty()) {
                    bitsetVal.clear(1);
                    textBoxValue.setBackgroundResource(R.drawable.editfield_noerror);
                } else
                    textBoxValue.setBackgroundResource(R.drawable.editfield_error);
            }

            textBoxValue = (EditText) findViewById(R.id.editTextPhone);
            if (textBoxValue != null) {
                phone = textBoxValue.getText().toString();

                Log.d(TAG, "phone value: " + phone);
                if (phone != null && !phone.isEmpty()) {
                    bitsetVal.clear(2);
                    textBoxValue.setBackgroundResource(R.drawable.editfield_noerror);
                } else
                    textBoxValue.setBackgroundResource(R.drawable.editfield_error);
            }

            Log.d(TAG, bitsetVal.toString());

            if (!bitsetVal.isEmpty()) {
                Toast.makeText(_context, getResources().getString(R.string.fields_empty_err_msg), Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(_context, getResources().getString(R.string.thank_you_note), Toast.LENGTH_SHORT).show();

            ProgressIndicator prog = new ProgressIndicator();
            prog.execute();
        }
    }

    private class ProgressIndicator extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            ProgressBar prog = findViewById(R.id.indeterminate);
            prog.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... args) {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Log.d(TAG, "Exception: " + ex.getMessage());
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            ProgressBar prog = findViewById(R.id.indeterminate);
            prog.setVisibility(View.GONE);

            Intent intent = new Intent(MainActivity.this, ItemsActivity.class);
            startActivity(intent);
        }
    }
}
