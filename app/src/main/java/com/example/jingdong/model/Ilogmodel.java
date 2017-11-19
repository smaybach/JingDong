package com.example.jingdong.model;

import com.example.jingdong.bean.LogBean;

import java.util.HashMap;

/**
 * Created by 李倩 on 2017/11/17.
 */

public interface Ilogmodel {
    public void showlog(HashMap<String,String> ma,Log log);
    interface Log{
        public void complet(LogBean logBean);
    }
}
