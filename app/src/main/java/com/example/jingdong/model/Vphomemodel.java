package com.example.jingdong.model;


import com.example.jingdong.api.HomeAPT;
import com.example.jingdong.bean.HomeBean;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 李倩 on 2017/11/14.
 */

public class Vphomemodel implements IVphomemodel {
    /**
     * viewpage
     *
     * @param observer
     */
    @Override
    public void vp(Observer observer) {
        HomeAPT.RETRO_API.gethome()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }

    /**
     * grideview
     *
     * @param observer
     */
    @Override
    public void gv(Observer observer) {
        HomeAPT.RETRO_API.getGV()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }

    /**
     * 秒杀
     *
     * @param
     */

    @Override
    public void Miaosha(final Miao miao) {
        HomeAPT.RETRO_API.gethome()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        List<HomeBean.MiaoshaBean.ListBeanX> mlist =homeBean.getMiaosha().getList();
                        miao.MAIOSHA(mlist);
                    }
                });
    }

    /**
     * 推荐
     *
     * @param
     */
    @Override
    public void Tuijian(final TJ tj) {
        HomeAPT.RETRO_API.gethome()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        List<HomeBean.TuijianBean.ListBean> list =homeBean.getTuijian().getList();
                        tj.Tui(list);
                    }
                });

    }
}