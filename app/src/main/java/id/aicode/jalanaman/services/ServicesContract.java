package id.aicode.jalanaman.services;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

import java.util.List;

import id.aicode.jalanaman.services.models.RegisterData;
import id.aicode.jalanaman.services.models.event.EventResponse;
import id.aicode.jalanaman.services.models.login.LoginResponse;
import id.aicode.jalanaman.services.models.register.RegisterResponse;
import retrofit2.Response;
import rx.Observable;

/**
 * Created by Ibam on 7/16/2017.
 */

public interface ServicesContract {

    interface RemoteContract {
        Observable<Response<LoginResponse>> login(String email, String password, String token);
        Observable<RegisterResponse> register(RegisterData data);
        Observable<List<EventResponse>> getRecentDangers(String token);
    }

}
