package com.example.thibault.lecteurjson.Cartographie;

/**
 * Created by Thibault on 17/05/2016.
 */
public class Position
{
    private double latitude;
    private double longitude;

    public Position(double _latitude, double _longitude)
    {
        latitude =_latitude;
        longitude = _longitude;
    }
    public boolean isIn(Position location, double radius)
    {
        if(getRadius(location)<radius)
            return true;
        else
            return  false;
    }
    public double getRadius(Position point)
    {
        return 0.00; // avec API google
    }
    public double getLatitude(){return latitude;}
    public double getLongitude(){return longitude;}
}
