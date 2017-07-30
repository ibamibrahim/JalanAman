package id.aicode.jalanaman.myplace;

/**
 * Created by Ibam on 6/15/2017.
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import butterknife.BindBitmap;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.aicode.jalanaman.R;
import id.aicode.jalanaman.addplace.AddPlaceActivity;
import id.aicode.jalanaman.helper.Helper;
import id.aicode.jalanaman.homepage.MainActivity;
import id.aicode.jalanaman.services.models.login.Place;
import id.aicode.jalanaman.services.models.place.PlaceResponse;

public class MyPlaceTab extends Fragment implements MyPlaceContract.View {

    @BindView(R.id.add_place)
    Button mButton;

    @BindView(R.id.saved_recyclerView)
    RecyclerView recyclerView;

    MyPlacePresenter presenter;
    MyPlaceAdapter adapter;

    ProgressDialog dialog;

    private final String TAG = "MyPlaceTab";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_my_place, container, false);
        ButterKnife.bind(this, view);
        initPresenter();
        initIntentData();

        return view;
    }

    void initIntentData() {
        Gson gson = new Gson();
        String json = getActivity().getIntent().getStringExtra("placeJson");
/*

        try {
            Log.d(TAG, json);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
*/

        TypeToken<List<Place>> token = new TypeToken<List<Place>>() {
        };

        /**
         * jika intentnya kosong, langsung otomatis ambil dari server aja place nya
         */

        if (json != null) {
            List<PlaceResponse> placeList = gson.fromJson(json, token.getType());
            showSavedItems(placeList);
        } else {
            getSavedItems();
        }
    }

    void initPresenter() {
        presenter = new MyPlacePresenter();
        presenter.setView(this);
    }

    /**
     * for the first time load, using data from intent
     **/
    public void showSavedItems(List<PlaceResponse> list) {

        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        /**
         * TODO: Opsional, implement biar dia ga refresh mulu (check list sebeleumnya)
         */
        if (adapter == null || !adapter.getDataSet().equals(list)) {
            adapter = new MyPlaceAdapter(getActivity(), list);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }

    }

    /**
     * get saved place from remote periodically
     */
    public void getSavedItems() {
        if (getUserVisibleHint()) {
            dialog = Helper.showProgressDialog(getContext(), "Getting your saved places..");
            dialog.show();
        }

        presenter.getSavedItems(getContext());
    }

    @OnClick(R.id.add_place)
    public void showAddNewDialog() {
        Intent intent = new Intent(getContext(), AddPlaceActivity.class);
        startActivity(intent);
    }

    public void failedLoadPlaces(String message) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }
        Helper.createToast(getContext(), "Failed to load " + message);
    }
}
