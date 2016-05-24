package com.example.thibault.lecteurjson.PointDeCollecte;

import android.util.Log;

import com.example.thibault.lecteurjson.Carte;
import com.google.android.gms.maps.GoogleMap;

/**
 * Created by Thibault on 17/05/2016.
 */
public class Dechetterie extends PointDeCollecte
{
    public Dechetterie(double latitude, double longitude, boolean _isBuried)
    {
        super(latitude, longitude, _isBuried);
    }

    public void addMarker(Carte mMap)
    {
        Log.d("AJOUT PUSH-PIN MAIN","Latitude = "+super.position.getLatitude()+" et Longitude = "+super.position.getLongitude());
    }
}
