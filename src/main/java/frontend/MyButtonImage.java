package frontend;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * Created by KrabiySok on 4/12/2015.
 * ListView uses for creation imageButton
 */

public class MyButtonImage extends ListView {
    private final String LOG_TAG = MyButtonImage.class.getName();
    private int imageId = -1;
    private int itemImageId;
    private MyArrayAdapter myArrayAdapter;
    private OnClickListener onClickListener;

    Activity context;

    public MyButtonImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (onClickListener != null) {
                    onClickListener.onClick();
                }
            }
        });
    }

    public void setImage(int imageId) {
        if (myArrayAdapter != null) {
            this.imageId = imageId;
            myArrayAdapter.changeImages(imageId);
            ((ImageView) ((LinearLayout) this.getChildAt(0)).
                    findViewById(itemImageId)).setImageResource(imageId);
        }
    }

    public void setImage(int imageId, Activity context, int itemId, int itemImageId) {
        if (this.imageId != imageId) {
            this.context = context;

            this.itemImageId = itemImageId;
            this.imageId = imageId;
            if (myArrayAdapter == null) {
                Integer[] arrayImageId = new Integer[1];
                arrayImageId[0] = imageId;
                myArrayAdapter = new MyArrayAdapter(context, arrayImageId,
                        this, itemId, itemImageId);
                this.setAdapter(myArrayAdapter);
            }
        }
    }

    public void changeButtonOrientation(final int currOrientation) {
        myArrayAdapter.changeItemsOrientation(currOrientation);
    }

    public void setOnClick(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        public void onClick();
    }
}
