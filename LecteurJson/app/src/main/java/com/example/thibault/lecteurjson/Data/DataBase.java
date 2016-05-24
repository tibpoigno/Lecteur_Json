package com.example.thibault.lecteurjson.Data;
import com.example.thibault.lecteurjson.PointDeCollecte.*;

import java.util.*;
// Debug
import android.util.Log;
// Json
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Thibault on 17/05/2016.
 */
public class DataBase
{
    protected JSONArray bdd;

    public DataBase(String _bdd,String ville) // Pour tests seulement...
    {
        loadBdd(_bdd,ville);
    }
    public Vector<PointDeCollecte> getBacs(String type)
    {
        return parseBdd(type);
    }
    protected void loadBdd(String _bdd,String ville)
    {
        if (_bdd.length() != 0) {
            try {
                JSONObject jsonRootObject = new JSONObject(_bdd);
                JSONArray jsonArray = jsonRootObject.getJSONArray("villes");
                bdd = jsonArray.getJSONObject(0).getJSONArray("pdt");
            } catch (JSONException e) {
                Log.d("LOADING", "Faillure !");
                e.printStackTrace();
                // Faire suivre l'exception
            }
        }
    }
    private Vector<PointDeCollecte> parseBdd(String type)
    {
        Vector<PointDeCollecte> bacs=null;
        try
        {
            bacs = new Vector<PointDeCollecte>();
            for(int indexType=0;indexType<bdd.length();indexType++)
            {
                JSONObject var = bdd.getJSONObject(indexType);
                if(var.getString("type").equals(type))
                {
                    Log.d("APPEL : parseBdd()", "Type = " + var.getString("type"));
                    for (int indexBac = 0; indexBac < var.getJSONArray("bacs").length(); indexBac++)
                    {
                        double latitude = var.getJSONArray("bacs").getJSONObject(indexBac).optDouble("latitude");
                        double longitude = var.getJSONArray("bacs").getJSONObject(indexBac).optDouble("longitude");
                        Log.d("BAC N°" + indexBac, "  --> Latitude = " + latitude + " et Longitude = " + longitude);
                        switch (type)
                        {
                            case "recyclable":
                                bacs.addElement(new BacRecyclable(latitude,longitude,false));
                                break;
                            case "dmr":
                                bacs.addElement(new BacDmr(latitude,longitude,false));
                                break;
                            case "verre":
                                bacs.addElement(new BacVerre(latitude,longitude,false));
                                break;
                            default:Log.d("ERREUR : parseBdd()", "PB POUR CREATION OBJET...");
                        }
                    }
                }
                else
                {
                    Log.d("ERREUR : parseBdd()", "Type non pris en charge");
                }
            }
            Log.d("PARSING","ok");
        }
        catch (JSONException e)
        {
            Log.d("PARSING","Faillure !");
            e.printStackTrace();
            // Faire suivre l'exception
        }
        return bacs;
    }
}
