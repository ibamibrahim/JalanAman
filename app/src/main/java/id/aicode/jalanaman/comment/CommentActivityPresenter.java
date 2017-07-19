package id.aicode.jalanaman.comment;

import android.util.Log;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

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
        List<CommentModel> commentModels = new ArrayList<>();
        CommentModel commentModel;
        for(int i = 0; i < 10; i++){
            commentModel = new CommentModel();
            commentModel.setComment("comment " + i);
            commentModel.setUsername("username " + i);
            commentModel.setTimeStamp("timestamp" + i);
            commentModels.add(commentModel);
        }
        Log.d("COMMENT MODELS SIZE", commentModels.size()+"");
        mView.updateCommentList(commentModels);
    }
}
