package com.example.retrofitexercise;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private ArrayList<Post> mPostList;


    public void setRetroAdapter( ArrayList<Post> postList){
        this.mPostList = postList;
    }


    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_card,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder viewHolder, int i) {

        Post post = mPostList.get(i);

        viewHolder.tvMessage.setText(post.getMessage());
        viewHolder.tvName.setText(post.getName());
        Context context = viewHolder.ivProfile.getContext();

        if (context != null) {

            Glide.with(context)
                    .load(post.getProfileImage())
                    .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background))
                    .into(viewHolder.ivProfile);
        }
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivProfile;
        TextView tvName,tvMessage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfile = itemView.findViewById(R.id.iv_profile);
            tvMessage = itemView.findViewById(R.id.tv_message);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
