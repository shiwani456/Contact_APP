package com.application.mycontactapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.application.mycontactapp.R;
import com.application.mycontactapp.interfaces.NextActivity;
import com.application.mycontactapp.models.Contacts;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class DataDisplayClass extends RecyclerView.Adapter<DataDisplayClass.MyViewHolder> {
    private List<Contacts> cont;
    private Context context;
    private NextActivity nextActivity;
    public DataDisplayClass(List<Contacts> items, Context context) {
        this.cont = items;
        this.context = context;
    }


    public void setNextActivity(NextActivity nextActivity) {
        this.nextActivity = nextActivity;
    }

    @NonNull
    @Override
    public DataDisplayClass.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View newsView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dashboard_layout, viewGroup, false);
        return new MyViewHolder(newsView);
    }

    @Override
    public void onBindViewHolder(@NonNull final DataDisplayClass.MyViewHolder myViewHolder, int i) {

        final Contacts data = cont.get(i);
        if (data.getUrl() == null) {
            Glide.with(context)
                    .load(R.drawable.ic_user)
                    .apply(RequestOptions.circleCropTransform())
                    .into(myViewHolder.userPictureImageView);

        } else {
            Glide.with(context)
                    .load(data.getUrl())
                    .apply(RequestOptions.circleCropTransform())
                    .into(myViewHolder.userPictureImageView);
        }

        myViewHolder.userNameTextView.setText(data.getName());
        myViewHolder.userNameTextView.setTag(i);
        myViewHolder.linear_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c = (int) myViewHolder.userNameTextView.getTag();
                Contacts contacts = cont.get(c);
                nextActivity.transferToActivity(contacts.getName(),contacts.getUrl());
            }
        });


    }

    @Override
    public int getItemCount() {
        return cont.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView  userNameTextView;
        ImageView userPictureImageView;
        LinearLayout linear_layout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userNameTextView = itemView.findViewById(R.id.userNameTextView);
            userPictureImageView = itemView.findViewById(R.id.userPictureImageView);
            linear_layout = itemView.findViewById(R.id.linear_layout);
        }
    }
}
