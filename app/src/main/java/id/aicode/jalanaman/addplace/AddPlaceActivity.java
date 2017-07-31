package id.aicode.jalanaman.addplace;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.aicode.jalanaman.R;
import id.aicode.jalanaman.helper.Helper;
import id.aicode.jalanaman.services.LocalServices;
import id.aicode.jalanaman.services.models.NewPlaceData;

public class AddPlaceActivity extends AppCompatActivity implements AddPlaceContract.View {

    @BindView(R.id.text_add_name)
    EditText placeName;

    @BindView(R.id.selected_location)
    EditText selectedLocation;

    @BindView(R.id.open_maps_new)
    Button openMapsButton;

    @BindView(R.id.save_place)
    Button savePlaceButton;

    @BindView(R.id.back_button_place)
    TextView backButton;

    double latitude;
    double langitude;
    String realName;

    AddPlacePresenter presenter;
    private int PLACE_PICKER_REQUEST = 1;

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_add_route);
        ButterKnife.bind(this);

        initPresenter();
    }

    private void initPresenter() {
        presenter = new AddPlacePresenter();
        presenter.setView(this);
    }

    @OnClick(R.id.save_place)
    public void savePlace() {

        dialog = Helper.showProgressDialog(getApplicationContext(), "Loading..");
        dialog.show();

        if (placeName.getText().toString().equals("") || selectedLocation.getText().toString()
                .equals("")) {
            Helper.createToast(getApplicationContext(), "Please fill all fields!");
        } else {
            String name = placeName.getText().toString();
            String type = "L";
            double longitude = langitude;
            double latitudes = latitude;
            String created_at = getTime();
            NewPlaceData data = new NewPlaceData(created_at, name, type, latitudes, longitude, 0,
                    0);
            presenter.savePlace(getApplicationContext(), data);
        }
    }

    private String getTime() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date dateobj = new Date();
        return df.format(dateobj);
    }

    @OnClick(R.id.back_button_place)
    public void back() {
        finish();
    }

    @OnClick(R.id.selected_location)
    public void pickLocation2() {
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        try {
            //menjalankan place picker
            startActivityForResult(builder.build(AddPlaceActivity.this), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.open_maps_new)
    public void pickLocation() {
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        try {
            //menjalankan place picker
            startActivityForResult(builder.build(AddPlaceActivity.this), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void succesful() {
        dialog.dismiss();
        finish();
    }

    @Override
    public void failed(String message) {
        dialog.dismiss();
        Helper.createToast(getApplicationContext(), message);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // menangkap hasil balikan dari Place Picker, dan menampilkannya pada TextView
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                String toastMsg = String.format(
                        "Place: %s \n" +
                                "Alamat: %s \n" +
                                "Latlng %s \n", place.getName(), place.getAddress(), place.getLatLng().latitude + " " + place.getLatLng().longitude);
                langitude = roundingToNineDigits(place.getLatLng().longitude);
                latitude = roundingToNineDigits(place.getLatLng().latitude);
                realName = place.getAddress().toString();
                selectedLocation.setText(realName);
                //Helper.createToast(getApplicationContext(), toastMsg);
            }
        }
    }

    private double roundingToNineDigits(double number){
        DecimalFormat df = new DecimalFormat("#.######");
        df.setRoundingMode(RoundingMode.CEILING);
        return Double.parseDouble(df.format(number));
    }
}
