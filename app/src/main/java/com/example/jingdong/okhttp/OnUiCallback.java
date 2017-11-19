package com.example.jingdong.okhttp;

import android.os.Handler;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 作用：
 * 作者：李倩 on 2017/10/14 14:19
 */
public abstract class OnUiCallback implements Callback{
    private Handler handler=OKHttpUtils.getInstance().getHandler();
    public  abstract  void  onFailed(Call call, IOException e);
    public  abstract  void  onsuccess(String result)throws  IOException;
    @Override
    public void onFailure(final Call call, final IOException e) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                onFailed(call,e);
            }
        });
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        final String result=response.body().string();
        handler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    onsuccess(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
