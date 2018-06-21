package urulai.github.io.flashcard;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private GestureDetector mDetector;
    private static final String DEBUG_TAG = MainActivity.class.getSimpleName();

    private int counter = 0;

    private final float THRESHOLD_FLING = 200.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,
                new int[]{Color.parseColor("#3C3B3F"), Color.parseColor("#605C3C")});

        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout_background);
        layout.setBackgroundDrawable(drawable);
        mDetector = new GestureDetector(this, new MyGestureListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final String DEBUG_TAG = "Gestures";

        @Override
        public boolean onDown(MotionEvent event) {
//            Log.d(DEBUG_TAG,"onDown: " + event.toString());
            return true;
        }

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
//            Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString());


            float event1_x = event1.getX();
            float event2_x = event2.getX();

            Log.d(DEBUG_TAG, "Fling started from " + event1_x + " and ended at " + event2_x);

            ImageView drawableItem = (ImageView) findViewById(R.id.drawableItem);
            TextView textView = (TextView) findViewById(R.id.textData);

            if ((event1_x - event2_x) >= THRESHOLD_FLING) {
                Log.d(DEBUG_TAG, "Show next flash card");
                counter++;

                if (counter >= AppData.drawableIds.length) {
                    counter = AppData.drawableIds.length - 1;
                    return true;
                }
            } else if ((event2_x - event1_x) >= THRESHOLD_FLING) {
                Log.d(DEBUG_TAG, "Show prev flash card");
                counter--;

                if (counter < 0) {
                    counter = 0;
                    return true;
                }
            }

            drawableItem.setImageDrawable(getDrawable(AppData.drawableIds[counter]));
            drawableItem.setColorFilter(Color.argb(255, 255, 255, 255));
            textView.setText(AppData.drawableText[counter]);

            return true;
        }
    }
}
