package id.aicode.jalanaman.helper;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

/**
 * Created by Ibam on 7/16/2017.
 */

public class Helper implements HelperContract{
    
    public static void createNotification(String title, Drawable image) {

    }

    
    public static void checkSession() {

    }

    
    public static void createToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    
    public static void showProgressDialog(Context context, String text) {

    }
}
