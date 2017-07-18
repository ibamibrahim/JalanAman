package id.aicode.jalanaman.comment;

import org.w3c.dom.Comment;

import id.aicode.jalanaman.BaseModel;
import id.aicode.jalanaman.BaseView;

/**
 * Created by Ibam on 7/16/2017.
 */

public class CommentActivityPresenter implements CommentContract.Presenter {

    CommentContract.View mView;

    @Override
    public void setView(BaseView view) {
        this.mView = (CommentContract.View) view;
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

    @Override
    public void postComment(String s) {

    }

    public void getCommentList(){

    }
}
