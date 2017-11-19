package com.example.jingdong.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jingdong.R;
import com.example.jingdong.bean.Fen_leiBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 李倩 on 2017/11/15.
 */

public class GridViewadapter extends BaseAdapter {
    Context context;
    List<Fen_leiBean.DataBean.ListBean> gvlist;

    public GridViewadapter(Context context, List<Fen_leiBean.DataBean.ListBean> gvlist) {
        this.context = context;
        this.gvlist = gvlist;
    }



    @Override
    public int getCount() {
        return gvlist == null ? 0 : gvlist.size();
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
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(context, R.layout.gridview_item, null);
            holder=new ViewHolder();
            holder.lvGvSim=view.findViewById(R.id.lv_gv_sim);
            holder.lvGvTv=view.findViewById(R.id.lv_gv_tv);
            view.setTag(holder);
        }else{
          holder= (ViewHolder) view.getTag();
        }
        DraweeController controller= Fresco.newDraweeControllerBuilder()
                .setUri(gvlist.get(i).getIcon())
                .build();
        holder.lvGvSim.setController(controller);
        holder.lvGvTv.setText(gvlist.get(i).getName());
        return view;
    }

  class ViewHolder {

        SimpleDraweeView lvGvSim;

        TextView lvGvTv;


    }
}
