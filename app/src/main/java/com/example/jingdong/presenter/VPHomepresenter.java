package com.example.jingdong.presenter;


import com.example.jingdong.bean.FenleiBean;
import com.example.jingdong.bean.HomeBean;
import com.example.jingdong.fragment.FragMentHome;
import com.example.jingdong.model.IVphomemodel;
import com.example.jingdong.model.Vphomemodel;
import com.example.jingdong.view.HomeView;

import java.lang.ref.SoftReference;
import java.util.List;

import rx.Observer;

/**
 * Created by 李倩 on 2017/11/14.
 */

public class VPHomepresenter implements Ipresenter<HomeView>{
    HomeView view;
    IVphomemodel model;
    SoftReference<HomeView> softReference;
    public VPHomepresenter(FragMentHome fragMentHome, HomeView view) {
       attch(view);
        model=new Vphomemodel();
    }

    /**
     * viewpage
     */
   public void  showVp(){
       model.vp(new Observer() {
           @Override
           public void onCompleted() {

           }

           @Override
           public void onError(Throwable e) {

           }

           @Override
           public void onNext(Object o) {
               softReference.get().initData((HomeBean) o);
           }
       });
   }
    /**
     * gv
     */
   public void showGv(){
       model.gv(new Observer() {
           @Override
           public void onCompleted() {

           }

           @Override
           public void onError(Throwable e) {

           }

           @Override
           public void onNext(Object o) {
            softReference.get().initshowGridviewf((FenleiBean) o);
           }
       });
   }
    /**
     * 秒杀
     */
   public void showMS(){
      model.Miaosha(new IVphomemodel.Miao() {
          @Override
          public void MAIOSHA(List<HomeBean.MiaoshaBean.ListBeanX> Mlist) {
              softReference.get().showMiaosha(Mlist);
          }
      });
   }
    /**
     * 推荐
     */
   public void showTJ(){

      model.Tuijian(new IVphomemodel.TJ() {
          @Override
          public void Tui(List<HomeBean.TuijianBean.ListBean> list) {
              softReference.get().showTuijian(list);
          }
      });
   }
    /**
     * 绑定
     * @param view
     */
    @Override
    public void attch(HomeView view) {
        softReference=new SoftReference<HomeView>(view);
    }

    /**
     * 解绑
     */
    @Override
    public void detch() {
      softReference.clear();
    }
}
