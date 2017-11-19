package com.example.jingdong.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jingdong.R;
import com.example.jingdong.bean.HomeBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 李倩 on 2017/11/15.
 */

public class MSAdapter extends RecyclerView.Adapter<MSAdapter.ViewHolder> {
    Context context;
    List<HomeBean.MiaoshaBean.ListBeanX> hb;

    public MSAdapter(Context context,  List<HomeBean.MiaoshaBean.ListBeanX> hb) {
        this.context = context;
        this.hb = hb;
    }
    OnItemClickListener listener;

    public void  setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.home_ms, null);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){
                    listener.onItemClick(view, (Integer) view.getTag());
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String img=hb.get(position).getImages();
        String[] split= img.split("\\|");
        DraweeController controller= Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(split[0]))
                .build();
        holder.msSim.setController(controller);
        holder.msTitle.setText("￥"+hb.get(position).getPrice());
        holder.msPrice.setText("￥"+hb.get(position).getSalenum());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return hb==null?0:hb.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ms_sim)
        SimpleDraweeView msSim;
        @BindView(R.id.ms_title)
        TextView msTitle;
        @BindView(R.id.ms_price)
        TextView msPrice;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    //接口
    public  interface  OnItemClickListener{
        public  void onItemClick(View view,int position);
    }
}
