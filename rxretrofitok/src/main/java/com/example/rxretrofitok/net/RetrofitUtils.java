package com.example.rxretrofitok.net;

import com.example.rxretrofitok.MyInterceptro;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yfeng on 2017/11/16.
 */

public class RetrofitUtils {
    public static RequestApi doHttpDeal(){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
//                .addNetworkInterceptor(new MyInterceptro())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(RequestApi.BASE_URL)
                .build();

        RequestApi api = retrofit.create(RequestApi.class);

        return api;
    }

    public static RequestApi download(){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .addNetworkInterceptor(new MyInterceptro())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("http://10.0.2.2:8080/aaa/")
                .build();

        RequestApi api = retrofit.create(RequestApi.class);

        return api;
    }

}
