package com.example.jingdong.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jingdong.R;
import com.example.jingdong.bean.FenleiBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by 李倩 on 2017/11/15.
 */

public class Fen_lv_lf extends BaseAdapter{
    Context context;
    FenleiBean fenleiBean;

    public Fen_lv_lf(Context context, FenleiBean fenleiBean) {
        this.context = context;
        this.fenleiBean = fenleiBean;
    }

    @Override
    public int getCount() {
        return fenleiBean.getData().size();
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
        ViewHolder holder=null;
        if (view==null){
            view=View.inflate(context, R.layout.fen_lv_lf,null);
            holder=new ViewHolder();
            holder.lv_sim= view.findViewById(R.id.lv_lf_img);
            holder.lv_tv=view.findViewById(R.id.lv_lf_tv);
            view.setTag(holder);
        }else{
           holder= (ViewHolder) view.getTag();
        }
        DraweeController controller= Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(fenleiBean.getData().get(i).getIcon()))
                .build();
        holder.lv_sim.setController(controller);
        holder.lv_tv.setText(fenleiBean.getData().get(i).getName());
        return view;
    }
    class ViewHolder{
       SimpleDraweeView lv_sim;
        TextView lv_tv;
    }
}
