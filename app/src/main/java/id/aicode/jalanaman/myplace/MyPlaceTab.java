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
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;


import butterknife.BindBitmap;
import butterknife.BindView;
import butterknife.ButterKnife;
import id.aicode.jalanaman.R;
import id.aicode.jalanaman.homepage.MainActivity;

public class MyPlaceTab extends Fragment {

    @BindView(R.id.add_place)
    FloatingActionButton floatingActionButton;

    @BindView(R.id.test_notif)
    ImageView testNotif;


    @BindBitmap(R.drawable.kebakaran)
    Bitmap icon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_my_place, container, false);
        ButterKnife.bind(this, view);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
                final View dialogView = getActivity().getLayoutInflater().inflate(R.layout
                                .dialog_add_route,
                        null);
                View selectRoute = (View) dialogView.findViewById(R.id.item_select_route);
                selectRoute.setVisibility(View.INVISIBLE);
                RadioGroup radioGroup = (RadioGroup) dialogView.findViewById(R.id.radio_group);
                radioGroup.setOnCheckedChangeListener (onCheckedChangeListener(dialogView));
            dialogBuilder.setView(dialogView);
            final AlertDialog dialog = dialogBuilder.create();
            dialog.show();
        }
    }

    );

    testNotif.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){

// Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(getActivity(), MainActivity.class);

// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(getActivity());
// Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(MainActivity.class);
// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat
                .BigPictureStyle();
        bigPictureStyle.bigPicture(icon);
        bigPictureStyle.setBigContentTitle("Kebakaran di RSUD Tangerang");
        bigPictureStyle.bigLargeIcon(icon);
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(getActivity())
                        .setSmallIcon(R.drawable.danger)
                        .setLargeIcon(icon)
                        .setContentTitle("Kebakaran di RSUD Tangerang")
                        .setContentText("Swipe untuk melihat")
                        .setColor(Color.WHITE)
                        .setStyle(bigPictureStyle);
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getActivity().getSystemService(Context
                        .NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(1, mBuilder.build());
    }
    }

    );

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

}
