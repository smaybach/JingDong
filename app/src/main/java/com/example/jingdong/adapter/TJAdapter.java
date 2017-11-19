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

public class TJAdapter extends RecyclerView.Adapter<TJAdapter.ViewHolder> {
    Context context;
    List<HomeBean.TuijianBean.ListBean> tj;
    OnItemClickListener listener;
    public TJAdapter(Context context, List<HomeBean.TuijianBean.ListBean> tj) {
        this.context = context;
        this.tj = tj;
    }

    public void  setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.home_tj, null);
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
        String img=new String(tj.get(position).getImages());
        String[] split=img.split("\\|");
         DraweeController controller= Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(split[0]))
                .build();
        holder.tjSim.setController(controller);
        holder.tjTitle.setText(tj.get(position).getTitle());
        holder.tjPrice.setText("￥"+tj.get(position).getPrice()+"");
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return tj==null?0:tj.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tj_sim)
        SimpleDraweeView tjSim;
        @BindView(R.id.tj_title)
        TextView tjTitle;
        @BindView(R.id.tj_price)
        TextView tjPrice;
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
