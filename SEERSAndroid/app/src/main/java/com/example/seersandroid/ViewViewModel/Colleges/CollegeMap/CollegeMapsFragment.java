package com.example.seersandroid.ViewViewModel.Colleges.CollegeMap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seersandroid.R;
import com.example.seersandroid.Utilities.Utils;
import com.example.seersandroid.base.BaseFragment;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollegeMapsFragment extends BaseFragment implements OnMapReadyCallback,GoogleMap.OnMapClickListener {
    public static final String TAG = CollegeMapsFragment.class.getSimpleName();

    class LocationPoint{
        double lat;
        double lon;
        String location = "";

        public double getLat() {
            return lat;
        }
        public void setLat(double lat) {
            this.lat = lat;
        }
        public double getLon() {
            return lon;
        }
        public void setLon(double lon) {
            this.lon = lon;
        }
        public String getLocation() {
            return location;
        }
        public void setLocation(String location) {
            this.location = location;
        }
    }

    GoogleMap gMap;
    LocationRequest mLocationRequest;
    LocationPickerCallback mLocationPickerCallback;
    LocationPoint mLocationPoint = new LocationPoint();
    Marker mapMarker;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_college_maps;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mLocationPoint = new LocationPoint();

        Places.initialize(getContext(), getString(R.string.google_maps_key));

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                this.getChildFragmentManager().findFragmentById(R.id.autocomplete_fragment);
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.NAME,
                Place.Field.LAT_LNG,Place.Field.ADDRESS));

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NotNull Place place) {
                Log.i(TAG, "Place: " + place.getName() + ", " + place.getLatLng()
                        +", " + place.getAddress());
                setLocationRequestWithAddress(place.getLatLng().latitude,place.getLatLng().longitude,place.getAddress());
                gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(place.getLatLng(),12.0f));
                mapMarker.setPosition(place.getLatLng());
            }


            @Override
            public void onError(@NotNull Status status) {
                Log.i(TAG, "An error occurred: " + status);
                showMessage(getString(R.string.cannot_find_current_location_text));
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        gMap.setOnMapClickListener(this);
        getLocationServices(getOneTimeMode());
    }

    @Override
    public void onMapClick(LatLng latLng) {
        setLocationRequest(latLng.latitude,latLng.longitude);
        mapMarker.setPosition(latLng);
    }

    public LocationRequest getOneTimeMode() {
        mLocationRequest = LocationRequest.create().setNumUpdates(1)
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setSmallestDisplacement(0);

        return mLocationRequest;
    }

    public void getLocationServices(LocationRequest locationRequest) {
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mLocationPickerCallback = new LocationPickerCallback();
        LocationServices.getFusedLocationProviderClient(getContext())
                .requestLocationUpdates(locationRequest, mLocationPickerCallback, Looper.getMainLooper());
    }

    public class LocationPickerCallback extends LocationCallback {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            Location currentLocation = locationResult.getLastLocation();
            if(currentLocation == null) {
                showMessage(getString(R.string.cannot_find_current_location_text));
                return;
            }
            LatLng currentPlace = new LatLng(currentLocation.getLatitude(),currentLocation.getLongitude());
            gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentPlace,12.0f));
            mapMarker = gMap.addMarker(new MarkerOptions().position(currentPlace));
            setLocationRequest(currentLocation.getLatitude(),currentLocation.getLongitude());
        }
    }

    public void setLocationRequest(double lat,double lon){
        String lastLocationAddress = Utils.getCompleteAddressString(getContext(), (float) lat, (float)lon);
        mLocationPoint.setLat(lat);
        mLocationPoint.setLon(lon);
        mLocationPoint.setLocation(lastLocationAddress);
    }

    public void setLocationRequestWithAddress(double lat, double lon,String address){
        mLocationPoint.setLat(lat);
        mLocationPoint.setLon(lon);
        mLocationPoint.setLocation(address);
    }

/*    public void sendLocationResult(LocationPoint locationPoint) {
        Intent returnIntent = new Intent();
        Bundle b = new Bundle();
        b.putString(Constants.EXTRA_LOCATION_RESULT, locationPoint.location);
        b.putDouble(Constants.EXTRA_LATITUDE_RESULT, locationPoint.lat);
        b.putDouble(Constants.EXTRA_LONGITUDE_RESULT, locationPoint.lon);
        returnIntent.putExtra(Constants.EXTRA_BUNDLE, b);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_with_end_text_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.toolbar_right_item);
        menuItem.setTitle(getString(R.string.done_text));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.toolbar_right_item:
                sendLocationResult(mLocationPoint);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    public void showMessage(String errMsg) {
        Utils.showToast(getContext(),errMsg);
    }
}