package com.example.retrofitexercise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class PostModel {

    @SerializedName("posts")
    @Expose
    private ArrayList<Post> posts = null;

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

}