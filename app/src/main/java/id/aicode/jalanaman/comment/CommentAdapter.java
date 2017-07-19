package id.aicode.jalanaman.comment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.aicode.jalanaman.R;

/**
 * Created by Ibam on 7/18/2017.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    Context context;
    List<CommentModel> commentList;

    public CommentAdapter(Context context, List<CommentModel> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    public CommentAdapter(Context c) {
        this.context = c;
        commentList = new ArrayList<>();
    }

    public Context getContext() {
        return this.context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comment, parent, false);


        return new CommentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CommentModel comment = commentList.get(position);

        holder.commentContent.setText(comment.getComment());
        holder.commentPoster.setText(comment.getUsername());
        holder.commentPoster.setText(comment.getTimeStamp());
    }

    public void setDataset(List<CommentModel> dataset) {
        this.commentList = dataset;
    }

    public void addDataSet(List<CommentModel> dataSet) {
        this.commentList.addAll(dataSet);
        notifyDataSetChanged();
    }

    public void addData(CommentModel data) {
        this.commentList.add(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView commentContent;
        public TextView commentTime;
        public TextView commentPoster;

        public ViewHolder(View view) {
            super(view);
            commentContent = (TextView) view.findViewById(R.id.content_comment);
            commentTime = (TextView) view.findViewById(R.id.timeposted_comment);
            commentPoster = (TextView) view.findViewById(R.id.timeposted_comment);
        }
    }
}
