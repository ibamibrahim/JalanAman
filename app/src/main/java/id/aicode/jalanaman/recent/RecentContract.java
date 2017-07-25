package id.aicode.jalanaman.recent;

import id.aicode.jalanaman.BasePresenter;
import id.aicode.jalanaman.BaseView;

/**
 * Created by Ibam on 7/16/2017.
 */

public class RecentContract {
    interface Presenter extends BasePresenter {}
    interface View extends BaseView {
        void showPhoto(String id);
        void showComment(String commentId);
        void showMaps(String longitude, String lantitude);
        void reportDanger();
    }
}
