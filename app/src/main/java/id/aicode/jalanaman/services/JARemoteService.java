package id.aicode.jalanaman.services;

import id.aicode.jalanaman.services.models.LoginData;
import id.aicode.jalanaman.services.models.user.UserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Ibam on 7/24/2017.
 */

public interface JARemoteService {

    @POST("/api/v1/login/")
    Observable<UserResponse> login(@Body LoginData data);
}
