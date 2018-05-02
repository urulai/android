package io.github.urulai.mediaplayerapp;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends Activity implements SurfaceHolder.Callback {

    private SurfaceView mSurfaceView;
    private SurfaceHolder mSurfaceHolder;
    private MediaPlayer mMediaPlayer;
    private Resources mResources;
    private final int ASSET_ID = R.raw.sample;
    private final String TAG = MainActivity.class.getSimpleName();
    private boolean isStopped = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSurfaceView = (SurfaceView) findViewById(R.id.surfaceview);
        mSurfaceHolder = mSurfaceView.getHolder();

        mSurfaceHolder.addCallback(this);

        final Button btnPlay = (Button) findViewById(R.id.play);
        final Button btnStop = (Button) findViewById(R.id.stop);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "Play the video");

                if (isStopped) {
                    try {
                        setResource();
                        mMediaPlayer.prepare();
                        isStopped = false;
                    } catch (IOException ex) {
                        Log.d(TAG, "Exception occurred while trying Mediaplayer prepare " + ex.getMessage());
                    }
                }

                if (!mMediaPlayer.isPlaying()) {
                    btnPlay.setText("Pause");
                    mMediaPlayer.start();
                } else if (mMediaPlayer.isPlaying()) {
                    btnPlay.setText("Play");
                    mMediaPlayer.pause();
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "Stop the video");
                mMediaPlayer.stop();
                isStopped = true;
                btnPlay.setText("Play");

                mMediaPlayer.reset();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mMediaPlayer != null)
            mMediaPlayer.release();

        mMediaPlayer = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d(TAG, "Surface changed");
    }

    private void setResource() {
        try {
            AssetFileDescriptor afd = mResources.openRawResourceFd(ASSET_ID);
            mMediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
        } catch (IOException ex) {
            Log.d(TAG, "Exception: " + ex.getMessage());
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        mResources = getResources();
        mMediaPlayer = new MediaPlayer();

        setResource();
        mMediaPlayer.setDisplay(mSurfaceHolder);

        try {
            mMediaPlayer.prepare();
        } catch (IOException t) {
            Log.e(TAG, "media player prepare failed");
        }

        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d(TAG, "playback completed, kill application");
                finish();
            }
        });
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d(TAG, "Surface destroyed");
    }

}
