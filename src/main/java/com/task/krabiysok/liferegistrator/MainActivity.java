package com.task.krabiysok.liferegistrator;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements SurfaceHolder.Callback {
    private static final String TAG = "Recorder";
    public static SurfaceView mSurfaceView;
    public static SurfaceHolder mSurfaceHolder;
    public static Camera mCamera ;
    public static boolean mPreviewRunning;
    Intent intent;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSurfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        mSurfaceHolder = mSurfaceView.getHolder();
        mSurfaceHolder.addCallback(this);
        mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        intent = new Intent(this, RecorderServiceL.class);
        Button btnStart = (Button) findViewById(R.id.btnStartRecord);
//        btnStart.setOnClickListener(new View.OnClickListener()
//        {
//            public void onClick(View v)
//            {
//                //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startService(intent);
//                //finish();
//            }
//        });
//
//        Button btnStop = (Button) findViewById(R.id.btnStopRecord);
//        btnStop.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                stopService(intent);
//            }
//        });
    }

    public void onClickStartRecord(View v) {
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startService(new Intent(this, BackgroundVideoRecorder.class));
    }

    public void onClickStopRecord(View v) {
        stopService(new Intent(this, BackgroundVideoRecorder.class));
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub

    }
}