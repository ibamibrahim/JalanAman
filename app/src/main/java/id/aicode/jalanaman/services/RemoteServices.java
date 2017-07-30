package id.aicode.jalanaman.services;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

import java.util.List;

import id.aicode.jalanaman.services.models.EventData;
import id.aicode.jalanaman.services.models.LoginData;
import id.aicode.jalanaman.services.models.NewPlaceData;
import id.aicode.jalanaman.services.models.RegisterData;
import id.aicode.jalanaman.services.models.event.CreateEventResponse;
import id.aicode.jalanaman.services.models.event.EventResponse;
import id.aicode.jalanaman.services.models.login.LoginResponse;
import id.aicode.jalanaman.services.models.place.AddMyPlaceResponse;
import id.aicode.jalanaman.services.models.place.PlaceResponse;
import id.aicode.jalanaman.services.models.register.RegisterResponse;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Ibam on 7/16/2017.
 */

public class RemoteServices implements ServicesContract.RemoteContract {

    JARemoteService retrofit;
    final String BASE_URL = "https://safehouse-backend.herokuapp.com/api/v1/";

    private void initRetrofit() {
        this.retrofit = getRetrofit(BASE_URL);
    }

    @Override
    public Observable<Response<LoginResponse>> login(String email, String password, String
            deviceToken) {
        initRetrofit();
        return retrofit.login(new LoginData(email, password, deviceToken));
    }

    @Override
    public Observable<RegisterResponse> register(RegisterData data) {
        initRetrofit();
        return retrofit.register(data);
    }

    @Override
    public Observable<List<EventResponse>> getRecentDangers(String token) {
        initRetrofit();
        return retrofit.getEvent(token);
    }

    public Observable<List<PlaceResponse>> getUserPlaces(String token) {
        initRetrofit();
        return retrofit.getUserPlaces(token);
    }

    public Observable<Response<AddMyPlaceResponse>> addMyPlace(String token, NewPlaceData data) {
        initRetrofit();
        return retrofit.postNewPlace(token, data);
    }

    public void getComments(String eventId) {

    }

    public Observable<Response<CreateEventResponse>> postEvent(String token, EventData data) {
        initRetrofit();
        return retrofit.postNewEvent(token, data);
    }

    public void postComments(String comment) {

    }

    public JARemoteService getRetrofit(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(JARemoteService.class);
    }
}
