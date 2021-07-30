package com.example.travelAnkara.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.travelAnkara.Model.CardViewObject;
import com.example.travelAnkara.R;
import com.example.travelAnkara.databinding.ActivityDetailsBinding;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;
    TextView mekanAciklama, mekanIlce, mekanAdres;
    ImageView detailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CardViewObject cardViewObject = (CardViewObject) getIntent().getSerializableExtra("mekan");
        CollapsingToolbarLayout collapsingToolbarLayout;



        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse(cardViewObject.getMekanAdresLink());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }

            }
        });



        mekanAciklama = findViewById(R.id.TvMekanAciklama);
        mekanIlce = findViewById(R.id.TvMekanIlce);
        mekanAdres = findViewById(R.id.TvMekanAdres);
        mekanAciklama.setText(cardViewObject.getMekanAciklama());
        mekanIlce.setText(cardViewObject.getMekanIlce());
        mekanAdres.setText(cardViewObject.getAdres());
        collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle(cardViewObject.getMekanAdi());
        detailImage = findViewById(R.id.IvDetailImage);
        Glide.with(DetailsActivity.this).load(cardViewObject.getResimLink()).into(detailImage);



    }
}