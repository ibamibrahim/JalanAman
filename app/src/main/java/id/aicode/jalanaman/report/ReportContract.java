package id.aicode.jalanaman.report;

import android.content.Context;

import java.util.List;

import id.aicode.jalanaman.BasePresenter;
import id.aicode.jalanaman.BaseView;
import id.aicode.jalanaman.emergency.EmergencyCallModel;
import id.aicode.jalanaman.services.models.EventData;

/**
 * Created by Ibam on 7/16/2017.
 */

public class ReportContract {
    interface Presenter extends BasePresenter {
        void postEvent(Context context, EventData eventData);
    }

    interface View extends BaseView {
        void succesfulReport();
        void failedReport(String message);
    }
}
