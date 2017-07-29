package id.aicode.jalanaman.myplace;

import android.content.Context;

import java.util.List;

import id.aicode.jalanaman.BasePresenter;
import id.aicode.jalanaman.BaseView;
import id.aicode.jalanaman.services.models.login.Place;
import id.aicode.jalanaman.services.models.place.PlaceResponse;

/**
 * Created by Ibam on 7/16/2017.
 */

public class MyPlaceContract {
    interface Presenter extends BasePresenter {
        void getSavedItems(Context context);
    }

    interface View extends BaseView {
        void showSavedItems(List<PlaceResponse> list);
        void getSavedItems();
        void failedLoadPlaces(String a);
    }
}
