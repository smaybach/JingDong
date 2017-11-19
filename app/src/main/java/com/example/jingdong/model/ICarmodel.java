package com.example.jingdong.model;

import com.example.jingdong.bean.CarBean;

import java.util.HashMap;

/**
 * Created by 李倩 on 2017/11/17.
 */

public interface ICarmodel {
    public void showcar(HashMap<String,String>map, Car car);
    interface Car {
        public void showCar(CarBean carBean);
    }
}
