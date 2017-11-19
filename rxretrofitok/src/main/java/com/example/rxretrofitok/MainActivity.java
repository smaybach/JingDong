package com.example.rxretrofitok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.rxretrofitok.utils.DialogUtils;

/**
 * 1、导入依赖
 * 2、权限
 * 3、封装Retrofit + okHttp
 * 4、写请求接口
 * 5、使用
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RetrofitUtils.doHttpDeal().getData()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<MessageBean>() {
//            @Override
//            public void onCompleted() {
//                Log.i("==========", "onCompleted: ");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.i("==========", "onError: " + e.toString());
//            }
//
//            @Override
//            public void onNext(MessageBean messageBean) {
//                Log.i("==========", "onNext: " + messageBean);
//            }
//        });

        DialogUtils.showUpdataDialog(this);

    }
}
