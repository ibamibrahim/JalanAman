package id.aicode.jalanaman.services;

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
import id.aicode.jalanaman.services.models.profile.ProfileResponse;
import id.aicode.jalanaman.services.models.register.RegisterResponse;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Ibam on 7/24/2017.
 */

public interface JARemoteService {

    @POST("/api/v1/login/")
    Observable<Response<LoginResponse>> login(@Body LoginData data);

    @POST("/api/v1/register/")
    Observable<RegisterResponse> register(@Body RegisterData data);

    @GET("/api/v1/event")
    Observable<Response<List<EventResponse>>> getEvent(@Header("Authorization") String token);

    @GET("/user/profile")
    Observable<ProfileResponse> getProfile(@Header("Authorization") String token);

    @GET("/api/v1/places/")
    Observable<List<PlaceResponse>> getUserPlaces(@Header("Authorization") String token);

    @POST("/api/v1/event")
    Observable<Response<CreateEventResponse>> postNewEvent(@Header("Authorization") String token,
                                                           @Body EventData data);

    @POST("/api/v1/places/")
    Observable<Response<AddMyPlaceResponse>> postNewPlace(@Header("Authorization") String token,
                                                          @Body NewPlaceData data);
}
