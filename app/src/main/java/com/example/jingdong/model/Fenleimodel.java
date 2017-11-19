package com.example.jingdong.model;

import android.util.Log;

import com.example.jingdong.api.HomeAPT;
import com.example.jingdong.bean.Fen_leiBean;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 李倩 on 2017/11/15.
 */

public class Fenleimodel implements IFenleimodel{
//    List<Fen_leiBean.DataBean> list=new ArrayList<>();
    @Override
    public void getfen(Observer observer) {
        HomeAPT.RETRO_API.getGV()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }

    @Override
    public void ClassRight(String cid, final Right right) {
        HomeAPT.RETRO_API.getGV1(cid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Fen_leiBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("---onError-----", "onError: ");
                    }

                    @Override
                    public void onNext(Fen_leiBean fen_leiBean) {
                        Log.i("----onNext----", "onNext: "+fen_leiBean);
//                        for (int i = 0; i < fen_leiBean.getData().size(); i++) {
//                            list.add(fen_leiBean.getData().get(i));
//                        }
//                        list=fen_leiBean.getData();
                        List<Fen_leiBean.DataBean> list=fen_leiBean.getData();
                        Log.i("--list----", "onNext: "+list.size());
                        right.complate(list);
                    }
                });
    }


}
