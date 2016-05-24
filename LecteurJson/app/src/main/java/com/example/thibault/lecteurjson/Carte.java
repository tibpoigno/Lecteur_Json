package com.example.thibault.lecteurjson;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.thibault.lecteurjson.Cartographie.Position;
import com.example.thibault.lecteurjson.Data.DataBase;
import com.example.thibault.lecteurjson.PointDeCollecte.Drawable;
import com.example.thibault.lecteurjson.PointDeCollecte.PointDeCollecte;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Vector;

public class Carte extends FragmentActivity implements OnMapReadyCallback {

    public GoogleMap mMap;
    private String typeDebac;
    protected DataBase dataBase;
    protected com.example.thibault.lecteurjson.Cartographie.Map map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Bundle bundle = getIntent().getExtras();
        typeDebac = bundle.getString("TYPE");

        Log.d("ATTENTION","Type de bac => "+typeDebac);
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
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        Log.d("CARTE","carte google crée");

        showMap(typeDebac);


        //<gml:lowerCorner>48.181912535553906 -4.984468090787999</gml:lowerCorner>
        //<gml:upperCorner>48.60414124979669 -4.0647557737863833</gml:upperCorner>
        //LatLngBounds BREST = new LatLngBounds(new LatLng(48.60414124979669,-4.0647557737863833),new LatLng(48.181912535553906,-4.984468090787999));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(BREST, 0));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(10));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(48.350480219193969,-4.2535465693346373)));
    }

    public void drawBacs(String type)
    {
        String bdd = getResources().getString(R.string.BDD);
        dataBase = new DataBase(bdd,"brest");
        Log.d("CARTE","bdd crée");
        drawMarkers(dataBase.getBacs(type),type);
    }
    public void showMap(String type)
    {
        drawBacs(type);
    }

    public void addPushPin(String titre, PointDeCollecte pdt)
    {
        //mMap.addMarker(new MarkerOptions().position(new LatLng(position.getLongitude(),position.getLatitude())).title("Marker testing ;) :p"));
    }
    public boolean drawMarkers(Vector<PointDeCollecte> pdts,String type)
    {
        BitmapDescriptor icon;
        if(type.equals("dmr")) icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE);// Bleu
        else {
            if (type.equals("recyclable"))
                icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW);// Jaune
            else
                icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED);// Rouge = indéfini...
            }
        for (PointDeCollecte pdt:pdts)
        {
            Log.d("CARTE : drawMarkers())", "AJOUT PUSH-PIN");
            mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(pdt.getPosition().getLongitude(),pdt.getPosition().getLatitude()))
                                .title(type)
                                .icon(icon));
        }
        Log.d("CARTE : drawMarkers", "OK...");
        return true;
    }
}