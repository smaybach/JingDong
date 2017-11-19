package com.example.jingdong.presenter;

import com.example.jingdong.bean.Fen_leiBean;
import com.example.jingdong.bean.FenleiBean;
import com.example.jingdong.model.Fenleimodel;
import com.example.jingdong.model.IFenleimodel;
import com.example.jingdong.view.FenleiView;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import rx.Observer;

/**
 * Created by 李倩 on 2017/11/15.
 */

public class Fenleipresenter implements Ipresenter<FenleiView> {
    FenleiView view;
    IFenleimodel model;
    SoftReference<FenleiView> ss;
    List<Fen_leiBean.DataBean> list=new ArrayList<>();
    public Fenleipresenter(FenleiView view) {
        attch(view);
        model=new Fenleimodel();
    }

    /**
     * 左边
     */
    public void lv_lf(){
        model.getfen(new Observer() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
            ss.get().initData((FenleiBean) o);
            }
        });
    }
    /**
     * 右边
     */
    public void showright(String cid){
        model.ClassRight(cid, new IFenleimodel.Right() {
            @Override
            public void complate(List<Fen_leiBean.DataBean> Rightlist) {
                ss.get().showRight(Rightlist);
            }
        });

    }
    @Override
    public void attch(FenleiView view) {
        ss=new SoftReference<FenleiView>(view);
    }

    @Override
    public void detch() {
     ss.clear();
    }
}
