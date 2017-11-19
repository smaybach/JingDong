package com.example.jingdong.presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.jingdong.MainActivity;
import com.example.jingdong.bean.LogBean;
import com.example.jingdong.model.Ilogmodel;
import com.example.jingdong.model.logmodel;
import com.example.jingdong.view.Logview;

import java.lang.ref.SoftReference;
import java.util.HashMap;

/**
 * Created by 李倩 on 2017/11/17.
 */

public class Logpresenter implements Ipresenter<Logview> {
    Context context;
    SoftReference<Logview>ss;
    Ilogmodel model;
    public Logpresenter(Context context, Logview view) {
        this.context = context;
        attch(view);
        model=new logmodel();
    }
    //登录
      public  void  ShowLOFIN(){
          String name = ss.get().getName();
          String pass = ss.get().getPass();
          HashMap<String,String> map=new HashMap<>();
          map.put("mobile",name);
          map.put("password",pass);
          model.showlog(map, new Ilogmodel.Log() {
              @Override
              public void complet(LogBean logBean) {
                  String code = logBean.getCode();

                  Log.i("===login====", "complet: "+code);
                  if (code.equals("0")){
                      //6FC06598FE9E23CD93106DA03AFCDFED
                      Log.i("====uid****", "uid: "+logBean.getData().getUid());
                      Log.i("===token****", "complet: "+logBean.getData().getToken().toString());
                      context.startActivity(new Intent(context, MainActivity.class));
                      Toast.makeText(context,"登录成功",Toast.LENGTH_SHORT).show();
                  }else{
                      Toast.makeText(context,"登录失败",Toast.LENGTH_SHORT).show();
                  }
              }
          });
      }
    @Override
    public void attch(Logview view) {
        ss=new SoftReference<Logview>(view);
    }

    @Override
    public void detch() {
    ss.clear();
    }
}
