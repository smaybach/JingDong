package com.example.jingdong.presenter;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.jingdong.activity.LogActivity;
import com.example.jingdong.bean.RegBean;
import com.example.jingdong.model.IRegmodel;
import com.example.jingdong.model.Regmodel;
import com.example.jingdong.view.Regview;

import java.lang.ref.SoftReference;
import java.util.HashMap;

/**
 * Created by 李倩 on 2017/11/17.
 */

public class Regpresener implements Ipresenter<Regview>{
    SoftReference<Regview>sso;
    Context context;
    IRegmodel model;

    public Regpresener(Regview view, Context context) {
        attch(view);
        this.context = context;
        model=new Regmodel();
    }


    public  void Showreg(){
        String name=sso.get().getName();
        String pass = sso.get().getPass();
        HashMap<String,String> map=new HashMap<>();
        map.put("mobile",name);
        map.put("password",pass);
        model.showReg(map, new IRegmodel.Reg() {
            @Override
            public void complet(RegBean regBean) {
                String code = regBean.getCode();
                if (code.equals("0")){
                    context.startActivity(new Intent(context, LogActivity.class));
                    Toast.makeText(context,"注册成功",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context,"注册失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void attch(Regview view) {
        sso=new SoftReference<Regview>(view);
    }

    @Override
    public void detch() {
       sso.clear();
    }
}
