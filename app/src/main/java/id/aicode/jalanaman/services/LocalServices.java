package id.aicode.jalanaman.services;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;

import id.aicode.jalanaman.helper.Helper;
import id.aicode.jalanaman.login.LoginActivity;

/**
 * Created by Ibam on 7/16/2017.
 */

public class LocalServices {

    private static String SHARED_PREF_NAME = "id.aicode.jalanaman";
    private static String TOKEN_SAVE_KEY = "id.aicoide.jalanaman.token";

    public static void makeCall(Context context, String number) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+number));

        try {
            context.startActivity(callIntent);
        } catch (SecurityException exception) {
            Helper.createToast(context, "Please enable phone call for this application");
        }
    }

    public void getPictureFromGallery() {

    }

    public static String getToken(Context context) {
        SharedPreferences sharedPrefs = context.getSharedPreferences(SHARED_PREF_NAME, Context
                .MODE_PRIVATE);
        String token = sharedPrefs.getString(TOKEN_SAVE_KEY, null);
        return token;
    }

    public static boolean isLoggedInBool(Context context) {
        if (getToken(context) == null) {
            return false;
        }
        return true;
    }

    public static void isLoggedIn(Context context) {
        if (!isLoggedInBool(context)) {
            Intent intent = new Intent(context, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(intent);
        }
    }

    public static void saveToken(Context context, String newToken) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOKEN_SAVE_KEY, newToken);
        editor.commit();
    }

    private static void clearLocalData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public static void logOut(Context context) {
        clearLocalData(context);
        isLoggedIn(context);
    }

}
