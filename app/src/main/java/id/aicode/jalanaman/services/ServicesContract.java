package id.aicode.jalanaman.services;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

/**
 * Created by Ibam on 7/16/2017.
 */

public interface ServicesContract {

    interface RemoteContract {
        void login(String email, String password);
        void register(String email, String password);
        void getRecentDangers();
        void addMyPlace(String type, String name, String pointOne, @Nullable String pointTwo);
        void getComments(String eventId);
        void postEvent(String type, String description, String point, @Nullable Drawable photo);
        void postComments(String comment);
    }

    interface LocalContract {
        void makeCall(String number);
        void getPictureFromGallery();
    }
}
