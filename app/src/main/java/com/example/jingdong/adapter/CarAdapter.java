package com.example.jingdong.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jingdong.R;
import com.example.jingdong.bean.CarBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 李倩 on 2017/11/17.
 */

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
    Context context;
    CarBean carBean;

    public CarAdapter(Context context, CarBean carBean) {
        this.context = context;
        this.carBean = carBean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.car_rv, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         String img= carBean.getData().get(position).getList().get(0).getImages();
         String[] spilt=img.split("\\|");
        DraweeController controller= Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(spilt[0]))
                .build();
        holder.sdv.setController(controller);
        holder.tvs.setText(carBean.getData().get(position).getList().get(0).getTitle());
        holder.tvs2.setText("￥"+carBean.getData().get(position).getList().get(0).getPrice());

    }

    @Override
    public int getItemCount() {
        return carBean==null?0:carBean.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.eckboxnum)
        CheckBox eckboxnum;
        @BindView(R.id.sdv)
        SimpleDraweeView sdv;
        @BindView(R.id.tvs)
        TextView tvs;
        @BindView(R.id.tvs2)
        TextView tvs2;
        @BindView(R.id.addcart_pop_add)
        Button addcartPopAdd;
        @BindView(R.id.addcart_pop_goodnum)
        TextView addcartPopGoodnum;
        @BindView(R.id.addcart_pop_jian)
        Button addcartPopJian;
        @BindView(R.id.addcart_pop_linear)
        RelativeLayout addcartPopLinear;
        @BindView(R.id.delete)
        TextView delete;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
