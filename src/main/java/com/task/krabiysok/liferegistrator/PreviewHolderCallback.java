package com.task.krabiysok.liferegistrator;

import android.hardware.Camera;
import android.view.SurfaceHolder;

import java.io.IOException;

/**
 * Created by KrabiySok on 4/4/2015.
 */
public class PreviewHolderCallback implements SurfaceHolder.Callback {
    private static final int CAMERA_ID = 0;
    private static  boolean FULL_SCREEN = true;
    private Camera camera;

    PreviewHolderCallback(Camera camera) {
      this.camera = camera;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            camera.setPreviewDisplay(holder);
            camera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        camera.stopPreview();
        try {
            camera.setPreviewDisplay(holder);
            camera.startPreview();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        camera = null;
    }
}
