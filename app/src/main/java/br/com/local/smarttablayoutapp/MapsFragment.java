package br.com.local.smarttablayoutapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.animation.ImageMatrixProperty;

public class MapsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        private GoogleMap mMap;

        @Override
        public void onMapReady(GoogleMap googleMap) {

            mMap = googleMap;
            final LatLng Parque = new LatLng(-23.587963, -46.659491);

            CircleOptions circleOptions = new CircleOptions();
            circleOptions.center(Parque);
            circleOptions.fillColor(Color.argb(50, 0, 100, 0));
            circleOptions.strokeWidth(10);
            circleOptions.strokeColor(Color.GREEN);

            circleOptions.radius(950.0);

            mMap.addCircle(circleOptions);

            mMap.addMarker(new MarkerOptions()
                .position(Parque)
                .title("Parque Ibirapuera")
                .icon(
                        BitmapDescriptorFactory.fromResource(R.drawable.park)
                )
            );
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Parque, 13));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}