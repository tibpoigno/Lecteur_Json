package com.example.thibault.lecteurjson.PointDeCollecte;

import android.util.Log;

import com.example.thibault.lecteurjson.Carte;
import com.example.thibault.lecteurjson.Cartographie.Position;
import com.google.android.gms.maps.GoogleMap;

/**
 * Created by Thibault on 17/05/2016.
 */
public class BacRecyclable extends PointDeCollecte
{
    public BacRecyclable(double latitude, double longitude, boolean _isBuried)
    {
        super(latitude, longitude, _isBuried);
    }

    public void addMarker(Carte mMap)
    {

        Log.d("AJOUT PUSH-PIN JAUNE","Latitude = "+super.position.getLatitude()+" et Longitude = "+super.position.getLongitude());
    }
}
