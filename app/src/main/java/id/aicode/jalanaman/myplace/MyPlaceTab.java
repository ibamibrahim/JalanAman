package id.aicode.jalanaman.myplace;

/**
 * Created by Ibam on 6/15/2017.
 */

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;


import butterknife.BindBitmap;
import butterknife.BindView;
import butterknife.ButterKnife;
import id.aicode.jalanaman.R;
import id.aicode.jalanaman.homepage.MainActivity;

public class MyPlaceTab extends Fragment implements MyPlaceContract.View {

    @BindView(R.id.add_place)
    Button mButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_my_place, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    private RadioGroup.OnCheckedChangeListener onCheckedChangeListener(final View dialogVIew) {
        RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {
            final View selectPlace = (View) dialogVIew.findViewById(R.id.item_select_place);
            final View selectRoute = (View) dialogVIew.findViewById(R.id.item_select_route);

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_add_location:
                        selectPlace.setVisibility(View.VISIBLE);
                        selectRoute.setVisibility(View.INVISIBLE);
                    case R.id.radio_add_route:
                        selectPlace.setVisibility(View.INVISIBLE);
                        selectRoute.setVisibility(View.VISIBLE);
                }

            }
        };

        return listener;
    }

    public void getSavedItems(){

    }

    public void showSavedItems(){

    }


    public void showAddNewDialog(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        final View dialogView = getActivity().getLayoutInflater().inflate(R.layout
                        .dialog_add_route,
                null);
        View selectRoute = (View) dialogView.findViewById(R.id.item_select_route);
        selectRoute.setVisibility(View.INVISIBLE);
        RadioGroup radioGroup = (RadioGroup) dialogView.findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(onCheckedChangeListener(dialogView));
        dialogBuilder.setView(dialogView);
        final AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }

}
