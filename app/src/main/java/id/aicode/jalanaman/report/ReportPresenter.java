package id.aicode.jalanaman.report;

import android.content.Context;
import android.util.Log;

import id.aicode.jalanaman.BaseModel;
import id.aicode.jalanaman.BaseView;
import id.aicode.jalanaman.helper.Helper;
import id.aicode.jalanaman.services.LocalServices;
import id.aicode.jalanaman.services.RemoteServices;
import id.aicode.jalanaman.services.models.EventData;
import id.aicode.jalanaman.services.models.event.CreateEventResponse;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ibam on 7/30/2017.
 */

public class ReportPresenter implements ReportContract.Presenter {

    ReportContract.View mView;
    RemoteServices remoteServices;

    public ReportPresenter() {
        this.remoteServices = new RemoteServices();
    }

    @Override
    public void setView(BaseView view) {
        this.mView = (ReportContract.View) view;
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
    public void postEvent(Context context, EventData eventData) {
        String token = LocalServices.getToken(context);
        remoteServices.postEvent(token, eventData)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<CreateEventResponse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Response<CreateEventResponse> response) {
                        Log.d("AddPlacePresenter", response.errorBody().toString());
                        if(response.isSuccessful()){
                            mView.succesfulReport();
                        } else {
                            mView.failedReport("Failed to report! " + response.message());
                        }
                    }
                });
    }
}
