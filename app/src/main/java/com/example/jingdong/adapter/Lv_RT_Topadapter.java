package com.example.jingdong.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.jingdong.R;
import com.example.jingdong.bean.Fen_leiBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 李倩 on 2017/11/15.
 */

public class Lv_RT_Topadapter extends BaseAdapter{
    Context context;
    List<Fen_leiBean.DataBean> gslist=new ArrayList<>();
    List<Fen_leiBean.DataBean.ListBean> gslist2=new ArrayList<>();

    public Lv_RT_Topadapter(Context context, List<Fen_leiBean.DataBean> gslist) {
        this.context = context;
        this.gslist = gslist;
        Log.i("zzzzzzzzzzzz", "Lv_RT_Topadapter: "+gslist);
    }

    @Override
    public int getCount() {
        return gslist==null?0:gslist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewholder holder=null;
        if (view==null){
            view=View.inflate(context, R.layout.lv_rt_top,null);
            holder=new viewholder();
            holder.lv_rt_tv= view.findViewById(R.id.lv_rt_tv);
            holder.lv_rt_gv=  view.findViewById(R.id.lv_rt_gv);
            view.setTag(holder);
        }else{
           holder= (viewholder) view.getTag();
        }
        holder.lv_rt_tv.setText(gslist.get(i).getName());
        for (int j = 0; j <gslist.get(i).getList().size(); j++) {
            gslist2.add(gslist.get(i).getList().get(j));
        }
        GridViewadapter adaptera= new GridViewadapter(context,gslist2);
        holder.lv_rt_gv.setAdapter(adaptera);
        return view;
    }
    class viewholder{
        TextView lv_rt_tv;
        GridView lv_rt_gv;
    }
}
