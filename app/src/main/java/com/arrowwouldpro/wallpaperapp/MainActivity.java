package com.arrowwouldpro.wallpaperapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arrowwouldpro.wallpaperapp.databinding.ActivityMainBinding;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ActivityMainBinding binding;

    private RecyclerView recyclerView;
    private List<Custom_Items> list;
    public CustomAdapter adapter;
    private Toolbar toolbar;
    private TextView textView;
    NetworkInfo info;
    ProgressDialog dialog;

//    private AdView mAdView;
    private  Control control;


    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Initialize the binding object
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//                Add request




        control = new Control(this);



        control.loadBannerAd(binding.bannerLayout);

        //end adssss

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        dialog = new ProgressDialog(this);




        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(CONNECTIVITY_SERVICE);
        info = cm.getActiveNetworkInfo();
        if (info != null) {


            Toast.makeText(MainActivity.this, "Loading..", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this, "No Internet Connection!", Toast.LENGTH_LONG).show();

        }

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        list = new ArrayList<>();

        list.add(new Custom_Items("https://wallpapercave.com/wp/wp2301584.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp2301562.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp2301564.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp2301565.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp2301570.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp2301609.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp2301613.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp2301614.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp2301634.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp2301704.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp2301709.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp2301709.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp4469378.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp6080455.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp5460123.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp5176916.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp5139305.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp5586746.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp6280487.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp6280529.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp6280619.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp6280843.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/wp/wp9573330.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/wp/wp8584000.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/wp/wp6420755.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/wp/wp9612668.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/wp/wp7752096.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/wp/wp7751798.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/wp/wp9181633.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp5473706.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp3862253.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp3862253.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp4825218.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp7074284.png"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp7074292.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp4825881.jpg"));
        list.add(new Custom_Items("https://c4.wallpaperflare.com/wallpaper/941/725/228/anime-girls-original-characters-women-red-eyes-covered-face-hd-wallpaper-preview.jpg"));
        list.add(new Custom_Items("https://mcdn.wallpapersafari.com/medium/34/7/f0YktP.jpg"));
        list.add(new Custom_Items("https://mcdn.wallpapersafari.com/medium/14/79/lk5Ag0.jpg"));
        list.add(new Custom_Items("https://mcdn.wallpapersafari.com/medium/51/14/rQyS7p.jpg"));
        list.add(new Custom_Items("https://mcdn.wallpapersafari.com/medium/27/29/y7Y8Vp.jpg"));
        list.add(new Custom_Items("https://mcdn.wallpapersafari.com/medium/78/79/3UZnHg.jpg"));
        list.add(new Custom_Items("https://mcdn.wallpapersafari.com/medium/86/16/l1oVFR.jpg"));
        list.add(new Custom_Items("https://mcdn.wallpapersafari.com/medium/46/77/irWaSo.jpg"));
        list.add(new Custom_Items("https://mcdn.wallpapersafari.com/medium/79/49/zPmSUw.jpg"));
        list.add(new Custom_Items("https://wallpaperaccess.com/full/2309756.png"));
        list.add(new Custom_Items("https://c4.wallpaperflare.com/wallpaper/999/730/463/yellow-fiction-cap-pikachu-detective-hd-wallpaper-preview.jpg"));
        list.add(new Custom_Items("https://wallpaperaccess.com/full/1798379.jpg"));
        list.add(new Custom_Items("https://c4.wallpaperflare.com/wallpaper/778/164/837/poke-balls-digital-art-balls-fantasy-art-wallpaper-preview.jpg"));
        list.add(new Custom_Items("https://c4.wallpaperflare.com/wallpaper/71/805/151/movie-cap-pikachu-poster-pokemon-hd-wallpaper-preview.jpg"));
        list.add(new Custom_Items("https://c4.wallpaperflare.com/wallpaper/708/103/667/pikachu-pokemon-grass-hd-pikachu-pokemon-character-wallpaper-preview.jpg"));
        list.add(new Custom_Items("https://mcdn.wallpapersafari.com/medium/51/10/9A6JeS.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp7907103.jpg"));
        list.add(new Custom_Items("https://wallpapercave.com/dwp1x/wp4659174.jpg"));
        list.add(new Custom_Items("https://th.bing.com/th/id/OIP.r6VlfUVnZES1fgk-3pWRSQHaNK?pid=ImgDet&rs=1"));
        list.add(new Custom_Items("https://c4.wallpaperflare.com/wallpaper/50/688/4/dead-or-alive-1280x1024-anime-hot-anime-hd-art-wallpaper-preview.jpg"));
        list.add(new Custom_Items("https://c4.wallpaperflare.com/wallpaper/764/505/66/baby-groot-4k-hd-superheroes-wallpaper-preview.jpg"));


        list.add(new Custom_Items("https://images.pexels.com/photos/1535162/pexels-photo-1535162.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1156684/pexels-photo-1156684.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://images-na.ssl-images-amazon.com/images/I/81A%2BqqYaYFL._SX355_.jpg"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1366919/pexels-photo-1366919.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1236701/pexels-photo-1236701.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1433052/pexels-photo-1433052.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://wallpapershome.com/images/wallpapers/lake-aurora-1080x1920-4k-hd-wallpaper-florida-night-sky-stars-12771.jpg"));
        list.add(new Custom_Items("https://wallpaperaccess.com/full/1204217.jpg"));
        list.add(new Custom_Items("https://eskipaper.com/images/nature-wallpapers-8.jpg"));
        list.add(new Custom_Items("https://wallpapers.pictures/media/nature-background-wallpaper-20161022222031-1080x1920.jpg"));
        list.add(new Custom_Items("https://img.wallpapersafari.com/tablet/768/1024/72/89/pvoZel.jpg"));
        list.add(new Custom_Items("https://i.pinimg.com/originals/f1/6b/ee/f16beeac4b5355487a3265c3d1b62c65.jpg"));
        list.add(new Custom_Items("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSlUYybSZWe45G7GvR8Kj96DphdOv7lJhaBGQ&usqp=CAU"));
        list.add(new Custom_Items("https://www.lefthudson.com/wp-content/uploads/2019/11/blue-wallpaper-iphone-6-beautiful-70-beautiful-nature-amp-landscape-iphone-6-wallpaper-free-to-download-this-week-of-blue-wallpaper-iphone-6.jpg"));
        list.add(new Custom_Items("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/3e84f3a5-b15a-4a8f-a69f-1df301724560/da1qb0w-9ca9c09c-7059-480f-8272-c96f3c65fe33.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3sicGF0aCI6IlwvZlwvM2U4NGYzYTUtYjE1YS00YThmLWE2OWYtMWRmMzAxNzI0NTYwXC9kYTFxYjB3LTljYTljMDljLTcwNTktNDgwZi04MjcyLWM5NmYzYzY1ZmUzMy5qcGcifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6ZmlsZS5kb3dubG9hZCJdfQ.p-MDB99Sbf34G1xNCks1SK09dqdItIOV8yKckp7d9kU"));
        list.add(new Custom_Items("https://i.pinimg.com/originals/d5/5b/3a/d55b3a0130f2507fc9bf0d977d240304.jpg"));
        list.add(new Custom_Items("https://www.pixelstalk.net/wp-content/uploads/2016/01/Anime-Wallpapers-HD-download-free.jpg"));
        list.add(new Custom_Items(""));

        getdata();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }


    private void getdata() {


        adapter = new CustomAdapter(list, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));

        }
        if (id == R.id.action_exit) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to Exit?");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();

                }
            });
            AlertDialog d = builder.create();
            d.show();

        }

        if (id == R.id.action_search) {

            finish();
            startActivity(getIntent());
            if (info != null) {
                getdata();

            } else {


                Toast.makeText(this, "Internet Not Connected!", Toast.LENGTH_SHORT).show();
            }


        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.wallpaper) {

            getdata();


        } else if (id == R.id.favorites) {

            getdata();

        } else if (id == R.id.Settings) {

            startActivity(new Intent(MainActivity.this, SettingsActivity.class));


        } else if (id == R.id.rate_us) {
            rateme();
        } else if (id == R.id.more_app) {

            MoreApp();


        }


        //Shere


        else if (id == R.id.shere) {


            Intent myintent = new Intent(Intent.ACTION_SEND);
            myintent.setType("text/plan");

            String shereBoday = "Your Boday Here";

            String shereSub = "\"http://play.google.com/store/apps/details?id=com.arrowwould.wallpaper" + getPackageName();
            myintent.putExtra(Intent.EXTRA_SUBJECT, shereBoday);
            myintent.putExtra(Intent.EXTRA_TEXT, shereSub);
            startActivity(Intent.createChooser(myintent, "shere Using"));

        }


        //Exit


        else if (id == R.id.exit) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to Exit?");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();

                }
            });
            AlertDialog d = builder.create();
            d.show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void MoreApp() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://developer?id=com.arrowwould.wallpaper" + "Account Name!")));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/developer?id=com.arrowwould.wallpaper" + "Account Name!")));


        }
    }


    public void rateme() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=com.arrowwould.wallpaper" + "Your Package name!")));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=com.arrowwould.wallpaper" + getPackageName())));
        }
    }


}