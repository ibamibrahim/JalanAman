package id.aicode.jalanaman.report;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.aicode.jalanaman.R;
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
        DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
        Date dateobj = new Date();
        return df.format(dateobj);
    }

    @OnClick(R.id.pick_location)
    public void pickLocation() {

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
}
