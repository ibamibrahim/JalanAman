package id.aicode.jalanaman.map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import id.aicode.jalanaman.R;
import id.aicode.jalanaman.helper.Helper;
import id.aicode.jalanaman.services.LocalServices;
import id.aicode.jalanaman.services.models.event.EventResponse;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, MapsContract.View {

    private GoogleMap mMap;
    EventResponse eventResponse;
    String eventName;
    double lat;
    double lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.MapTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        getIntentData();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        getSupportActionBar().setTitle(eventName);
        mapFragment.getMapAsync(this);
        LocalServices.isLoggedIn(getApplicationContext());
    }

    private void getIntentData(){
        Intent intent = getIntent();
        try {
            eventName = intent.getStringExtra("name");
            lat = intent.getDoubleExtra("lat", 0.0);
            lang = intent.getDoubleExtra("lang", 0.0);
        } catch (Exception e){
            Helper.createToast(getApplicationContext(), e.getMessage());
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(lat, lang);
        mMap.addMarker(new MarkerOptions().position(sydney).title(eventName));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 14));
    }
}
