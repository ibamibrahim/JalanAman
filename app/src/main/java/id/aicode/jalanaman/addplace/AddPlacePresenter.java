package id.aicode.jalanaman.addplace;

import android.content.Context;
import android.util.Log;

import java.io.IOException;

import id.aicode.jalanaman.BaseModel;
import id.aicode.jalanaman.BaseView;
import id.aicode.jalanaman.services.LocalServices;
import id.aicode.jalanaman.services.RemoteServices;
import id.aicode.jalanaman.services.models.EventData;
import id.aicode.jalanaman.services.models.NewPlaceData;
import id.aicode.jalanaman.services.models.event.CreateEventResponse;
import id.aicode.jalanaman.services.models.place.AddMyPlaceResponse;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ibam on 7/30/2017.
 */

public class AddPlacePresenter implements AddPlaceContract.Presenter {

    AddPlaceContract.View mView;
    RemoteServices remoteServices;

    public AddPlacePresenter() {
        this.remoteServices = new RemoteServices();
    }

    @Override
    public void setView(BaseView view) {
        this.mView = (AddPlaceContract.View) view;
    }

    @Override
    public void unsetView() {

    }

    @Override
    public void setModel(BaseModel model) {

    }

    @Override
    public void unsetModel() {

    }

    @Override
    public void savePlace(Context context, NewPlaceData data) {
        Log.d("AddPlacePresenter", data.toString());
        String token = LocalServices.getToken(context);
        remoteServices.addMyPlace(token, data)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<AddMyPlaceResponse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Response<AddMyPlaceResponse> response) {
                        try {
                            Log.d("AddPlacePresenter", response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if(response.isSuccessful()){
                            mView.succesful();
                        } else {
                            mView.failed("Failed to report! " + response.message());
                        }
                    }
                });
    }
}
