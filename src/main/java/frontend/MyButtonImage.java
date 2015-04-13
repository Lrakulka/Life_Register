package frontend;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by KrabiySok on 4/12/2015.
 * ListView uses for creation imageButton
 */

public class MyButtonImage extends ListView {
    private final String LOG_TAG = MyButtonImage.class.getName();
    private int imageId = -1;
    private MyArrayAdapter myArrayAdapter;
    private OnClickListener onClickListener;

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

    public void setImage(int imageId, Activity context, int itemId, int itemImageId) {
        if (this.imageId != imageId) {
            this.imageId = imageId;
            if (myArrayAdapter == null) {
                Integer[] arrayImageId = new Integer[1];
                arrayImageId[0] = imageId;
                myArrayAdapter = new MyArrayAdapter(context, arrayImageId,
                        this, itemId, itemImageId);
                this.setAdapter(myArrayAdapter);
            } else {
                myArrayAdapter.clear();
                myArrayAdapter.add(imageId);
                myArrayAdapter.notifyDataSetChanged();
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
