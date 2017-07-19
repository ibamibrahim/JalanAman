package id.aicode.jalanaman.emergency;

import java.util.List;

import id.aicode.jalanaman.BasePresenter;
import id.aicode.jalanaman.BaseView;

/**
 * Created by Ibam on 7/16/2017.
 */

public class EmergencyContract {
    interface Presenter extends BasePresenter {}
    interface View extends BaseView {
        void updateEmergencyCallList(List<EmergencyCallModel> models);
    }
}
