package com.example.thibault.lecteurjson.PointDeCollecte;
import com.example.thibault.lecteurjson.Cartographie.Position;

/**
 * Created by Thibault on 17/05/2016.
 */

public abstract class PointDeCollecte implements Drawable
{
    protected boolean isBuried;
    protected Position position;

    public PointDeCollecte(double latitude, double longitude, boolean _isBuried)
    {
        position = new Position(latitude,longitude);
        isBuried=_isBuried;
    }
    public double getDistance(PointDeCollecte pdt)
    {
        return pdt.getPosition().getRadius(position);
    }
    public Position getPosition()
    {
        return position;
    }
}

