package com.example.igx.problem1;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.hardware.Sensor.TYPE_ACCELEROMETER;

public class MainActivity extends AppCompatActivity implements SensorEventListener,LocationListener {
    SensorManager sm_1;
    SensorManager sm_2;
    SensorManager sm_3;
    SensorManager sm_4;
    LocationManager lm_1;
    Sensor ss1;
    Sensor ss2;
    Sensor ss3;
    Sensor ss4;
    double latitude, longitude;
    double x,y,z;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm_1 = (SensorManager) getSystemService(SENSOR_SERVICE);
        sm_2 = (SensorManager) getSystemService(SENSOR_SERVICE);
        sm_3 = (SensorManager) getSystemService(SENSOR_SERVICE);
        sm_4 = (SensorManager) getSystemService(SENSOR_SERVICE);

        lm_1=(LocationManager)getSystemService(LOCATION_SERVICE);

        ss1 = sm_1.getDefaultSensor(TYPE_ACCELEROMETER);
        Button btn_getLocation = (Button) findViewById(R.id.btn_getLocation);
        Button btn_getSensors = (Button) findViewById(R.id.btn_getSensors);
        Button btn_sendMessage = (Button) findViewById(R.id.btn_sendMessage);

        final TextView text_selectedData = (TextView) findViewById(R.id.text_selectedData);
        final TextView text_selectedType = (TextView) findViewById(R.id.text_selectedType);
        final EditText edit_phoneNumber = (EditText) findViewById(R.id.edit_phoneNumber);


        btn_getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_selectedType.setText("Location");

                text_selectedData.setText(String.valueOf("위도는 "+latitude)+" 경도는"+ longitude);
            }
        });

        btn_getSensors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_selectedType.setText("Sensors");
                text_selectedData.setText( "X축: "+x+ " Y축: "+y+" z축: " +z);
            }
        });

        btn_sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text_selectedType.getText() == "Location") {
                    String str = edit_phoneNumber.getText().toString();
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "위도는 " + latitude + " 경도는 " + latitude + "입니다.");
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                }
                if(text_selectedType.getText()=="Sensors"){
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "가속 센서 사용"+" X축: "+x+ " Y축: "+y+" z축: " +z);
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                }
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

//    lm_1.requestLocationUpdates(
//            LocationManager.GPS_PROVIDER,
//            0,
//            0,
//            this);
//
//    lm_1.requestLocationUpdates(
//    LocationManager.NETWORK_PROVIDER,
//            0,
//            0,
//            this);

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onStop() {
        super.onStop();


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x=event.values[0];
        y=event.values[1];
        z=event.values[2];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onLocationChanged(Location location) {
        latitude=location.getLatitude();
        longitude=location.getLongitude();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }





}