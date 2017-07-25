package id.aicode.jalanaman.recent;

import id.aicode.jalanaman.BaseModel;
import id.aicode.jalanaman.BaseView;

/**
 * Created by Ibam on 7/16/2017.
 */

public class RecentPresenter implements RecentContract.Presenter {

    private RecentContract.View mView;

    @Override
    public void setView(BaseView view) {
        this.mView = (RecentContract.View) mView;
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
}
