package com.example.jingdong.api;


import com.example.jingdong.bean.CarBean;
import com.example.jingdong.bean.Fen_leiBean;
import com.example.jingdong.bean.FenleiBean;
import com.example.jingdong.bean.HomeBean;
import com.example.jingdong.bean.LogBean;
import com.example.jingdong.bean.RegBean;

import java.util.HashMap;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by Mx丶 on 2017/11/10.
 */

public interface HomeAPT {
    //首页
    @GET(content.BASEURL)
    Observable<HomeBean> gethome();
    //gv
    @GET(content.FEN)
    Observable<FenleiBean> getGV();
    @GET(content.FEN1)
    Observable<Fen_leiBean> getGV1(@Query("cid") String cid);
    //登录
    @POST(content.LOGIN)
    @FormUrlEncoded
    Observable<LogBean> getLogin(@FieldMap HashMap<String,String> map);
    //注册

    @FormUrlEncoded
    @POST(content.REG)
    Observable<RegBean> getreg(@FieldMap HashMap<String, String> map);
    //uid=2476&token=B4878262E2D6BB6B4E23A0D83987C99C
    //查询购物车
    @POST(content.cx)
    @FormUrlEncoded
    Observable<CarBean> getcar(@FieldMap HashMap<String,String> map);
    Retrofit RETROFIT=new Retrofit.Builder()
            .baseUrl(content.MAIN)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    HomeAPT RETRO_API=RETROFIT.create(HomeAPT.class);
}
