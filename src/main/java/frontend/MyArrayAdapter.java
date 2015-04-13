package frontend;

/**
 * Created by KrabiySok on 4/11/2015.
 */

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MyArrayAdapter extends ArrayAdapter<Integer> {
    private static final String LOG_TAG = MyArrayAdapter.class.getName();
    private static final int ROTATION_TIME_90 = 300;
    private static final int ROTATION_TIME_180 = ROTATION_TIME_90 * 2;

    private final Activity context;
    private final Integer[] imagesId;
    private ListView listView;
    private int degree = 0;
    private int itemId;
    private int imegId;

    public MyArrayAdapter(Activity context, Integer[] images, ListView listView,
                          int itemId, int imegId) {
        super(context, itemId, images);
        this.itemId = itemId;
        this.context = context;
        this.imagesId = images.clone();
        this.listView = listView;
        this.imegId = imegId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(itemId, null, true);
            Log.d(LOG_TAG, "new list item");
        } else Log.d(LOG_TAG, "old list item");

        ((ImageView) ((LinearLayout) convertView).
                findViewById(imegId)).setImageResource(imagesId[position]);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            ((ImageView) ((LinearLayout) convertView).
                    findViewById(imegId)).setRotation(degree);
        }
        return convertView;
    }

    /**
     * Rotate all items in ListView with animation if it possible.
     * @param currOrientation rotation degree.
     */
    public void changeItemsOrientation(final int currOrientation) {
        int currentDegree;
        ImageView imageView;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return; // setRotation API LEVEL 11
        }
        currentDegree = toDegree(currOrientation);
        if (currentDegree == degree) {
            return;
        }
        imageView = ((ImageView) ((LinearLayout) listView.getChildAt(0)).
                findViewById(imegId));
        Animation anim = getAnim(degree, currentDegree, imageView.getPivotX(),
                imageView.getPivotY());

        for(int j = 0; j < listView.getChildCount(); j++) {
            imageView =  ((ImageView) ((LinearLayout) listView.getChildAt(j)).
                    findViewById(imegId));
            imageView.setRotation(currentDegree);
            imageView.startAnimation(anim);
        }
        degree = currentDegree;
    }

    private Animation getAnim(int degree, int currDegree, float pivotX, float pivotY) {
        int dif = currDegree -  degree;
        Animation anim;
        Log.d(LOG_TAG, "X=" + String.valueOf(pivotX) + "  Y=" + String.valueOf(pivotY));
        if (Math.abs(dif) == 180) {
            if (dif < 0) {
                anim = new RotateAnimation(180, 0, pivotX, pivotY);
            } else {
                anim = new RotateAnimation(-180, 0, pivotX, pivotY);
            }
            anim.setDuration(ROTATION_TIME_180);
        } else {
            if ((dif != -270) && (dif < 0 || (currDegree == 270 && degree == 0))) {
                anim = new RotateAnimation(90, 0, pivotX, pivotY);
            } else {
                anim = new RotateAnimation(-90, 0, pivotX, pivotY);
            }
            anim.setDuration(ROTATION_TIME_90);
        }
        return anim;
    }

    private int toDegree(final int orientation) {
        switch (orientation) {
            case (Surface.ROTATION_0) : return 0;
            case (Surface.ROTATION_90) : return 90;
            case (Surface.ROTATION_180) : return 180;
            case (Surface.ROTATION_270) : return 270;
            default: return 0;
        }
    }
}