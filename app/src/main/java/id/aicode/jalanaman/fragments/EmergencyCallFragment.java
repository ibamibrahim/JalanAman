package id.aicode.jalanaman.fragments;

/**
 * Created by Ibam on 6/15/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.aicode.jalanaman.R;

public class EmergencyCallFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_emergency, container, false);
    }
}
