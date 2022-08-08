package com.example.booksapp.retrofit;

public class ApiUtility {

    public static ApiInterface getApi(){

        return RetrofitClient.getInstanceWithLogging().create(ApiInterface.class);

    }
}
