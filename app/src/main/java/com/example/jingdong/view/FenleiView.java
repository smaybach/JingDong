package com.example.jingdong.view;

import com.example.jingdong.bean.Fen_leiBean;
import com.example.jingdong.bean.FenleiBean;

import java.util.List;

/**
 * Created by 李倩 on 2017/11/15.
 */

public interface FenleiView {
    public void initData(FenleiBean fenleiBean);
    public void showRight(List<Fen_leiBean.DataBean> list);
//    int cid();
}
