package com.example.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jingdong.R;
import com.example.jingdong.bean.FenleiBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 李倩 on 2017/11/15.
 */

public class GvAdapter extends RecyclerView.Adapter<GvAdapter.ViewHolder> {
    Context context;
    FenleiBean fb;


    public GvAdapter(Context context, FenleiBean fb) {
        this.context = context;
        this.fb = fb;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.home_gv, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DraweeController controller= Fresco.newDraweeControllerBuilder()
                .setUri(fb.getData().get(position).getIcon())
                .build();
        holder.gvSim.setController(controller);
        holder.gvTv.setText(fb.getData().get(position).getName());
    }

    @Override
    public int getItemCount() {
        return fb==null?0:10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.gv_sim)
        SimpleDraweeView gvSim;
        @BindView(R.id.gv_tv)
        TextView gvTv;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
