package id.aicode.jalanaman.comment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import butterknife.BindView;
import id.aicode.jalanaman.R;
import id.aicode.jalanaman.helper.Helper;

public class CommentActivity extends AppCompatActivity implements CommentContract.View, View.OnClickListener {

    @BindView(R.id.comment_recyclerview)
    RecyclerView recyclerView;

    @BindView(R.id.comment_post)
    Button mButton;

    @BindView(R.id.comment_input)
    EditText inputComment;

    CommentActivityPresenter presenter;
    LinearLayoutManager mLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        mButton.setOnClickListener(this);
        initPresenter();
        initRecyclerView();

        presenter.getCommentList();
    }

    private void initRecyclerView() {
        mLinear = new LinearLayoutManager(this);
        recyclerView = new RecyclerView(this);
        recyclerView.setLayoutManager(mLinear);
    }

    private void initPresenter() {
        presenter = new CommentActivityPresenter();
        presenter.setView(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.comment_post:
                String userComment = inputComment.getText().toString();
                postComment(userComment);
        }
    }

    public void postComment(String userComment) {
        presenter.postComment(userComment);
    }

    public void updateCommentList(List<CommentModel> comments) {
        CommentAdapter adapter = new CommentAdapter(this);
        adapter.setDataset(comments);

        recyclerView.setAdapter(adapter);
    }

    public void commentFailed() {
        Helper.createToast(this, "Comment gagal di posting!");
    }
}
