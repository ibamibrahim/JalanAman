package id.aicode.jalanaman.recent;

/**
 * Created by Ibam on 6/15/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
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
import id.aicode.jalanaman.comment.CommentActivity;
import id.aicode.jalanaman.map.MapsActivity;

public class RecentTab extends Fragment implements RecentContract.View {

    @BindView(R.id.report_danger)
    FloatingActionButton fab;

    @BindView(R.id.recent_recyclerView)
    RecyclerView recyclerView;

    RecentPresenter mPresenter;

    @Override
    @SuppressWarnings("Deprecation")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_recent, container, false);
        ButterKnife.bind(this, view);

        fab.setBackgroundColor(getActivity().getResources().getColor(R.color.red));
        mPresenter = new RecentPresenter();
        mPresenter.setView(this);
        return view;
    }

    public void showPhoto(String id) {
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

    public void showComment(String commentId) {

    }

    public void loadRecentDangers(){

    }

    public void showMaps(String longitude, String latitude) {

    }

    public void reportDanger() {
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
}
