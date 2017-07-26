package id.aicode.jalanaman.recent;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.plus.model.people.Person;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.aicode.jalanaman.R;
import id.aicode.jalanaman.comment.CommentActivity;
import id.aicode.jalanaman.comment.CommentAdapter;
import id.aicode.jalanaman.helper.Helper;
import id.aicode.jalanaman.services.models.event.EventResponse;

import static id.aicode.jalanaman.R.id.imageView;
import static id.aicode.jalanaman.R.id.url;

/**
 * Created by Ibam on 7/25/2017.
 */

public class RecentEventAdapter extends RecyclerView.Adapter<RecentEventAdapter.ViewHolder> {

    Context context;
    List<EventResponse> eventResponseList;

    public RecentEventAdapter(Context context, List<EventResponse> list) {
        this.context = context;
        this.eventResponseList = list;
    }

    public Context getContext() {
        return this.context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tab_recent, parent, false);

        return new RecentEventAdapter.ViewHolder(view);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onBindViewHolder(ViewHolder holder, int position) {
        EventResponse eventResponse = eventResponseList.get(position);

        holder.eventDescription.setText(eventResponse.getTitle());

        String poster = "@JalanAman";

        holder.eventPoster.setText(poster);
        holder.eventTimestamp.setText(eventResponse.getTime());

        holder.commentCount.setText("View comments");

        Picasso.with(context).load(eventResponse.getPhotoUrl()).into(holder.eventImage);

        holder.eventImage.setOnClickListener(new ClickListener(context, eventResponse.getPhotoUrl()));
        holder.commentCount.setOnClickListener(new ClickListener(context, null));
        holder.iconComment.setOnClickListener(new ClickListener(context, null));
    }

    public void setDataSet(List<EventResponse> list) {
        this.eventResponseList = list;
    }

    public void addDataSet(List<EventResponse> list) {
        this.eventResponseList.addAll(list);
    }

    public void addEvent(EventResponse event) {
        this.eventResponseList.add(event);
    }

    @Override
    public int getItemCount() {
        return eventResponseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.poster_item_recent)
        TextView eventPoster;

        @BindView(R.id.time_item_recent)
        TextView eventTimestamp;

        @BindView(R.id.desc_item_recent)
        TextView eventDescription;

        @BindView(R.id.comment_count_item_recent)
        TextView commentCount;

        @BindView(R.id.gambar)
        ImageView eventImage;

        @BindView(R.id.icon_comment)
        ImageView iconComment;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    private class ClickListener implements View.OnClickListener {

        Drawable drawable;
        Context context;
        String url;

        public ClickListener(Context context, @Nullable String url) {
            this.context = context;
            this.url = url;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.gambar:
                    Helper.showPhoto(context, url);
                    break;
                case R.id.icon_comment:
                case R.id.comment_count_item_recent:
                    Intent intent = new Intent(context, CommentActivity.class);
                    context.startActivity(intent);
                    break;
                default:
                    break;
            }
        }
    }
}
