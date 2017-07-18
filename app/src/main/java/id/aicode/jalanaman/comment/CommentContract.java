package id.aicode.jalanaman.comment;

import java.util.List;

import id.aicode.jalanaman.BasePresenter;
import id.aicode.jalanaman.BaseView;

/**
 * Created by Ibam on 7/16/2017.
 */

public interface CommentContract {
    interface Presenter extends BasePresenter {
        void postComment(String s);
    }
    interface View extends BaseView {
        void postComment(String s);
        void commentFailed();
        void updateCommentList(List<CommentModel> commentModelList);
    }
}
