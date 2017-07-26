package id.aicode.jalanaman.services;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

import java.util.List;

import id.aicode.jalanaman.services.models.event.EventResponse;
import id.aicode.jalanaman.services.models.login.LoginResponse;
import rx.Observable;

/**
 * Created by Ibam on 7/16/2017.
 */

public interface ServicesContract {

    interface RemoteContract {
        Observable<LoginResponse> login(String email, String password);
        void register(String email, String password);
        Observable<List<EventResponse>> getRecentDangers(String token);
        void addMyPlace(String type, String name, String pointOne, @Nullable String pointTwo);
        void getComments(String eventId);
        void postEvent(String type, String description, String point, @Nullable Drawable photo);
        void postComments(String comment);
    }

}
