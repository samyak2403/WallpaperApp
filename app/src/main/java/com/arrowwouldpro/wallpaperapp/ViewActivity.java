package com.arrowwouldpro.wallpaperapp;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.io.IOException;

public class ViewActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button setBack;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        imageView = findViewById(R.id.viewImage);
        setBack = findViewById(R.id.setBackground);




        Glide.with(this).load(getIntent().getStringExtra("images")).into(imageView);

        setBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBackgroundImage();

            }
        });












    }

    private void setBackgroundImage() {
        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        WallpaperManager manager =  WallpaperManager.getInstance(getApplicationContext());
        try {
            manager.setBitmap(bitmap);
            Toast.makeText(getApplicationContext(), "Set Wallpaper Successfully ", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e)
        {
            Toast.makeText(this, "Wallpaper not load yet!", Toast.LENGTH_SHORT).show();
        }
    }



}
