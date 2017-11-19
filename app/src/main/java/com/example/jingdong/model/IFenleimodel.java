package com.example.jingdong.model;

import com.example.jingdong.bean.Fen_leiBean;

import java.util.List;

import rx.Observer;

/**
 * Created by 李倩 on 2017/11/15.
 */

public interface IFenleimodel {
    public void getfen(Observer observer);
   // public void getfen_lei(String cid,Observer observer);
    void ClassRight(String cid,Right right);
    interface Right{
        void complate(List<Fen_leiBean.DataBean> Rightlist);
    }
}
