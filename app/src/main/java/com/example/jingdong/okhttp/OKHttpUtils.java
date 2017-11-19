package com.example.jingdong.okhttp;

import android.os.Handler;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 作用：
 * 作者：李倩 on 2017/10/14 14:16
 */
public class OKHttpUtils {
    private Handler handler=new Handler();
    public  Handler getHandler(){
        return handler;
    }
    //单例
    private  static  OKHttpUtils okHttpUtils=new OKHttpUtils();
    private OKHttpUtils(){};
    public static OKHttpUtils getInstance(){
        return  okHttpUtils;
    }

    private OkHttpClient client;
    private  void  initOkHttpClient(){
        //实例出来client对象
        if (client==null){
            client=new OkHttpClient.Builder().build();
        }

    }
    //使用工具类，发起网络请求
    public  void  doGet(String url, Callback callback){
        initOkHttpClient();
        Request request=new Request.Builder().url(url).build();
        Call call=client.newCall(request);
        call.enqueue(callback);

    }
	


}
