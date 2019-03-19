package com.example.retrofitexercise;

public interface SuccessAPICallback<T> {

    void onResponse(T t);

}
