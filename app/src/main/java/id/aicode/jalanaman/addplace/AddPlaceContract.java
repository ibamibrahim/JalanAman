package id.aicode.jalanaman.addplace;

import android.content.Context;

import id.aicode.jalanaman.BasePresenter;
import id.aicode.jalanaman.BaseView;
import id.aicode.jalanaman.services.models.EventData;
import id.aicode.jalanaman.services.models.NewPlaceData;

/**
 * Created by Ibam on 7/16/2017.
 */

public class AddPlaceContract {
    interface Presenter extends BasePresenter {
        void savePlace(Context context, NewPlaceData data);
    }

    interface View extends BaseView {
        void succesful();
        void failed(String message);
    }
}
