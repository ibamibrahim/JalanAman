package id.aicode.jalanaman.emergency;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import id.aicode.jalanaman.BaseModel;
import id.aicode.jalanaman.BaseView;
import id.aicode.jalanaman.R;

/**
 * Created by Ibam on 7/16/2017.
 */

public class EmergencyCallActivityPresenter implements EmergencyContract.Presenter {

    EmergencyContract.View mView;
    @Override
    public void setView(BaseView view) {
        this.mView = (EmergencyContract.View) view;
    }

    @Override
    public void unsetView() {
        this.mView = null;
    }

    @Override
    public void setModel(BaseModel model) {

    }

    @Override
    public void unsetModel() {

    }

    public void loadNumbers(Context context){
        List<EmergencyCallModel> emergencyCallList = new ArrayList<>();
        EmergencyCallModel model;

        String[] nameList = context.getResources().getStringArray(R.array.emergency_name);
        String[] numberList = context.getResources().getStringArray(R.array.emergency_number);
        int[] imageList = getImages(context);

        for(int i = 0; i < numberList.length; i++){
            model = new EmergencyCallModel();
            model.setEmergencyname(nameList[i]);
            model.setEmergencyNumber(numberList[i]);
            model.setIntImage(imageList[i]);
            emergencyCallList.add(model);
        }

        mView.updateEmergencyCallList(emergencyCallList);
        Log.d("EMERGENCY", "update data " + emergencyCallList.size());
    }

    public int[] getImages(Context context){
        int[] result = new int[5];
        result[0] = R.drawable.emer_polis;
        result[1] = R.drawable.emer_damkar;
        result[2] = R.drawable.emer_sar;
        result[3] = R.drawable.emer_ambulans;
        result[4] = R.drawable.emer_sos;

        return result;
    }
}
