package com.nbbhatt.maplocadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class Map extends AppCompatActivity {

    GoogleMap mMap;

    ArrayList<model> data;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Map.this,MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);




        //initialize map fragment
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);

        //Async map
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(final GoogleMap googleMap) {
                //when map is loaded
                mMap = googleMap;

                mMap.setMyLocationEnabled(true);
                mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
                    @Override
                    public void onMyLocationChange(Location location) {

                        LatLng latlng = new LatLng(location.getLatitude(),location.getLongitude());
                        MarkerOptions markerOptions = new MarkerOptions();
                        markerOptions.position(latlng);

                        //Toast.makeText(Map.this,location.getLatitude()+","+location.getLongitude(),Toast.LENGTH_SHORT).show();

                        markerOptions.title("My location");
                        mMap.clear();

                        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latlng,15);
                        mMap.animateCamera(cameraUpdate);
                        mMap.addMarker(markerOptions);

                        Bundle bundleObject = getIntent().getExtras();
                        data = (ArrayList<model>) bundleObject.getSerializable("LatLongData");

                        for(int i =0;i<data.size();i++){
                            Double lat = Double.parseDouble(data.get(i).getUserLatitude());
                            Double longi = Double.parseDouble(data.get(i).getUserLongitude());

                            String titleName = data.get(i).getName();
                            String titleEmail = data.get(i).getEmail();

                            LatLng  latLang1  = new LatLng(lat,longi);
                            mMap.addMarker(new MarkerOptions().position(latLang1).title(titleName+"("+titleEmail+")"));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLang1));

                        }

                    }
                });
            }
        });



    }




}
