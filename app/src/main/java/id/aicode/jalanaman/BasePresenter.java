package id.aicode.jalanaman;

/**
 * Created by Ibam on 7/17/2017.
 */

public interface BasePresenter {
    void setView(BaseView view);
    void unsetView();
    void setModel(BaseModel model);
    void unsetModel();
}
