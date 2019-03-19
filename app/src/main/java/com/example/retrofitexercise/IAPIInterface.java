package com.example.retrofitexercise;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IAPIInterface {

    @GET("posts.json")
    Call<PostModel> getUsers();
}
