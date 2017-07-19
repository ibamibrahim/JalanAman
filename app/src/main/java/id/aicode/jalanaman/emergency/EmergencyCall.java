package id.aicode.jalanaman.emergency;

/**
 * Created by Ibam on 6/15/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.aicode.jalanaman.R;

public class EmergencyCall extends Fragment implements EmergencyContract.View {

    @BindView(R.id.emergency_recyclerview)
    RecyclerView recyclerView;

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

    public void initPresenter(){
        presenter = new EmergencyCallActivityPresenter();
        presenter.setView(this);
    }

    public void initRecyclerView(){
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
