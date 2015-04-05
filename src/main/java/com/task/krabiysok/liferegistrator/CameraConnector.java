package com.task.krabiysok.liferegistrator;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by KrabiySok on 4/4/2015.
 */
public class CameraConnector implements ServiceConnection {
    private static final String LOG_TAG = CameraConnector.class.getName();
    private boolean status;
    private CameraService cameraService;

    public void onServiceConnected(ComponentName name, IBinder binder) {
        Log.d(LOG_TAG, "CameraConnector onServiceConnected");
        cameraService = ((CameraBinder) binder).getCameraService();
        status = true;
    }

    public void onServiceDisconnected(ComponentName name) {
        Log.d(LOG_TAG, "CameraConnector onServiceDisconnected");
        cameraService = null;
        status = false;
    }

    public boolean isConnected() {
        Log.d(LOG_TAG, "CameraConnector isConnected");
        return status;
    }

    public CameraService getCameraService() {
        Log.d(LOG_TAG, "CameraConnector getCameraService");
        return cameraService;
    }
}
