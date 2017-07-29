package id.aicode.jalanaman.helper;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import id.aicode.jalanaman.R;
import id.aicode.jalanaman.map.MapsActivity;
import id.aicode.jalanaman.services.models.event.EventResponse;

/**
 * Created by Ibam on 7/16/2017.
 */

public class Helper {

    public static void createNotification(String title, Drawable image) {

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

    public static void showPhoto(Context context, EventResponse response) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);

        View dialogView = inflater.inflate(R.layout.dialog_image, null);

        TextView title = (TextView) dialogView.findViewById(R.id.textView7);
        title.setText(response.getTitle());
        ImageView imageView = (ImageView) dialogView.findViewById(R.id.big_image_recent);
        Picasso.with(context).load(response.getPhotoUrl()).into(imageView);

        dialogBuilder.setView(dialogView);

        AlertDialog dialog = dialogBuilder.create();
        Window window = dialog.getWindow();
        WindowManager.LayoutParams param = window.getAttributes();
        param.x = 450;
        window.setAttributes(param);
        dialog.show();
    }

    public static void showMaps(Context context, EventResponse response) {
        Intent intent = new Intent(context, MapsActivity.class);
        double lat = Double.parseDouble(response.getPointLat());
        double lang = Double.parseDouble(response.getPointLang());
        Log.d("LatLang", lat+","+lang);
        intent.putExtra("lat", lat);
        intent.putExtra("lang", lang);
        intent.putExtra("name", response.getTitle());
        context.startActivity(intent);
    }

    public static <T> String objectToJson(T object){
        Gson gson = new Gson();
        String json = gson.toJson(object);
        return json;
    }

    public static <T> T jsonToObject(String json, Class<T> classObject){
        Gson gson = new Gson();
        T object = gson.fromJson(json, classObject);

        return object;
    }
}