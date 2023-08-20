package com.arrowwouldpro.wallpaperapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ImageViewHolder> {
    List<Custom_Items> list;
    Context context;


    public CustomAdapter(List<Custom_Items> list, Context context) {
        this.list = list;
        this.context = context;


    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.custom_image,parent,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        Glide.with(context).load(list.get(position).getImages()).into(holder.imageview);
            }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageview;
        public ImageViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageview = itemView.findViewById(R.id.imageview);

        }

        @Override
        public void onClick(View v) {
                Intent intent = new Intent(context, ViewActivity.class);
                intent.putExtra("images", list.get(getAdapterPosition()).getImages());
                context.startActivity(intent);

        }
    }

}
