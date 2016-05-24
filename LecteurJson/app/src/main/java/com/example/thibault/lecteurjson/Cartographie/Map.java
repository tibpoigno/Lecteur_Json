package com.example.thibault.lecteurjson.Cartographie;

import android.util.Log;

import com.example.thibault.lecteurjson.Carte;
import com.example.thibault.lecteurjson.PointDeCollecte.Drawable;
import com.example.thibault.lecteurjson.PointDeCollecte.PointDeCollecte;
import com.google.android.gms.maps.GoogleMap;


import java.util.Vector;

/**
 * Created by Thibault on 17/05/2016.
 */
public class Map
{
    //GoogleMap googleMap;
    private Vector<PointDeCollecte> pdts;
    public Map()
    {
        initGoogleMap();
        pdts = new Vector<PointDeCollecte>();
    }
    private boolean initGoogleMap()
    {

        return false;
    }
    public boolean showMap()
    {

        return true;
    }
    public boolean drawMarkers(Carte mMap)
    {
        for (Drawable pdt:pdts)
        {
            Log.d("MAP : drawMarkers())", "AJOUT PUSH-PIN");
            pdt.addMarker(mMap);
        }
        return true;
    }
    public boolean addPdt(Vector<PointDeCollecte> _pdts)
    {
        pdts.addAll(_pdts);
        return true;
    }
    public boolean clear()
    {
        pdts.clear();
        return true;
    }
    public void centrer()
    {

    }
    public boolean getIteneraire(Position destination)
    {
        return false;
    }





}
