package id.aicode.jalanaman.helper;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by Ibam on 7/16/2017.
 */

public interface HelperContract {
    void createNotification(String title, Drawable image);
    void checkSession();
    void createToast(Context context, String text);
}
