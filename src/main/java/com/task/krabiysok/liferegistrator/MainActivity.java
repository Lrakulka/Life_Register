package com.task.krabiysok.liferegistrator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import camera_settings.CameraSettings;
import frontend.MyArrayAdapter;
import frontend.MyButtonImage;
import frontend.SimpleOrientationListener;

public class MainActivity extends Activity {
    private static final String LOG_TAG = MainActivity.class.getName();
    private MyArrayAdapter listMenuAdapter;
    private MyButtonImage cameraRotationButton;
    private MyButtonImage swithCameraMod;
    private MyButtonImage startButton;
    private MyButtonImage openDataButton;
    private ListView listSettings;
    private boolean isVideo;
    int img;
    int deg = 90;
    SimpleOrientationListener mOrientationListener;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraRotationButton = (MyButtonImage) findViewById(R.id.button_camera_rotetion);
        cameraRotationButton.setImage(R.drawable.img_camera_rotate, this,
                R.layout.item, R.id.item_imag);
        cameraRotationButton.setOnClick(new SwitchCamera());
        swithCameraMod = (MyButtonImage) findViewById(R.id.button_top);
        swithCameraMod.setImage(R.drawable.img_photo_video, this,
                R.layout.navigation_button, R.id.button_imag);
        swithCameraMod.setOnClick(new ChangeCameraMod());
        startButton = (MyButtonImage) findViewById(R.id.button_center);
        startButton.setImage(R.drawable.img_start_photo, this,
                R.layout.navigation_button, R.id.button_imag);
        startButton.setOnClick(new Action());
        openDataButton = (MyButtonImage) findViewById(R.id.button_bottom);
        openDataButton.setImage(R.drawable.img_data, this,
                R.layout.navigation_button, R.id.button_imag);
        openDataButton.setOnClick(new OpenData());



        img = R.drawable.img_balance;
        final Integer[] images = new Integer[27];
        for (int i = 0; i < 27; i++) {
            images[i] = img;
            img++;
        }

        listSettings = (ListView) findViewById(R.id.list_settings);

        ((ImageView) findViewById(R.id.imageShuttle)).
                startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shuttle_rotetion));

        listMenuAdapter = new MyArrayAdapter(this, images, listSettings, R.layout.item, R.id.item_imag);
        listSettings.setAdapter(listMenuAdapter);
        listSettings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((ImageView) ((LinearLayout) view).findViewById(R.id.item_imag)).
                        startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myrotate));

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mOrientationListener = new SimpleOrientationListener(this, false) {

            @Override
            public void onSimpleOrientationChanged(int orientation) {
                Log.d(LOG_TAG, "onSimpleOrientationChanged " + String.valueOf(orientation));
                listMenuAdapter.changeItemsOrientation(orientation);
                cameraRotationButton.changeButtonOrientation(orientation);
                openDataButton.changeButtonOrientation(orientation);
                swithCameraMod.changeButtonOrientation(orientation);
                startButton.changeButtonOrientation(orientation);
            }
        };
        mOrientationListener.enable();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mOrientationListener.disable();
    }

    private void setButtonsEnebled(boolean status) {
        swithCameraMod.setEnabled(status);
        cameraRotationButton.setEnabled(status);
        if (!status) {
            cameraRotationButton.setAlpha(0);
            swithCameraMod.setAlpha(0);
        } else {
            cameraRotationButton.setAlpha(255);
            swithCameraMod.setAlpha(255);
        }
    }

    class Action implements MyButtonImage.OnClickListener {
        private boolean isWriteVideo;

        @Override
        public void onClick() {
            if (isVideo) {
                if (isWriteVideo) {

                    startButton.setImage(R.drawable.img_start_video);
                    isWriteVideo = false;
                    setButtonsEnebled(true);
                } else {

                    startButton.setImage(R.drawable.img_stop_video);
                    isWriteVideo = true;
                    setButtonsEnebled(false);
                }
            } else {
                setButtonsEnebled(false);
                listSettings.setEnabled(false);

                listSettings.setEnabled(true);
                setButtonsEnebled(true);
            }
        }
    }

    class ChangeCameraMod implements MyButtonImage.OnClickListener {

        @Override
        public void onClick() {
                if (isVideo) {
                    setButtonsEnebled(false);
                    startButton.setEnabled(false);
                    listSettings.setEnabled(false);

                    swithCameraMod.setImage(R.drawable.img_photo_video);
                    startButton.setImage(R.drawable.img_start_photo);
                    isVideo = false;
                    listSettings.setEnabled(true);
                    startButton.setEnabled(true);
                    setButtonsEnebled(true);
                } else {
                    setButtonsEnebled(false);
                    startButton.setEnabled(false);
                    listSettings.setEnabled(false);

                    swithCameraMod.setImage(R.drawable.img_video_photo);
                    startButton.setImage(R.drawable.img_start_video);
                    isVideo = true;
                    listSettings.setEnabled(true);
                    startButton.setEnabled(true);
                    setButtonsEnebled(true);
                }
        }
    }

    class SwitchCamera implements MyButtonImage.OnClickListener {
        private int cameraId = 0;

        @Override
        public void onClick() {
            setButtonsEnebled(false);
            listSettings.setEnabled(false);
            startButton.setEnabled(false);
            cameraId++;
            if (cameraId == CameraSettings.getCameraCount()) {
                cameraId = 0;
            }
            CameraSettings.setCurrentCamera(cameraId);


            setButtonsEnebled(true);
            listSettings.setEnabled(true);
            startButton.setEnabled(true);
        }
    }

    class OpenData implements MyButtonImage.OnClickListener {

        @Override
        public void onClick() {

        }
    }
}

