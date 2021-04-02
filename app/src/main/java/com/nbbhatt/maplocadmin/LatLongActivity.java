package com.nbbhatt.maplocadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LatLongActivity extends AppCompatActivity {

    TextView latLongText;
    ArrayList<model> data = new ArrayList<model>();
    String mainData = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lat_long);

        latLongText = findViewById(R.id.latLongText);

        /*
        Intent intent = getIntent();
        for(int i= 0; i<MainActivity.toatalElement ;i++){
            model mod = intent.getParcelableExtra("user"+i);
            String lat = mod.getUserLatitude();
            String longi = mod.getUserLongitude();
            mainData = (new StringBuilder()).append(lat).append(",").append(longi).toString();
        }

         */

/*
        model mod = intent.getParcelableExtra("LatLongData");
        String lat  = mod.getUserLatitude();
        String longi = mod.getUserLongitude();
*/

        Bundle bundleObject = getIntent().getExtras();
        data = (ArrayList<model>) bundleObject.getSerializable("LatLongData");

        for(int i =0;i<data.size();i++){
            String lat = data.get(i).getUserLatitude();
            String longi = data.get(i).getUserLongitude();
            mainData = mainData + lat +","+longi+"\n";
            System.out.println(lat+","+longi);
        }

        latLongText.setText(mainData);

    }

}
