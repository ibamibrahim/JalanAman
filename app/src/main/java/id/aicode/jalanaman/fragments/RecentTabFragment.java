package id.aicode.jalanaman.fragments;

/**
 * Created by Ibam on 6/15/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.aicode.jalanaman.R;
import id.aicode.jalanaman.activities.CommentActivity;
import id.aicode.jalanaman.activities.MapsActivity;

public class RecentTabFragment extends Fragment {

    @BindView(R.id.maps_button)
    Button show_map;

    @BindView(R.id.gambar)
    ImageView show_photo;

    @BindView(R.id.komen)
    ImageView post_comment;

    @BindView(R.id.report_danger)
    FloatingActionButton fab;

    /**
     * TODO
     * Tambahin:
     * - layout post kejadian baru (dialog biasa)
     * x show photo
     * - layout post comment (bottom sliding up)
     * - direct call
     */

    @Override
    @SuppressWarnings("Deprecation")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_recent, container, false);
        ButterKnife.bind(this, view);

        show_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
            }
        });

        show_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
                final View dialogView = getActivity().getLayoutInflater().inflate(R.layout
                                .dialog_image,
                        null);

                dialogBuilder.setView(dialogView);
                AlertDialog dialog = dialogBuilder.create();
                Window window = dialog.getWindow();
                WindowManager.LayoutParams param = window.getAttributes();
                param.x = 450;
                window.setAttributes(param);
                dialog.show();
            }
        });

        post_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CommentActivity.class);
                startActivity(intent);
            }
        });

        fab.setBackgroundColor(getActivity().getResources().getColor(R.color.red));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
                final View dialogView = getActivity().getLayoutInflater().inflate(R.layout
                                .dialog_report,
                        null);

                dialogBuilder.setView(dialogView);
                AlertDialog dialog = dialogBuilder.create();
                Window window = dialog.getWindow();
                WindowManager.LayoutParams param = window.getAttributes();
                param.x = 450;
                dialog.show();
            }
        });
        return view;
    }
}
