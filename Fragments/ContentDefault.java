package com.example.travelAnkara.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelAnkara.Activity.DetailsActivity;
import com.example.travelAnkara.Adapter.MyRecyclerViewAdapter;
import com.example.travelAnkara.Model.CardViewObject;
import com.example.travelAnkara.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ContentDefault extends Fragment {

    String key = null;
    String title = null;
    int layoutId = 0;
    ArrayList<CardViewObject> cardViewObjects;
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;

    public ContentDefault() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void fillContent(String key, String title, int layoutId,
                            ArrayList<CardViewObject> cardViewObjects,
                            RecyclerView mRecyclerView) {
        this.key = key;
        this.title = title;
        this.layoutId = layoutId;
        this.cardViewObjects = cardViewObjects;
        this.mRecyclerView = mRecyclerView;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(layoutId, container, false);


        this.mRecyclerView = view.findViewById(R.id.myRecyclerView);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.mAdapter = new MyRecyclerViewAdapter(cardViewObjects);
        this.mRecyclerView.setAdapter(mAdapter);
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.d("LOG",cardViewObjects.get(position).getMekanAdi());

                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("mekan",cardViewObjects.get(position));
                startActivity(intent);
            }
        });



        return view;
    }




    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(title);
    }


}
