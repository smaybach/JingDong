package com.example.jingdong.view;


import com.example.jingdong.bean.FenleiBean;
import com.example.jingdong.bean.HomeBean;

import java.util.List;

/**
 * Created by 李倩 on 2017/11/14.
 */

public interface HomeView {
    public void initData(HomeBean homeBean);
    public  void  initshowGridviewf(FenleiBean fb);
    public void showMiaosha(List<HomeBean.MiaoshaBean.ListBeanX> list);
    public void showTuijian(List<HomeBean.TuijianBean.ListBean> list);
}
