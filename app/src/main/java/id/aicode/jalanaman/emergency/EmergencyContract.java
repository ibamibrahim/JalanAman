package id.aicode.jalanaman.emergency;

import android.content.Context;

import java.util.List;

import id.aicode.jalanaman.BasePresenter;
import id.aicode.jalanaman.BaseView;

/**
 * Created by Ibam on 7/16/2017.
 */

public class EmergencyContract {
    interface Presenter extends BasePresenter {
        void logOut(Context context);
    }

    interface View extends BaseView {
        void updateEmergencyCallList(List<EmergencyCallModel> models);
    }
}
