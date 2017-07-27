package id.aicode.jalanaman.recent;

import android.content.Context;

import java.util.List;

import id.aicode.jalanaman.BasePresenter;
import id.aicode.jalanaman.BaseView;
import id.aicode.jalanaman.services.models.event.EventResponse;

/**
 * Created by Ibam on 7/16/2017.
 */

public class RecentContract {
    interface Presenter extends BasePresenter {
        void loadRecentDanger(Context context);
    }
    interface View extends BaseView {
        void showPhoto(String id);
        void showComment(String commentId);
        void reportDanger();
        void loadRecentDangers(List<EventResponse> list);
        void loadRecentDangersFailed(String message);
    }
}
