package com.example.thibault.lecteurjson.PointDeCollecte;

import android.graphics.drawable.Icon;
import android.util.Log;

import com.example.thibault.lecteurjson.Carte;
import com.example.thibault.lecteurjson.Cartographie.Map;
import com.google.android.gms.maps.GoogleMap;

/**
 * Created by Thibault on 17/05/2016.
 */
public class BacBio extends PointDeCollecte
{
    static Icon img;
    public BacBio(double latitude, double longitude, boolean _isBuried)
    {
        super(latitude, longitude, _isBuried);
    }

    public void addMarker(Carte mMap)
    {
        Log.d("AJOUT PUSH-PIN Bio","Latitude = "+super.position.getLatitude()+" et Longitude = "+super.position.getLongitude());
    }
}
