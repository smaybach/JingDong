package com.example.rxretrofitok.net;

import com.example.rxretrofitok.bean.MessageBean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import rx.Observable;

/**
 * Created by yfeng on 2017/11/16.
 */

public interface RequestApi {
    public static final String BASE_URL = "http://169.254.140.132:8080/";

    @GET("aaa/code.json")
    Observable<MessageBean> getData();

    @Streaming
    @POST("{fileName}")
    Call<ResponseBody> downloadFile(@Path("fileName") String fileName, @Header("Range") String range);

    @Streaming
    @POST("{fileName}")
    Call<ResponseBody> getFileLenght(@Path("fileName") String fileName);
}
