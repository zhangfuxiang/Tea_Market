package com.delta.commonlibs.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description :
 * @autHor :  V.Wenju.Tian
 * @date : 2016/12/20 14:33
 */


public class IntentUtils {

    private static final String IMAGE_TYPE = "image/*";
    private static final String TAG = "IntentUtil";

    /**
     * 进行页面跳转
     *
     * @param clzz
     */
    public static void showIntent(Activity context, Class<?> clzz, String[] keys, String[] values) {
        Intent intent = new Intent(context, clzz);
        if (values != null && values.length > 0) {
            for (int i = 0; i < values.length; i++) {
                if (!TextUtils.isEmpty(keys[i]) && !TextUtils.isEmpty(values[i])) {
                    intent.putExtra(keys[i], values[i]);
                }
            }
        }
        context.startActivity(intent);
    }

    public static void showIntentWithInt(Activity context, Class<?> clzz, String[] keys, int[] values) {
        Intent intent = new Intent(context, clzz);
        if (values != null && values.length > 0) {
            for (int i = 0; i < values.length; i++) {
                if (!TextUtils.isEmpty(keys[i])) {
                    intent.putExtra(keys[i], values[i]);
                }
            }
        }
        context.startActivity(intent);
    }

    public static void showIntent(Activity context, Class<?> clzz) {
        showIntent(context, clzz, null, null);
    }

    public static void showIntent(Activity context, Class<?> clzz, Bundle bundle) {
        Intent intent = new Intent(context, clzz);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     * 打电话
     *
     * @param context
     * @param tel
     */
    public static void openCall(Context context, String tel) {
        tel = tel.replaceAll("-", "");
        Intent intent = new Intent();
        // 激活源代码,添加intent对象
        intent.setAction("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:" + tel));
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    /***
     * 从相册中取图片
     */
    public static void pickPhoto(Activity context, int requestCode) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        context.startActivityForResult(intent, requestCode);
    }

    /**
     * 拍照获取图片
     */
    public static void takePhoto(Activity context, int requestCode, Uri cameraUri) {
        // 执行拍照前，应该先判断SD卡是否存在
        String SDState = Environment.getExternalStorageState();
        if (SDState.equals(Environment.MEDIA_MOUNTED)) {

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// "android.media.action.IMAGE_CAPTURE"

            intent.putExtra(MediaStore.EXTRA_OUTPUT, cameraUri);
            context.startActivityForResult(intent, requestCode);
        } else {
            Toast.makeText(context, "内存卡不存在", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 拍照
     *
     * @param context
     * @param uri
     */
    public static void takePhoto(Activity context, Uri uri, int requestCode) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.DISPLAY_NAME, String.valueOf(System.currentTimeMillis()) + ".jpg");
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/*");
            uri = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            // intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            context.startActivityForResult(intent, requestCode);

        } else {
            Toast.makeText(context, "内存卡不存在", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 本地照片调用
     *
     * @param context
     * @param requestCode
     */
    public void openPhotos(Activity context, int requestCode) {
        if (openPhotosNormal(context, requestCode) //
                && openPhotosBrowser(context, requestCode) //
                && openPhotosFinally(context))
            ;
    }

    /**
     * 这个是找不到相关的图片浏览器,或者相册
     */
    private boolean openPhotosFinally(Activity context) {
        Toast.makeText(context, "您的系统没有文件浏览器或则相册支持,请安装！", Toast.LENGTH_LONG).show();
        return false;
    }

    /**
     * 获取从本地图库返回来的时候的URI解析出来的文件路径
     *
     * @return
     */
    public static String getPhotoPathByLocalUri(Context context, Intent data) {
        Uri photoUri = data.getData();
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(photoUri, filePathColumn, null, null, null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String picturePath = cursor.getString(columnIndex);
        cursor.close();
        return picturePath;
    }

    /**
     * PopupMenu打开本地相册.
     */
    private boolean openPhotosNormal(Activity activity, int actResultCode) {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_TYPE);
        try {
            activity.startActivityForResult(intent, actResultCode);

        } catch (android.content.ActivityNotFoundException e) {

            return true;
        }

        return false;
    }

    /**
     * 打开其他的一文件浏览器,如果没有本地相册的话
     */
    private boolean openPhotosBrowser(Activity activity, int requestCode) {
        Toast.makeText(activity, "没有相册软件，运行文件浏览器", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT); // "android.intent.action.GET_CONTENT"
        intent.setType(IMAGE_TYPE); // 查看类型 String IMAGE_UNSPECIFIED =
        // "image/*";
        Intent wrapperIntent = Intent.createChooser(intent, null);
        try {
            activity.startActivityForResult(wrapperIntent, requestCode);
        } catch (android.content.ActivityNotFoundException e1) {
            return true;
        }
        return false;
    }

    /**
     * 打开照相机
     *
     * @param context     当前的activity
     * @param requestCode 拍照成功时activity forResult 的时候的requestCode
     */
    @SuppressLint("SimpleDateFormat")
    public static Uri openCamera(Activity context, int requestCode) {
        // 执行拍照前，应该先判断SD卡是否存在
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            SimpleDateFormat timeStampFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
            String filename = timeStampFormat.format(new Date());
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.TITLE, filename);
            Uri photoUri = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
            context.startActivityForResult(intent, requestCode);

            return photoUri;
        } else {
            Toast.makeText(context, "内存卡不存在", Toast.LENGTH_LONG).show();
        }
        return null;
    }


    /**
     * 选择图片后，获取图片的路径
     *
     * @param requestCode
     * @param data
     */
    public static void doPhoto(Activity context, Intent data, int requestCode, int value, EditText editText,
                               ImageView imageView, Uri photoUri) {
        // 从相册取图片，有些手机有异常情况，请注意
        if (requestCode == value) {
            if (data == null) {
                Toast.makeText(context, "选择图片文件出错", Toast.LENGTH_LONG).show();
                return;
            }
            photoUri = data.getData();
            if (photoUri == null) {
                Toast.makeText(context, "选择图片文件出错", Toast.LENGTH_LONG).show();
                return;
            }
        }

        String[] pojo = {MediaStore.Images.Media.DATA, MediaStore.Images.Media.DISPLAY_NAME};
        ContentResolver resolver = context.getContentResolver();
        Cursor cursor = resolver.query(photoUri, pojo, null, null, null);
        String picPath = null;
        String filename = null;
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndexOrThrow(pojo[0]);
            cursor.moveToFirst();
            picPath = cursor.getString(columnIndex);
            filename = cursor.getString(cursor.getColumnIndexOrThrow(pojo[1]));

            editText.requestFocus();
            editText.setText(filename);

            cursor.close();
        }
        String dix = filename.substring(filename.lastIndexOf("."), filename.length());

        if (filename != null
                && (dix.equalsIgnoreCase(".png") || dix.equalsIgnoreCase(".jpg") || dix.equalsIgnoreCase(".gif")
                || dix.equalsIgnoreCase(".bmp") || dix.equalsIgnoreCase(".jpeg") || dix
                .equalsIgnoreCase(".tiff"))) {
            // lastIntent.putExtra(KEY_PHOTO_PATH, picPath);
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageURI(Uri.parse(picPath));
        } else {
            imageView.setVisibility(View.GONE);
            Toast.makeText(context, "选择图片文件不正确", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * FLAG_ACTIVITY_SINGLE_TOP
     * //当于加载模式中的singletop,在当前中的activity中转到当前activity，不增加新的
     *
     * @param file
     */
    public static void openFile(Context context, File file) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);// 默认的跳转类型,它会重新创建一个新的Activity
        intent.setAction(Intent.ACTION_VIEW);
        // 调用getMIMEType()来取得MimeType
        String type = FileUtil.getMimeType(file);
        // 设置intent的file与MimeType
        intent.setDataAndType(Uri.fromFile(file), type);
        context.startActivity(intent);
    }

    /**
     * 截取图片
     *
     * @param uri
     * @param outputX
     * @param outputY
     * @param requestCode
     */
    public static void cropImage(Activity context, Uri uri, int outputX, int outputY, int requestCode) {
        // 裁剪图片意图
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // 裁剪框的比例，1：1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪后输出图片的尺寸大小
        intent.putExtra("outputX", outputX);
        intent.putExtra("outputY", outputY);
        // 图片格式
        intent.putExtra("outputFormat", "JPEG");
        intent.putExtra("noFaceDetection", true);
        intent.putExtra("return-data", true);
        context.startActivityForResult(intent, requestCode);
    }

    /**
     * 获取图片的旋转角度
     *
     * @param path
     * @return
     */
    public static int readPictureDegree(String path) {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

    /**
     * 保存文件
     *
     * @param context
     * @param data
     * @param requestCode
     * @param imageView
     */
    public static void saveImage(Activity context, Intent data, int requestCode, ImageView imageView) {
        Bitmap photo = null;
        Uri photoUri = data.getData();
        cropImage(context, photoUri, 500, 500, requestCode);
        if (photoUri != null) {
            photo = BitmapFactory.decodeFile(photoUri.getPath());
        }
        if (photo == null) {
            Bundle extra = data.getExtras();
            if (extra != null) {
                photo = (Bitmap) extra.get("data");
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                photo.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            }
        }
        imageView.setImageBitmap(photo);
    }

    /**
     * 保存照相后的图片
     *
     * @param context
     * @return
     */
    public static boolean saveCamera(Activity context, Intent data, Uri cameraUri, EditText editText,
                                     ImageView imageView) {
        try {

            final Bundle extras = data.getExtras();

            if (extras != null) {
                Bitmap photo = extras.getParcelable("data");
                imageView.setImageBitmap(photo);
            }

            if (cameraUri != null) {
                String path = cameraUri.getPath();
                String filename = path.substring(path.lastIndexOf("/") + 1, path.length());
                editText.setText(filename);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
