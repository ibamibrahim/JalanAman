package id.aicode.jalanaman.emergency;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.aicode.jalanaman.R;
import id.aicode.jalanaman.comment.CommentAdapter;
import id.aicode.jalanaman.comment.CommentModel;

/**
 * Created by Ibam on 7/19/2017.
 */

public class EmergencyCallAdapter extends RecyclerView.Adapter<EmergencyCallAdapter.ViewHolder> {

    Context context;
    List<EmergencyCallModel> dataSet;


    public EmergencyCallAdapter(Context c) {
        this.context = c;
        dataSet = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tab_emergency, parent, false);


        return new EmergencyCallAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        EmergencyCallModel model = dataSet.get(position);

        holder.emergencyName.setText(model.getEmergencyname());
        Log.d("EMERGENCY", model.getEmergencyname());
        holder.emergencyNumber.setText(model.getEmergencyNumber());
        Log.d("EMERGENCY", model.getEmergencyNumber());

        Drawable icon = context.getDrawable(model.getIntImage());
        holder.emergencyIcon.setImageDrawable(icon);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public List<EmergencyCallModel> getDataSet() {
        return dataSet;
    }

    public void setDataSet(List<EmergencyCallModel> dataSet) {
        this.dataSet = dataSet;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name_emergency)
        public TextView emergencyName;

        @BindView(R.id.phone_emergency)
        public TextView emergencyNumber;

        @BindView(R.id.emergency_prof_pic)
        public ImageView emergencyIcon;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
