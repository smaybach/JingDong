package com.example.jingdong.model;

import com.example.jingdong.bean.RegBean;

import java.util.HashMap;

/**
 * Created by 李倩 on 2017/11/17.
 */

public interface IRegmodel {
    public void showReg(HashMap<String,String> map,Reg reg);
    interface Reg{
        public void complet(RegBean regBean);
    }

}
