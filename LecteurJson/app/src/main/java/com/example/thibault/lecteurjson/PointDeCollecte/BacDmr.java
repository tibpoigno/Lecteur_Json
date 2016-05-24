package com.example.thibault.lecteurjson.PointDeCollecte;

import android.util.Log;

import com.example.thibault.lecteurjson.Carte;
import com.example.thibault.lecteurjson.Cartographie.Position;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Thibault on 17/05/2016.
 */
public class BacDmr extends PointDeCollecte
{
    public BacDmr(double latitude, double longitude, boolean _isBuried)
    {
        super(latitude, longitude, _isBuried);
    }

    public void addMarker(Carte mMap)
    {
        //mMap.addPushPin("BAC DMR des familles !!!", super.position);
        Log.d("AJOUT PUSH-PIN VIOLET","Latitude = "+super.position.getLatitude()+" et Longitude = "+super.position.getLongitude());
    }
}
