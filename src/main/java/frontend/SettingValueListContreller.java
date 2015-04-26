package frontend;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.task.krabiysok.liferegistrator.R;

import ProgramSettings.Setting;

/**
 * Created by KrabiySok on 4/19/2015.
 */
public class SettingValueListContreller extends ListView {
    private static final String LOG_TAG = MyArrayAdapter.class.getName();
    private final Activity context;
    private Setting setting;
    private int rotation;
    private FrameLayout frameLayout;

    public SettingValueListContreller(final Activity context, Setting setting, FrameLayout frameLayout) {
        super(context);
        this.setting = setting;
        this.context = context;
        this.frameLayout = frameLayout;
        this.setAdapter(new SettingValueAdapter());
        this.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, "ItemSelected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void changeSettingValueListOrientation(int rotation) {
        if ((rotation == this.rotation) ||
                (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB)) {
            return; // setRotation API LEVEL 11
        }
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(0, 0);

        switch (rotation) {
            case (Surface.ROTATION_90) :
                this.rotation = 90;
//                params.height = 200;
//                params.width = linearLayout.getHeight();
//                params.addRule(RelativeLayout.RIGHT_OF, R.id.linearLayout);
//                params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                break;
            case (Surface.ROTATION_180) :
                this.rotation = 180;
//                params.width = 200;
//                params.height = linearLayout.getHeight();
//                params.addRule(RelativeLayout.RIGHT_OF, R.id.linearLayout);
//                params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                break;
            case (Surface.ROTATION_270) :
                this.rotation = 270;
//                params.height = 200;
//                params.width = linearLayout.getHeight();
//                params.addRule(RelativeLayout.RIGHT_OF, R.id.linearLayout);
//                params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                break;
            default:
                this.rotation = 0;
                params.width = 200;
                params.addRule(RelativeLayout.RIGHT_OF, R.id.linearLayout);
                params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                break;
        }
        params.width = 200;
        params.addRule(RelativeLayout.RIGHT_OF, R.id.linearLayout);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP, R.id.linearLayout);

        //this.setLayoutParams(params);
        frameLayout.setRotation(this.rotation);
        this.rotation = rotation;
    }

    private class SettingValueAdapter extends ArrayAdapter<String> {

        public SettingValueAdapter() {
            super(context, R.layout.setting_value_item,
                    (String[]) setting.getSettingValueList().
                            toArray(new String[setting.getSettingValueList().size()]));
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = context.getLayoutInflater();
                convertView = inflater.inflate(R.layout.setting_value_item, null, true);
                Log.d(LOG_TAG, "new list item");
            } else Log.d(LOG_TAG, "old list item");

            ((TextView) ((LinearLayout) convertView).
                    findViewById(R.id.textView_settingValue)).
                    setText((String) setting.getSettingValueList().get(position));
            if (setting.getCurrSettingValueId() == position) {
                ((CheckBox) ((LinearLayout) convertView).
                        findViewById(R.id.checkBox_settingValue_status)).
                        setChecked(true);
            } else {
                ((CheckBox) ((LinearLayout) convertView).
                        findViewById(R.id.checkBox_settingValue_status)).
                        setChecked(false);
            }
            return convertView;
        }
    }
}
