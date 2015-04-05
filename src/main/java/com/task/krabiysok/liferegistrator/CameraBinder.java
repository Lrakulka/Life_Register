package com.task.krabiysok.liferegistrator;

import android.os.Binder;
import android.util.Log;

/**
 * Created by KrabiySok on 4/4/2015.
 */
public class CameraBinder extends Binder {
    private static final String LOG_TAG = CameraBinder.class.getName();
    private final CameraService cameraService;

    CameraBinder(CameraService cameraService) {
        Log.d(LOG_TAG, "CameraBinder constructor");
        this.cameraService = cameraService;
    }

    CameraService getCameraService() {
        Log.d(LOG_TAG, "CameraBinder getCameraService");
        return cameraService;
    }
}
