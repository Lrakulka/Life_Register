package ProgramSettings;

import android.hardware.Camera;

import com.task.krabiysok.liferegistrator.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by KrabiySok on 4/14/2015.
 */
public class CameraSettings {
    static Camera.Parameters cameraParameters;

    public static ArrayList<String> getCameraSettings(HashMap<String, ArrayList<String>> settings,
                                                      Camera.Parameters mCameraParameters) {
        cameraParameters = mCameraParameters;
        ArrayList<String> cameraSettingsKeys = new ArrayList<>();
        //-----------
        cameraParameters = null;;
        return cameraSettingsKeys;
    }

    static class ColorEffects extends Setting<String> {
        ColorEffects(ArrayList<String> settingValueList) {
            super(settingValueList, R.drawable.img_color_effects, "ColorEffects");
        }

        public static ColorEffects getColorEffects() {
            if (cameraParameters == null) {
                return null;
            }
            List<String> list = cameraParameters.getSupportedColorEffects();
            if (list == null || list.isEmpty()) {
                return null;
            }
            return (new ColorEffects(new ArrayList<>(list)));
        }

        @Override
        public void setSetting(Camera.Parameters parameters) {
            parameters.setColorEffect(getCurrSettingValue());
        }
    }

    static class Antibanding extends Setting<String> {
        Antibanding(ArrayList<String> settingValueList) {
            super(settingValueList, R.drawable.abc_list_focused_holo, "Antibanding");
        }

        public static Antibanding getAntibanding() {
            if (cameraParameters == null) {
                return null;
            }
            List<String> list = cameraParameters.getSupportedAntibanding();
            if (list == null || list.isEmpty()) {
                return null;
            }
            return (new Antibanding(new ArrayList<>(list)));
        }

        @Override
        public void setSetting(Camera.Parameters parameters) {
            parameters.setAntibanding(getCurrSettingValue());
        }
    }

    static class FlashModes extends Setting<String> {
        FlashModes(ArrayList<String> settingValueList) {
            super(settingValueList, R.drawable.img_light_on, "FlashModes");
        }

        public static FlashModes getFlashModes() {
            if (cameraParameters == null) {
                return null;
            }
            List<String> list = cameraParameters.getSupportedFlashModes();
            if (list == null || list.isEmpty()) {
                return null;
            }
            return (new FlashModes(new ArrayList<>(list)));
        }

        @Override
          public void setSetting(Camera.Parameters parameters) {
            parameters.setFlashMode(getCurrSettingValue());
        }
    }

    static class FocusModes extends Setting<String> {
        FocusModes(ArrayList<String> settingValueList) {
            super(settingValueList, R.drawable.abc_list_focused_holo, "FocusModes");
        }

        public static FocusModes getFocusModes() {
            if (cameraParameters == null) {
                return null;
            }
            List<String> list = cameraParameters.getSupportedFocusModes();
            if (list == null || list.isEmpty()) {
                return null;
            }
            return (new FocusModes(new ArrayList<>(list)));
        }

        @Override
        public void setSetting(Camera.Parameters parameters) {
            parameters.setFlashMode(getCurrSettingValue());
        }
    }

    static class SceneModes extends Setting<String> {
        SceneModes(ArrayList<String> settingValueList) {
            super(settingValueList, R.drawable.abc_list_focused_holo, "SceneModes");
        }

        public static SceneModes getSceneModes() {
            if (cameraParameters == null) {
                return null;
            }
            List<String> list = cameraParameters.getSupportedSceneModes();
            if (list == null || list.isEmpty()) {
                return null;
            }
            return (new SceneModes(new ArrayList<>(list)));
        }

        @Override
        public void setSetting(Camera.Parameters parameters) {
            parameters.setSceneMode(getCurrSettingValue());
        }
    }

    static class WhiteBalance extends Setting<String> {
        WhiteBalance(ArrayList<String> settingValueList) {
            super(settingValueList, R.drawable.img_balance, "WhiteBalance");
        }

        public static WhiteBalance getWhiteBalance() {
            if (cameraParameters == null) {
                return null;
            }
            List<String> list = cameraParameters.getSupportedWhiteBalance();
            if (list == null || list.isEmpty()) {
                return null;
            }
            return (new WhiteBalance(new ArrayList<>(list)));
        }

        @Override
        public void setSetting(Camera.Parameters parameters) {
            parameters.setWhiteBalance(getCurrSettingValue());
        }
    }

    static class JpegThumbnailSizes extends Setting<Camera.Size> {
        JpegThumbnailSizes(ArrayList<Camera.Size> settingValueList) {
            super(settingValueList, R.drawable.img_resolution, "JpegThumbnailSizes");
        }

        public static JpegThumbnailSizes getJpegThumbnailSizes() {
            if (cameraParameters == null) {
                return null;
            }
            List<Camera.Size> list = cameraParameters.getSupportedJpegThumbnailSizes();
            if (list == null || list.isEmpty()) {
                return null;
            }
            return (new JpegThumbnailSizes(new ArrayList<>(list)));
        }

        @Override
        public void setSetting(Camera.Parameters parameters) {
            parameters.setJpegThumbnailSize(getCurrSettingValue().width,
                    getCurrSettingValue().height);
        }
    }

    static class PictureSizes extends Setting<Camera.Size> {
        PictureSizes(ArrayList<Camera.Size> settingValueList) {
            super(settingValueList, R.drawable.img_resolution, "PictureSizes");
        }

        public static PictureSizes getPictureSizes() {
            if (cameraParameters == null) {
                return null;
            }
            List<Camera.Size> list = cameraParameters.getSupportedPictureSizes();
            if (list == null || list.isEmpty()) {
                return null;
            }
            return (new PictureSizes(new ArrayList<>(list)));
        }

        @Override
        public void setSetting(Camera.Parameters parameters) {
            parameters.setPictureSize(getCurrSettingValue().width, getCurrSettingValue().height);
        }
    }

    static class PreviewSizes extends Setting<Camera.Size> {
        PreviewSizes(ArrayList<Camera.Size> settingValueList) {
            super(settingValueList, R.drawable.img_resolution, "PreviewSizes");
        }

        public static PreviewSizes getPreviewSizes() {
            if (cameraParameters == null) {
                return null;
            }
            List<Camera.Size> list = cameraParameters.getSupportedPreviewSizes();
            if (list == null || list.isEmpty()) {
                return null;
            }
            return (new PreviewSizes(new ArrayList<>(list)));
        }

        @Override
        public void setSetting(Camera.Parameters parameters) {
            parameters.setPreviewSize(getCurrSettingValue().width, getCurrSettingValue().height);
        }
    }

    static class PreviewFpsRange extends Setting<int[]> {
        PreviewFpsRange(ArrayList<int[]> settingValueList) {
            super(settingValueList, R.drawable.abc_btn_radio_material, "PreviewFpsRange");
        }

        public static PreviewFpsRange getPreviewFpsRange() {
            if (cameraParameters == null) {
                return null;
            }
            List<int[]> list = cameraParameters.getSupportedPreviewFpsRange();
            if (list == null || list.isEmpty()) {
                return null;
            }
            return (new PreviewFpsRange(new ArrayList<>(list)));
        }

        @Override
        public void setSetting(Camera.Parameters parameters) {
            parameters.setPreviewFpsRange(getCurrSettingValue()[0], getCurrSettingValue()[1]);
        }
    }

    static class PictureFormats extends Setting<Integer> {
        PictureFormats(ArrayList<Integer> settingValueList) {
            super(settingValueList, R.drawable.abc_btn_radio_material, "PictureFormats");
        }

        public static PictureFormats getPictureFormats() {
            if (cameraParameters == null) {
                return null;
            }
            List<Integer> list = cameraParameters.getSupportedPictureFormats();
            if (list == null || list.isEmpty()) {
                return null;
            }
            return (new PictureFormats(new ArrayList<>(list)));
        }

        @Override
        public void setSetting(Camera.Parameters parameters) {
            parameters.setPictureFormat(getCurrSettingValue());
        }
    }

    static class PreviewFormats extends Setting<Integer> {
        PreviewFormats(ArrayList<Integer> settingValueList) {
            super(settingValueList, R.drawable.abc_btn_radio_material, "PreviewFormats");
        }

        public static PreviewFormats getPreviewFormats() {
            if (cameraParameters == null) {
                return null;
            }
            List<Integer> list = cameraParameters.getSupportedPreviewFormats();
            if (list == null || list.isEmpty()) {
                return null;
            }
            return (new PreviewFormats(new ArrayList<>(list)));
        }

        @Override
        public void setSetting(Camera.Parameters parameters) {
            parameters.setPreviewFormat(getCurrSettingValue());
        }
    }

//    static class VideoSizes extends Setting<Camera.Size> {
//        VideoSizes(ArrayList<Camera.Size> settingValueList) {
//            super(settingValueList, R.drawable.abc_btn_radio_material, "VideoSizes");
//        }
//
//        public static VideoSizes getVideoSizes() {
//            if (cameraParameters == null) {
//                return null;
//            }
//            List<Camera.Size> list = cameraParameters.getSupportedVideoSizes();
//            if (list == null || list.isEmpty()) {
//                return null;
//            }
//            return (new VideoSizes(new ArrayList<>(list)));
//        }
//
//        @Override
//        public void setSetting(Camera.Parameters parameters) {
//            parameters.(getCurrSettingValue().width, getCurrSettingValue().height);
//        }
//    }

    static class ZoomRatios extends Setting<Integer> {
        ZoomRatios(ArrayList<Integer> settingValueList) {
            super(settingValueList, R.drawable.img_zoom, "ZoomRatios");
        }

        public static ZoomRatios getZoomRatios() {
            if (cameraParameters == null || !cameraParameters.isZoomSupported()) {
                return null;
            }
            List<Integer> list = cameraParameters.getZoomRatios();
            if (list == null || list.isEmpty()) {
                return null;
            }
            return (new ZoomRatios(new ArrayList<>(list)));
        }

        @Override
        public void setSetting(Camera.Parameters parameters) {
            parameters.setZoom(getCurrSettingValue());
        }
    }

    //---------------
    static class ExposureCompensation extends Setting<Integer> {
        ExposureCompensation(ArrayList<Integer> settingValueList) {
            super(settingValueList, R.drawable.img_iso, "ExposureCompensation");
        }

        public static ExposureCompensation getExposureCompensation() {
            if (cameraParameters == null) {
                return null;
            }
            if (cameraParameters.getMaxExposureCompensation() -
                    cameraParameters.getMinExposureCompensation() == 0) {
                return null;
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = cameraParameters.getMinExposureCompensation();
                 i < cameraParameters.getMaxExposureCompensation(); ++i) {
                 list.add(i);
            }
            return (new ExposureCompensation(list));
        }

        @Override
        public void setSetting(Camera.Parameters parameters) {
            parameters.setExposureCompensation(getCurrSettingValue());
        }
    }

    static class JpegThumbnailQuality extends Setting<Integer> {
        JpegThumbnailQuality(ArrayList<Integer> settingValueList) {
            super(settingValueList, R.drawable.abc_btn_radio_material, "JpegThumbnailQuality");
        }

        public static JpegThumbnailQuality getJpegThumbnailQuality() {
            if (cameraParameters == null) {
                return null;
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 100; i < 0; i -= 10) {
                list.add(i);
            }
            return (new JpegThumbnailQuality(list));
        }

        @Override
        public void setSetting(Camera.Parameters parameters) {
            parameters.setJpegThumbnailQuality(getCurrSettingValue());
        }
    }

//    static class AutoWhiteBalanceLock extends Setting<Boolean> {
//        AutoWhiteBalanceLock(ArrayList<Boolean> settingValueList) {
//            super(settingValueList, R.drawable.img_white_balance, "AutoWhiteBalanceLock");
//        }
//
//        public static AutoWhiteBalanceLock getJAutoWhiteBalanceLock() {
//            if (cameraParameters == null) {
//                return null;
//            }
////            if (!cameraParameters.isAutoWhiteBalanceLockSupported()) {
////                return null;
////            }
//            ArrayList<Boolean> list = new ArrayList<>();
//            list.add(false);
//            list.add(true);
//            return (new AutoWhiteBalanceLock(list));
//        }
//
//        @Override
//        public void setSetting(Camera.Parameters parameters) {
//            parameters.setAutoWhiteBalanceLock(getCurrSettingValue());
//        }
//    }

    static class Rotation extends Setting<Integer> {
        Rotation(ArrayList<Integer> settingValueList) {
            super(settingValueList, R.drawable.img_timer, "Rotation");
        }

        public static Rotation getRotation() {
            if (cameraParameters == null) {
                return null;
            }
            List<Integer> list = new ArrayList<>();
            list.add(90);
            for (int i = 0; i <= 360; i += 25) {
                if (i != 90) {
                    list.add(i);
                }
            }
            return (new Rotation(new ArrayList<>(list)));
        }

        @Override
        public void setSetting(Camera.Parameters parameters) {
            parameters.setRotation(getCurrSettingValue());
        }
    }

//    static class RecordingHint extends Setting<Boolean> {
//        RecordingHint(ArrayList<Boolean> settingValueList) {
//            super(settingValueList, R.drawable.abc_btn_radio_material, "RecordingHint");
//        }
//
//        public static RecordingHint getRecordingHint() {
//            if (cameraParameters == null) {
//                return null;
//            }
//            ArrayList<Boolean> list = new ArrayList<>();
//            list.add(false);
//            list.add(true);
//            return (new RecordingHint(list));
//        }
//
//        @Override
//        public void setSetting(Camera.Parameters parameters) {
//            parameters.setRecordingHint(getCurrSettingValue());
//        }
//    }

//    static class AutoExposureLock extends Setting<Boolean> {
//        AutoExposureLock(ArrayList<Boolean> settingValueList) {
//            super(settingValueList, R.drawable.abc_btn_radio_material, "AutoExposureLock");
//        }
//
//        public static AutoExposureLock getAutoExposureLock() {
//            if (cameraParameters == null || !cameraParameters.isAutoExposureLockSupported()) {
//                return null;
//            }
//
//            ArrayList<Boolean> list = new ArrayList<Boolean>();
//            list.add(false);
//            list.add(true);
//            return (new AutoExposureLock(list));
//        }

//    @Override
//    public void setSetting(Camera.Parameters parameters) {
//        parameters.setAutoExposureLock(getCurrSettingValue());
//    }
//    }

//    static class FocusAreas extends Setting<Camera.Size> {
//        FocusAreas(ArrayList<Camera.Size> settingValueList) {
//            super(settingValueList, R.drawable.abc_btn_radio_material, "FocusAreas");
//        }
//
//        public static FocusAreas getFocusAreas() {
//            if (cameraParameters == null) {
//                return null;
//            }
//            cameraParameters.setFocusAreas();
//            List<Camera.Size> list = cameraParameters.getSupportedVideoSizes();
//            if (list == null || list.isEmpty()) {
//                return null;
//            }
//            return (new FocusAreas(new ArrayList<>(list)));
//        }

//    @Override
//    public void setSetting(Camera.Parameters parameters) {
//        parameters.setVc(getCurrSettingValue());
//    }
//    }

//    static class GPS extends Setting<Camera.Size> {
//        FocusAreas(ArrayList<Camera.Size> settingValueList) {
//            super(settingValueList, R.drawable.abc_btn_radio_material, "GPS");
//        }
//
//        public static FocusAreas getFocusAreas() {
//            if (cameraParameters == null) {
//                return null;
//            }
//            cameraParameters.setGpsTimestamp();
//            cameraParameters.setGpsAltitude();
//            cameraParameters.setGps...
//            List<Camera.Size> list = cameraParameters.getSupportedVideoSizes();
//            if (list == null || list.isEmpty()) {
//                return null;
//            }
//            return (new FocusAreas(new ArrayList<>(list)));
//        }


//    @Override
//    public void setSetting(Camera.Parameters parameters) {
//        parameters.setGpsAltitude(getCurrSettingValue());
//    }
//    }

//    static class VideoStabilization extends Setting<Boolean> {
//        VideoStabilization(ArrayList<Boolean> settingValueList) {
//            super(settingValueList, R.drawable.abc_btn_radio_material, "VideoStabilization");
//        }
//
//        public static VideoStabilization getVideoStabilization() {
//            if (cameraParameters == null || !cameraParameters.isVideoStabilizationSupported()) {
//                return null;
//            }
//            cameraParameters.setVideoStabilization(true);
//            List<Boolean> list = new ArrayList<Boolean>();
//            list.add(false);
//            list.add(true);
//            return (new VideoStabilization(list));
//        }

//    @Override
//    public void setSetting(Camera.Parameters parameters) {
//        parameters.setVideoStabilization(getCurrSettingValue());
//    }
//    }

//    static class SmoothZoom extends Setting<Camera.Area> {
//        SmoothZoom(ArrayList<Camera.Area> settingValueList) {
//            super(settingValueList, R.drawable.abc_list_focused_holo, "SmoothZoom");
//        }
//
//        public static SmoothZoom getSmoothZoom() {
//            if (cameraParameters == null || !cameraParameters.isSmoothZoomSupported()) {
//                return null;
//            }
//            ///dg
//            cameraParameters.isVideoSnapshotSupported()
//            List<Camera.Area> list = cameraParameters.getMeteringAreas();
//            if (list == null || list.isEmpty()) {
//                return null;
//            }
//            return (new SmoothZoom(new ArrayList<>(list)));
//        }

//    @Override
//    public void setSetting(Camera.Parameters parameters) {
//        parameters.(getCurrSettingValue());
//    }
//    }

//    static class VideoSnapshot extends Setting<Camera.Area> {
//        VideoSnapshot(ArrayList<Camera.Area> settingValueList) {
//            super(settingValueList, R.drawable.abc_list_focused_holo, "VideoSnapshot");
//        }
//
//        public static VideoSnapshot getVideoSnapshot() {
//            if (cameraParameters == null || !cameraParameters.isVideoSnapshotSupported()) {
//                return null;
//            }
//            ///dg
//            List<Camera.Area> list = cameraParameters.getMeteringAreas();
//            if (list == null || list.isEmpty()) {
//                return null;
//            }
//            return (new VideoSnapshot(new ArrayList<>(list)));
//        }

//    @Override
//    public void setSetting(Camera.Parameters parameters) {
//        parameters.set(getCurrSettingValue());
//    }
//    }
}
