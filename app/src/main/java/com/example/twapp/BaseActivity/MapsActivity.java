package com.example.twapp.BaseActivity;

import androidx.fragment.app.FragmentActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.twapp.OkHttpsSingle;
import com.example.twapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.twapp.databinding.ActivityMapsBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.Timestamp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    OkHttpClient client = OkHttpsSingle.getOkHttp();
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private double longgps,latigps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

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
        class getLocationTask extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... Void) {
                Request request = new Request.Builder()
                        .url("https://g5.minouo.eu.org/Condition/get/2")
                        .build();


                try (Response response = client.newCall(request).execute()) {
                    JSONArray jsonArray = new JSONArray(response.body().string());
                    if (response.code() == 200) {


                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject j =  jsonArray.getJSONObject(i);
                            longgps = Double.parseDouble(j.getString("longgps"));
                            latigps = Double.parseDouble(j.getString("latigps"));

                        }

                    }
                    System.out.println(longgps);
                    System.out.println(latigps);
                    System.out.println(jsonArray);

                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(Void result) {
                LatLng location = new LatLng(latigps,longgps );
                mMap.addMarker(new MarkerOptions().position(location).title("Marker in Elder"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
                mMap.setMinZoomPreference(16.0f);
            }



        }
        new getLocationTask().execute();

        System.out.println(longgps);
        System.out.println(latigps);
        // Add a marker in Sydney and move the camera
    }
}