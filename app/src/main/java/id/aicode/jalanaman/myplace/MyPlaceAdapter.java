package id.aicode.jalanaman.myplace;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.aicode.jalanaman.R;
import id.aicode.jalanaman.recent.RecentEventAdapter;
import id.aicode.jalanaman.services.models.event.EventResponse;
import id.aicode.jalanaman.services.models.login.LoginResponse;
import id.aicode.jalanaman.services.models.login.Place;
import id.aicode.jalanaman.services.models.place.PlaceResponse;

/**
 * Created by Ibam on 7/28/2017.
 */

public class MyPlaceAdapter extends RecyclerView.Adapter<MyPlaceAdapter.ViewHolder> {

    Context context;
    List<PlaceResponse> placeList;

    public MyPlaceAdapter(Context context, List<PlaceResponse> list) {
        this.context = context;
        this.placeList = list;
    }

    public Context getContext() {
        return this.context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tab_my_place, parent, false);

        return new MyPlaceAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PlaceResponse place = placeList.get(position);

        boolean isDanger = false;

        if (isDanger) {
            holder.statusIcon.setImageDrawable(context.getDrawable(R.drawable.danger));
        } else {
            holder.statusIcon.setImageDrawable(context.getDrawable(R.drawable.safe));
        }

        String type;
        if (place.getType().equals("L")) {
            type = "";
        } else {
            type = "Rute ke ";
        }

        holder.placeTitle.setText(type + place.getName());

        holder.placeFrom.setText(place.getPointALat() + ", " + place.getPointALong());
        holder.placeTo.setText(place.getPointBLat() + ", " + place.getPointBLong());

        if (!isDanger) {
            holder.statusText.setBackground(context.getDrawable(R.color.color_safe));
        }

        if (!isDanger) {
            holder.dangerLayout.setVisibility(View.GONE);
        } else {
            holder.dangerLocation.setText("Kebakaran di " + randomString());
            holder.dangerTimestamp.setText("20 years ago");
        }
    }

    private boolean randomBool() {
        Random random = new Random();
        return random.nextBoolean();
    }

    private String randomString() {
        return UUID.randomUUID().toString().substring(0, 5);
    }

    public void setDataSet(List<PlaceResponse> list) {
        this.placeList = list;
    }

    public void addDataSet(List<PlaceResponse> list) {
        this.placeList.addAll(list);
    }

    public void addEvent(PlaceResponse place) {
        this.placeList.add(place);
    }

    public List<PlaceResponse> getDataSet(){
        return this.placeList;
    }
    @Override
    public int getItemCount() {
        return this.placeList.size();
    }

    private class ClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.icon_status_item_myplace)
        ImageView statusIcon;

        @BindView(R.id.title_item_myplace)
        TextView placeTitle;

        @BindView(R.id.placeName1_item_myplace)
        TextView placeFrom;

        @BindView(R.id.placeName2_item_myplace)
        TextView placeTo;

        @BindView(R.id.text_status_item_myplace)
        TextView statusText;

        @BindView(R.id.danger_information_layout_item_myplace)
        LinearLayout dangerLayout;

        @BindView(R.id.event_location_item_myplace)
        TextView dangerLocation;

        @BindView(R.id.event_time_item_myplace)
        TextView dangerTimestamp;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
