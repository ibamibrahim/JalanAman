package id.aicode.jalanaman.helper;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import id.aicode.jalanaman.R;

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


    public static ProgressDialog showProgressDialog(Context activity, String text) {
        ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(text);
        progressDialog.setCancelable(true);

        return progressDialog;
    }

    public static void showPhoto(Context context, String url) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);

        View dialogView = inflater.inflate(R.layout.dialog_image,  null);
        ImageView imageView = (ImageView) dialogView.findViewById(R.id.big_image_recent);
        Picasso.with(context).load(url).into(imageView);

        dialogBuilder.setView(dialogView);

        AlertDialog dialog = dialogBuilder.create();
        Window window = dialog.getWindow();
        WindowManager.LayoutParams param = window.getAttributes();
        param.x = 450;
        window.setAttributes(param);
        dialog.show();
    }
}