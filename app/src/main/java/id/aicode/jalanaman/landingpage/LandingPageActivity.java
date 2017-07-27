package id.aicode.jalanaman.landingpage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import id.aicode.jalanaman.R;

/**
 * Created by Ibam on 7/16/2017.
 */

public class LandingPageActivity extends AppCompatActivity implements LandingPageContract.View  {

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_landing);
    }
}
