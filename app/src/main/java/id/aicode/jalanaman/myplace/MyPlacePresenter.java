package id.aicode.jalanaman.myplace;

import android.content.Context;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import id.aicode.jalanaman.BaseModel;
import id.aicode.jalanaman.BaseView;
import id.aicode.jalanaman.helper.Helper;
import id.aicode.jalanaman.services.LocalServices;
import id.aicode.jalanaman.services.RemoteServices;
import id.aicode.jalanaman.services.models.login.Place;
import id.aicode.jalanaman.services.models.place.PlaceResponse;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ibam on 7/16/2017.
 */

public class MyPlacePresenter implements MyPlaceContract.Presenter {

    MyPlaceContract.View mView;
    RemoteServices remoteServices;

    public MyPlacePresenter(){
        this.remoteServices = new RemoteServices();
    }

    @Override
    public void setView(BaseView view) {
        this.mView = (MyPlaceContract.View) view;
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
    public void getSavedItems(Context context) {
        String token = LocalServices.getToken(context);

        remoteServices.getUserPlaces(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<List<PlaceResponse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.failedLoadPlaces(e.getMessage());
                    }

                    @Override
                    public void onNext(List<PlaceResponse> placeResponses) {
                        mView.showSavedItems(placeResponses);
                    }
                });
    }
}
