package com.example.googlemapexample;

import static android.os.Build.VERSION_CODES.N;

import android.app.Activity;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

import java.io.IOException;
import java.util.ArrayList;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap mMap;

    public MapsActivity() {

    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                                         .findFragmentById(R.id.map);

        assert mapFragment != null;
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        LatLng delhi_latLng = new LatLng(28.3636 ,77.1348);

        MarkerOptions markerOptions = new MarkerOptions().position(delhi_latLng).title("Delhi");
        mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(delhi_latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(delhi_latLng,16f));

//        // cIRCLE
//        mMap.addCircle(new CircleOptions()
//                .center(delhi_latLng)
//                .radius(1000)
//                .fillColor(Color.GREEN)
//                .strokeColor(Color.BLACK));
//
//        //polygon
//
//        mMap.addPolygon(new PolygonOptions().add(new LatLng(28.3636 ,77.1348),
//                 new LatLng(28.3636 ,74.1348),
//                 new LatLng(27.3636 ,77.1348),
//                 new LatLng(26.3636 ,77.1348),
//                 new LatLng(28.3636 ,77.1348)).fillColor(Color.YELLOW).strokeColor(Color.BLUE));
//
//        //image overlay
//        mMap.addGroundOverlay(new GroundOverlayOptions()
//                .position(delhi_latLng,1000f,1000f)
//                .image(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher_foreground))
//                .clickable(true));

        // geocoder

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                mMap.addMarker(new MarkerOptions().position(latLng).title("Add"));

                Geocoder geocoder = new Geocoder(MapsActivity.this);
                try {
                    ArrayList<Address> arrAdr= (ArrayList<Address>) geocoder.getFromLocation(26.2334,27.4323,1);
                    assert arrAdr != null;
                    Log.d("Address",arrAdr.get(0).getAddressLine(0));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });

    }
}
