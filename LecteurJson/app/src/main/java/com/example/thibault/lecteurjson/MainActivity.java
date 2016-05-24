package com.example.thibault.lecteurjson;
import com.example.thibault.lecteurjson.Cartographie.Map;
import com.example.thibault.lecteurjson.Data.DataBase;
import com.example.thibault.lecteurjson.PointDeCollecte.*;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
// DEBUG
import android.util.Log;
import android.view.View;
import android.widget.Button;
// LISTES
import java.util.Vector;

public class MainActivity extends AppCompatActivity
{

    //protected DataBase dataBase;
    //protected Map map;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String bdd = getResources().getString(R.string.BDD);

        //dataBase = new DataBase(bdd,"brest");
        //map = new Map();


        Button btnDMR = (Button) findViewById(R.id.buttonDMR);
        btnDMR.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                showMap("dmr");
            }
        });
        Button btnRECYCLABLE = (Button) findViewById(R.id.buttonRECYCLABLE);
        btnRECYCLABLE.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                showMap("recyclable");
            }
        });

    }
    private void  showDMR(View v)
    {
        showMap("dmr");
    }
    private void  showRECYCLABLE(View v)
    {
        showMap("recyclable");
    }
    public void showMap(String type)
    {
        //drawBacs("dmr");
        Intent intent = new Intent(MainActivity.this, com.example.thibault.lecteurjson.Carte.class);

        Bundle bundle = new Bundle();
        bundle.putString("TYPE",type);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
