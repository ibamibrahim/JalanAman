package id.aicode.jalanaman.helper;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Ibam on 7/16/2017.
 */

public class Helper {
    
    public static void createNotification(String title, Drawable image) {

    }

    
    public static void checkSession(Context context) {

    }

    
    public static void createToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    
    public static ProgressDialog showProgressDialog(AppCompatActivity activity, String text) {
        ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(text);
        progressDialog.setCancelable(true);

        return progressDialog;
    }
}