package frontend;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.Surface;

public abstract class SimpleOrientationListener extends OrientationEventListener {
        public int prevOrientation = OrientationEventListener.ORIENTATION_UNKNOWN;
        private boolean screenOrientationPortain;

        public SimpleOrientationListener(Context context, boolean screenOrientationPortain) {
            super(context);
            this.screenOrientationPortain = screenOrientationPortain;
        }

        @Override
        public void onOrientationChanged(final int orientation) {
            int currentOrientation = OrientationEventListener.ORIENTATION_UNKNOWN;
            if (screenOrientationPortain) {
                if (orientation >= 330 || orientation < 30) {
                    currentOrientation = Surface.ROTATION_0;
                } else if (orientation >= 60 && orientation < 120) {
                    currentOrientation = Surface.ROTATION_90;
                } else if (orientation >= 150 && orientation < 210) {
                    currentOrientation = Surface.ROTATION_180;
                } else if (orientation >= 240 && orientation < 300) {
                    currentOrientation = Surface.ROTATION_270;
                }
            } else {
                if (orientation >= 330 || orientation < 30) {
                    currentOrientation = Surface.ROTATION_270;
                } else if (orientation >= 60 && orientation < 120) {
                    currentOrientation = Surface.ROTATION_180;
                } else if (orientation >= 150 && orientation < 210) {
                    currentOrientation = Surface.ROTATION_90;
                } else if (orientation >= 240 && orientation < 300) {
                    currentOrientation = Surface.ROTATION_0;
                }
            }
            if (prevOrientation != currentOrientation && currentOrientation != OrientationEventListener.ORIENTATION_UNKNOWN) {
                prevOrientation = currentOrientation;
                onSimpleOrientationChanged(currentOrientation);
            }

        }

        /**
         * Fires when orientation changes.
         *
         * @param orientation value of {@link Surface#ROTATION_0}, {@link Surface#ROTATION_90},
         *                    {@link Surface#ROTATION_180} or {@link Surface#ROTATION_270}
         */
        public abstract void onSimpleOrientationChanged(int orientation);

    }