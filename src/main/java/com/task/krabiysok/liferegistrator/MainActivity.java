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

import frontend.MyArrayAdapter;
import frontend.MyButtonImage;
import frontend.SimpleOrientationListener;

public class MainActivity extends Activity {
    private static final String LOG_TAG = MainActivity.class.getName();
    private MyArrayAdapter listMenuAdapter;
    private MyButtonImage cameraRotationButton;
    private MyButtonImage cameraSwithButton;
    private MyButtonImage startButton;
    private MyButtonImage openDataButton;
    int img;
    int deg = 90;
    SimpleOrientationListener mOrientationListener;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraRotationButton = (MyButtonImage) findViewById(R.id.button_camera_rotetion);
        cameraRotationButton.setImage(R.drawable.img_camera_rotate, this, R.layout.item, R.id.item_imag);
        cameraSwithButton = (MyButtonImage) findViewById(R.id.button_top);
        cameraSwithButton.setImage(R.drawable.img_photo_video, this, R.layout.navigation_button, R.id.button_imag);
        startButton = (MyButtonImage) findViewById(R.id.button_center);
        startButton.setImage(R.drawable.img_start_photo, this, R.layout.navigation_button, R.id.button_imag);
        openDataButton = (MyButtonImage) findViewById(R.id.button_bottom);
        openDataButton.setImage(R.drawable.img_data, this, R.layout.navigation_button, R.id.button_imag);
        img = R.drawable.img_balance;
        final Integer[] images = new Integer[27];
        for (int i = 0; i < 27; i++) {
            images[i] = img;
            img++;
        }

        final ListView listMenu = (ListView) findViewById(R.id.list_settings);

        ((ImageView) findViewById(R.id.imageShuttle)).
                startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shuttle_rotetion));

        listMenuAdapter = new MyArrayAdapter(this, images, listMenu, R.layout.item, R.id.item_imag);
        listMenu.setAdapter(listMenuAdapter);
        listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
                cameraSwithButton.changeButtonOrientation(orientation);
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
}

