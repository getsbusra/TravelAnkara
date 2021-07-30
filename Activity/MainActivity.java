package com.example.travelAnkara.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.travelAnkara.Adapter.SlideAdapter;
import com.example.travelAnkara.Fragments.ContentDefault;
import com.example.travelAnkara.Model.CardViewObject;
import com.example.travelAnkara.Model.HttpHandler;
import com.example.travelAnkara.R;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbarid;
    ViewPager viewPagerid;
    SlideAdapter slideAdapter;
    ContentDefault contentDefault;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    private ArrayList<CardViewObject> cardViewObjects;
    ProgressDialog progressDialog;
    Fragment fragment = null;
    String diziAdi = "";
    String gTitle = "";
    String gKey = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener((view -> {
            Snackbar.make(view,"Replace with your own action",Snackbar.LENGTH_LONG).setAction("Action",null).show();
        }));*/

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        cardViewObjects = new ArrayList<>();
        //cardViewObjects.add(new CardViewObject(1,"resim","mekanAdi","adres","ilce","aciklama"));

        contentDefault = new ContentDefault();
        contentDefault.fillContent("main","Anasayfa",R.layout.fragment_main,cardViewObjects,mRecyclerView);
        Fragment fragment;
        fragment = contentDefault;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment);

        fragmentTransaction.commit();

        //toolbarid = (Toolbar) findViewById(R.id.toolbar_id);
        //setSupportActionBar(toolbarid);
        viewPagerid = (ViewPager) findViewById(R.id.viewPager_id);
        slideAdapter = new SlideAdapter(this);

        viewPagerid.setAdapter(slideAdapter);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        displaySelectedScreen(item.getItemId());
        return true;
    }

    public void displaySelectedScreen(int id) {

        contentDefault = new ContentDefault();
        cardViewObjects = new ArrayList<>();
        GetJson getJson = new GetJson();

        switch (id) {
           /* case R.id.add_place:
                Intent intent = new Intent(this,MapsActivity.class);
                intent.putExtra("info","new");
                startActivity(intent);
            case R.id.eklenen_yerler:
                Intent intent1 = new Intent(this,EklenenYerler.class);
                startActivity(intent1);*/


            case R.id.muzeler:
                diziAdi = "muzeler";
                gKey= "muze";
                gTitle = "Müzeler";
                getJson.setURL("https://raw.githubusercontent.com/getsbusra/TravelAnkara/main/muzeler.json");
                getJson.setCardViewObjects(cardViewObjects);
                getJson.execute();
                break;


            case R.id.camiler:
                diziAdi = "camiler";
                gKey = "cami";
                gTitle = "Camiler";
                getJson.setURL("https://raw.githubusercontent.com/getsbusra/TravelAnkara/main/camiler.json");
                getJson.setCardViewObjects(cardViewObjects);
                getJson.execute();
                break;

            case R.id.meydanlar:
                diziAdi = "meydanlar";
                gKey = "meydan";
                gTitle = "Meydanlar";
                getJson.setURL("https://raw.githubusercontent.com/getsbusra/TravelAnkara/main/meydanlar.json");
                getJson.setCardViewObjects(cardViewObjects);
                getJson.execute();
                break;

            case R.id.parklar:
                diziAdi = "parklar";
                gKey = "park";
                gTitle = "Park Ve Bahçeler";
                getJson.setURL("https://raw.githubusercontent.com/getsbusra/TravelAnkara/main/parklar.json");
                getJson.setCardViewObjects(cardViewObjects);
                getJson.execute();
                break;

            case R.id.alisverismerkezleri:
                diziAdi = "alisverismerkezleri";
                gKey = "avm";
                gTitle = "Alışveriş Merkezleri";
                getJson.setURL("https://raw.githubusercontent.com/getsbusra/TravelAnkara/main/avm.json");
                getJson.setCardViewObjects(cardViewObjects);
                getJson.execute();
                break;

            case R.id.cafeler:
                diziAdi = "cafeler";
                gKey = "cafe";
                gTitle = "Cafe ve Restaurantlar";
                getJson.setURL("https://raw.githubusercontent.com/getsbusra/TravelAnkara/main/cafeler.json");
                getJson.setCardViewObjects(cardViewObjects);
                getJson.execute();
                break;

            case R.id.sinemalar:
                diziAdi = "sinemalar";
                gKey = "sinema";
                gTitle = "Sinema Salonları";
                getJson.setURL("https://raw.githubusercontent.com/getsbusra/TravelAnkara/main/sinemalar.json");
                getJson.setCardViewObjects(cardViewObjects);
                getJson.execute();
                break;

            case R.id.tiyatrolar:
                diziAdi = "tiyatrolar";
                gKey = "tiyatro";
                gTitle = "Tiyatrolar";
                getJson.setURL("https://raw.githubusercontent.com/getsbusra/TravelAnkara/main/tiyatrolar.json");
                getJson.setCardViewObjects(cardViewObjects);
                getJson.execute();
                break;

            case R.id.konser:
                diziAdi = "konserler";
                gKey = "konser";
                gTitle = "Konser Yerleri";
                getJson.setURL("https://raw.githubusercontent.com/getsbusra/TravelAnkara/main/konserler.json");
                getJson.setCardViewObjects(cardViewObjects);
                getJson.execute();
                break;

            case R.id.eglencemekani:
                diziAdi = "eglencemekani";
                gKey = "eglence";
                gTitle = "Eğlence Mekanları";
                getJson.setURL("https://raw.githubusercontent.com/getsbusra/TravelAnkara/main/eglencemekani.json");
                getJson.setCardViewObjects(cardViewObjects);
                getJson.execute();
                break;


        }

        if(fragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, fragment);
            fragmentTransaction.commit();

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
    public class GetJson extends AsyncTask<Void , Void, Void> {


        ArrayList<CardViewObject> cardViewObjects = new ArrayList<>();

        public void setCardViewObjects(ArrayList<CardViewObject> cardViewObjects) {
            this.cardViewObjects = cardViewObjects;
        }

        private String URL = "";
        ProgressDialog progressDialog;


        public String getURL() {
            return URL;
        }

        public void setURL(String URL) {

            this.URL = URL;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Lütfen Bekleyiniz...");
            progressDialog.setCancelable(false);
            progressDialog.show();

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if(progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }

        @Override
        protected Void doInBackground(Void... params) {
            HttpHandler httpHandler = new HttpHandler();
            String jsonString = httpHandler.makeServiceCall(URL);
            Log.d("RESPONSE",jsonString);

            if(jsonString != null) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    JSONArray mekanlar = jsonObject.getJSONArray(diziAdi);
                    for (int i = 0; i < mekanlar.length(); i++) {
                        JSONObject jsonObject1 = mekanlar.getJSONObject(i);
                        cardViewObjects.add(new CardViewObject(
                                jsonObject1.getInt("mekanId"),
                                jsonObject1.getString("mekanResim"),
                                jsonObject1.getString("mekanAdi"),
                                jsonObject1.getString("mekanAdres"),
                                jsonObject1.getString("mekanIlce"),
                                jsonObject1.getString("mekanAciklama"),
                                jsonObject1.getString("mekanAdresLink"),
                                jsonObject1.getString("resimLink")));
                    }
                    contentDefault.fillContent(gKey,gTitle,R.layout.fragment_main,cardViewObjects,mRecyclerView);
                    fragment = contentDefault;
                }catch (JSONException e) {

                }

            }else {
                Log.d("RESPONSE","Sayfa Kaynağı Boş");

            }
            return null;
        }
    }
}

