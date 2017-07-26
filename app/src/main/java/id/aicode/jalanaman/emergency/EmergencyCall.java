package id.aicode.jalanaman.emergency;

/**
 * Created by Ibam on 6/15/2017.
 */

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.aicode.jalanaman.R;
import id.aicode.jalanaman.helper.Helper;

public class EmergencyCall extends Fragment implements EmergencyContract.View {

    @BindView(R.id.emergency_recyclerview)
    RecyclerView recyclerView;

    @BindView(R.id.logout_button)
    Button mButton;

    EmergencyCallActivityPresenter presenter;
    LinearLayoutManager layoutManager;
    EmergencyCallAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_emergency, container, false);
        ButterKnife.bind(this, view);

        initPresenter();
        initRecyclerView();

        presenter.loadNumbers(getContext());

        return view;
    }

    @OnClick(R.id.logout_button)
    public void logOut() {
        ProgressDialog dialog = Helper.showProgressDialog(getContext(), "Loading..");
        dialog.show();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                presenter.logOut(getContext());
            }
        }, 2000);
    }

    public void initPresenter() {
        presenter = new EmergencyCallActivityPresenter();
        presenter.setView(this);
    }

    public void initRecyclerView() {
        adapter = new EmergencyCallAdapter(getContext());
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void updateEmergencyCallList(List<EmergencyCallModel> models) {
        adapter.setDataSet(models);
        adapter.notifyDataSetChanged();
    }
}
