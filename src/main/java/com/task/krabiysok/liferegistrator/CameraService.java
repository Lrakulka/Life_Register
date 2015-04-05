package com.task.krabiysok.liferegistrator;

import android.app.Service;
import android.content.Intent;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

import java.io.File;

public class CameraService extends Service {
    private static final String LOG_TAG = CameraService.class.getName();
    private CameraBinder cameraBinder;
    private Camera mCamera;
    private MediaRecorder mediaRecorder;
    private File videoFile;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "CameraService onCreate");
        cameraBinder = new CameraBinder(this);
        mediaRecorder = new MediaRecorder();
        videoFile = new File(Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "myvideo4.3gp");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(LOG_TAG, "CameraService onBind");
        mCamera = Camera.open();
        mCamera.setDisplayOrientation(90);

        //MainActivity.surfaceViewPreview.getHolder().addCallback(new PreviewHolderCallback(mCamera));

        return cameraBinder;
    }

    public void start() {
        if (prepareVideoRecorder()) {
            mediaRecorder.start();
        }
    }

    public void stop() {
        releaseMediaRecorder();
        if (mCamera != null)
            mCamera.release();
        mCamera = null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(LOG_TAG, "CameraService onUnbind");
        releaseMediaRecorder();
        if (mCamera != null)
            mCamera.release();
        mCamera = null;
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "CameraService onDestroy");
    }

    private boolean prepareVideoRecorder() {

        mCamera.unlock();

        mediaRecorder = new MediaRecorder();

        mediaRecorder.setCamera(mCamera);
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
        mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
        mediaRecorder.setProfile(CamcorderProfile
                .get(CamcorderProfile.QUALITY_HIGH));
        mediaRecorder.setOutputFile(videoFile.getAbsolutePath());

        try {
            mediaRecorder.prepare();
        } catch (Exception e) {
            e.printStackTrace();
            releaseMediaRecorder();
            return false;
        }
        return true;
    }

    private void releaseMediaRecorder() {
        if (mediaRecorder != null) {
            mediaRecorder.stop(); ///d
            mediaRecorder.reset();
            mediaRecorder.release();
            mediaRecorder = null;
            mCamera.lock();
        }
    }

    public Camera getCamera() {
        return mCamera;
    }
}
