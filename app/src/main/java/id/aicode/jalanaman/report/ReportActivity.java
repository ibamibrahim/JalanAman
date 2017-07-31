package id.aicode.jalanaman.report;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import id.aicode.jalanaman.addplace.AddPlaceActivity;
import id.aicode.jalanaman.helper.Helper;
import id.aicode.jalanaman.services.models.EventData;

public class ReportActivity extends AppCompatActivity implements ReportContract.View {

    @BindView(R.id.event_description)
    EditText eventDesc;

    @BindView(R.id.event_location)
    EditText eventLocName;

    @BindView(R.id.pick_location)
    Button pickLocButton;

    @BindView(R.id.post_event)
    Button postEventButton;

    @BindView(R.id.back_button_event)
    TextView backButton;

    ReportPresenter presenter;

    private final int PLACE_PICKER_REQUEST = 1;
    double langitude;
    double latitude;
    String realName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        ButterKnife.bind(this);

        initPresenter();
    }

    private void initPresenter() {
        presenter = new ReportPresenter();
        presenter.setView(this);
    }

    @OnClick(R.id.post_event)
    public void postEvent() {
        if (eventDesc.getText().toString().equals("") || eventLocName.getText().toString().equals("")) {
            Helper.createToast(getApplicationContext(), "All field has to be filled!");
        } else {
            String title = eventDesc.getText().toString();
            String point_lat = "";
            String point_lang = "";
            String time = getTime();
            String created_at = getTime();
            String photo_url = "http://www.jennybeaumont" +
                    ".com/wp-content/uploads/2015/03/placeholder.gif";

            EventData data = new EventData(title, point_lat, point_lang, time, created_at,
                    photo_url);

            presenter.postEvent(getApplicationContext(), data);
        }
    }

    private String getTime() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date dateobj = new Date();
        return df.format(dateobj);
    }

    @OnClick(R.id.pick_location)
    public void pickLocation() {
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        try {
            //menjalankan place picker
            startActivityForResult(builder.build(ReportActivity.this), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.back_button_event)
    public void back() {
        finish();
    }

    @Override
    public void succesfulReport() {
        finish();
    }

    @Override
    public void failedReport(String message) {
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
                eventLocName.setText(realName);
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
