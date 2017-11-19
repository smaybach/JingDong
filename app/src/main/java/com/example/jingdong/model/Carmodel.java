package com.example.jingdong.model;

import com.example.jingdong.api.HomeAPT;
import com.example.jingdong.bean.CarBean;

import java.util.HashMap;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 李倩 on 2017/11/17.
 */

public class Carmodel implements ICarmodel{


    @Override
    public void showcar(HashMap<String, String> map, final Car car) {
        HomeAPT.RETRO_API.getcar(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CarBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CarBean carBean) {
                        car.showCar(carBean);
                    }
                });
    }
}
