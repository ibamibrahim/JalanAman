package id.aicode.jalanaman.recent;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import id.aicode.jalanaman.BaseModel;
import id.aicode.jalanaman.BaseView;
import id.aicode.jalanaman.services.JARemoteService;
import id.aicode.jalanaman.services.LocalServices;
import id.aicode.jalanaman.services.RemoteServices;
import id.aicode.jalanaman.services.models.event.EventResponse;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ibam on 7/16/2017.
 */

public class RecentPresenter implements RecentContract.Presenter {

    private RecentContract.View mView;
    private RemoteServices remoteService;

    public RecentPresenter() {
        this.remoteService = new RemoteServices();
    }

    @Override
    public void setView(BaseView view) {
        this.mView = (RecentContract.View) view;
    }

    @Override
    public void unsetView() {
        this.mView = null;
    }

    @Override
    public void setModel(BaseModel model) {

    }

    @Override
    public void unsetModel() {

    }

    @Override
    public void loadRecentDanger(Context context) {
        String token = LocalServices.getToken(context);

        remoteService.getRecentDangers(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<List<EventResponse>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.loadRecentDangersFailed(e.getMessage());
                    }

                    @Override
                    public void onNext(Response<List<EventResponse>> response) {
                        List<EventResponse> list = response.body();
                        if (!response.isSuccessful()) {
                            try {
                                Log.d("RecentPresenter", response.message().toString());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            if (list == null) {
                                mView.loadRecentDangersFailed("");
                            } else {
                                mView.loadRecentDangers(list);
                            }
                        }
                    }
                });
    }
}
