package com.example.jingdong.model;

import com.example.jingdong.bean.HomeBean;

import java.util.List;

import rx.Observer;

/**
 * Created by 李倩 on 2017/11/14.
 */

public interface IVphomemodel {
    public void vp(Observer observer);
    public void gv(Observer observer);

    public void Miaosha(Miao miao);
    interface Miao{
        public void MAIOSHA(List<HomeBean.MiaoshaBean.ListBeanX> Mlist);
    }
    public void Tuijian(TJ tj);
     interface TJ{
        public void Tui(List<HomeBean.TuijianBean.ListBean> list);
    }


}
