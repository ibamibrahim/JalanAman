package id.aicode.jalanaman.comment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.aicode.jalanaman.R;

/**
 * Created by Ibam on 7/18/2017.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder>{

    Context context;
    List<CommentModel> commentList;

    public CommentAdapter(Context context, List<CommentModel> commentList){
        this.context = context;
        this.commentList = commentList;
    }

    public CommentAdapter(Context c){
        this.context = c;
    }

    public Context getContext(){
        return this.context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_comment, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CommentModel comment = commentList.get(position);

        holder.commentContent.setText(comment.getComment());
        holder.commentPoster.setText(comment.getUsername());
        holder.commentPoster.setText(comment.getTimeStamp());
    }

    public void setDataset(List<CommentModel> dataset){
        this.commentList = dataset;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return commentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.content_comment)
        public TextView commentContent;

        @BindView(R.id.timeposted_comment)
        public TextView commentTime;

        @BindView(R.id.poster_comment)
        public TextView commentPoster;

        public ViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
