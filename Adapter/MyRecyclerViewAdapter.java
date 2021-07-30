package com.example.travelAnkara.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.travelAnkara.Model.CardViewObject;
import com.example.travelAnkara.R;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends
        RecyclerView.Adapter<MyRecyclerViewAdapter.DataObjectHolder> {

    private static String LOG_TAG = "MyRecyclerViewAdapter";
    Object setOnItemClickListener;
    private ArrayList<CardViewObject> mDataset;
    private static MyClickListener myClickListener;
     private static Context context;
    public static class
    DataObjectHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener{

        ImageView ivMekanResim;
        TextView tvMekanAdi;
        ImageView detailImage;

        public DataObjectHolder(View itemView) {
            super(itemView);
            //detailImage = itemView.findViewById(R.id.detailImage);
            ivMekanResim = itemView.findViewById(R.id.ivMekanResim);
            tvMekanAdi = itemView.findViewById(R.id.tvMekanAdi);

            Log.d(LOG_TAG,"Listener ekleniyor");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(),v);

        }



    }


    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MyRecyclerViewAdapter(ArrayList<CardViewObject> mDataset) {

        this.mDataset = mDataset;
    }




    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_gorunumu,parent,false);
        //View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_details,parent,false);

        this.context = parent.getContext();

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        //DataObjectHolder dataObjectHolder1 = new DataObjectHolder(view1);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        int id = context.getResources().getIdentifier
                (mDataset.get(position).getMekanResim(),
                        "drawable",context.getPackageName());

        //holder.detailImage.setImageResource(id);
        holder.ivMekanResim.setImageResource(id);
        holder.tvMekanAdi.setText
                (mDataset.get(position).getMekanAdi());
    }

    @Override
    public int getItemCount() {

        return mDataset.size();
    }

    public void addItem(CardViewObject cardViewObject, int index) {
        mDataset.add(index,cardViewObject);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }
   public interface MyClickListener{
        public void onItemClick(int position, View v);
   }

}
