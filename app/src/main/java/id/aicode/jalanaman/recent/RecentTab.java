package id.aicode.jalanaman.recent;

/**
 * Created by Ibam on 6/15/2017.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.aicode.jalanaman.R;
import id.aicode.jalanaman.helper.Helper;
import id.aicode.jalanaman.services.models.event.EventResponse;

public class RecentTab extends Fragment implements RecentContract.View {

    @BindView(R.id.report_danger)
    Button mButton;

    @BindView(R.id.recent_recyclerView)
    RecyclerView recyclerView;

    RecentEventAdapter adapter;

    RecentPresenter mPresenter;
    ProgressDialog dialog;

    @Override
    @SuppressWarnings("Deprecation")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_recent, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPresenter = new RecentPresenter();
        mPresenter.setView(this);
        mPresenter.loadRecentDanger(context);
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

    public void loadRecentDangers(List<EventResponse> list) {
        adapter = new RecentEventAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void loadRecentDangersFailed(String message) {
        Helper.createToast(getContext(), "Loading Recent Dangers failed! " + message);
    }

    public void showMaps(String longitude, String latitude) {

    }

    @OnClick(R.id.report_danger)
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
