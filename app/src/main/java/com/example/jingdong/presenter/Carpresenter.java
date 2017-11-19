package com.example.jingdong.presenter;

import android.content.Context;
import android.util.Log;

import com.example.jingdong.bean.CarBean;
import com.example.jingdong.model.Carmodel;
import com.example.jingdong.model.ICarmodel;
import com.example.jingdong.view.ICarview;

import java.lang.ref.SoftReference;
import java.util.HashMap;

/**
 * Created by 李倩 on 2017/11/17.
 */

public class Carpresenter implements Ipresenter<ICarview> {
    SoftReference<ICarview>ss;
    ICarmodel model;
    Context context;

    public Carpresenter(ICarview view, Context context) {
      attch(view);
        this.context = context;
        model= new Carmodel();
    }
    public void showCAR(){
        HashMap<String,String> map=new HashMap<>();
        map.put("uid","2476");
        map.put("token","B4878262E2D6BB6B4E23A0D83987C99C");
        model.showcar(map, new ICarmodel.Car() {
        @Override
        public void showCar(CarBean carBean) {
            Log.i("----showcar-------", "showCar: "+carBean);
            ss.get().showcar(carBean);
        }
    });
    }
    @Override
    public void attch(ICarview view) {
        ss=new SoftReference<ICarview>(view);
    }

    @Override
    public void detch() {
        ss.clear();

    }
}
