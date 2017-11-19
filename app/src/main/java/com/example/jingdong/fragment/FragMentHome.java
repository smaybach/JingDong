package com.example.jingdong.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jingdong.BaseFragment;
import com.example.jingdong.R;
import com.example.jingdong.activity.SOUsuActivity;
import com.example.jingdong.activity.XQActivity;
import com.example.jingdong.adapter.GvAdapter;
import com.example.jingdong.adapter.MSAdapter;
import com.example.jingdong.adapter.TJAdapter;
import com.example.jingdong.app.ImageApp;
import com.example.jingdong.bean.FenleiBean;
import com.example.jingdong.bean.HomeBean;
import com.example.jingdong.presenter.VPHomepresenter;
import com.example.jingdong.view.HomeView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 李倩 on 2017/11/14.
 */

public class FragMentHome extends BaseFragment<VPHomepresenter> implements HomeView {
    Banner homeBanner;
    @BindView(R.id.gv_re)
    RecyclerView gvRe;
    Unbinder unbinder;
    @BindView(R.id.ms_re)
    RecyclerView msRe;
    @BindView(R.id.tv_hour)
    TextView tvHour;
    @BindView(R.id.tv_minute)
    TextView tvMinute;
    @BindView(R.id.tv_second)
    TextView tvSecond;
    @BindView(R.id.ll_xsqg)
    LinearLayout llXsqg;
    @BindView(R.id.tj_re)
    RecyclerView tjRe;
    @BindView(R.id.home_iv)
    ImageView homeIv;
    private long mHour = 02;
    private long mMin = 15;
    private long mSecond = 36;
    private boolean isRun = true;
    private Handler timeHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1 && isRun) {
                computeTime();

                if (mHour < 10) {
                    tvHour.setText("0" + mHour + "");
                } else {
                    tvHour.setText("0" + mHour + "");
                }
                if (mMin < 10) {
                    tvMinute.setText("0" + mMin + "");
                } else {
                    tvMinute.setText(mMin + "");
                }
                if (mSecond < 10) {
                    tvSecond.setText("0" + mSecond + "");
                } else {
                    tvSecond.setText(mSecond + "");
                }
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_home, null);
        homeBanner = view.findViewById(R.id.home_banner);
        presenter.showVp();
        presenter.showGv();
        presenter.showMS();
        presenter.showTJ();
        unbinder = ButterKnife.bind(this, view);
        isRun = true;
        startRun();
        homeIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SOUsuActivity.class));
            }
        });
        return view;
    }

    /**
     * 无线轮播
     *
     * @param homeBean
     */
    @Override
    public void initData(HomeBean homeBean) {
        List<String> list_vp = new ArrayList<>();
        for (int i = 0; i < homeBean.getData().size(); i++) {
            list_vp.add(homeBean.getData().get(i).getIcon());
        }
        homeBanner.setImageLoader(new ImageApp());
        homeBanner.setImages(list_vp);
        homeBanner.start();
    }

    /**
     * Gridview
     *
     * @param fb
     */
    @Override
    public void initshowGridviewf(FenleiBean fb) {
        GridLayoutManager mar = new GridLayoutManager(getActivity(), 5);
        gvRe.setLayoutManager(mar);
        GvAdapter adapter = new GvAdapter(getActivity(), fb);
        gvRe.setAdapter(adapter);

    }



    private void startRun() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (isRun) {
                    try {
                        Thread.sleep(1000); // sleep 1000ms
                        Message message = Message.obtain();
                        message.what = 1;
                        timeHandler.sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void computeTime() {
        mSecond--;
        if (mSecond < 0) {
            mMin--;
            mSecond = 59;
            if (mMin < 0) {
                mMin = 59;
                mHour--;
            }
        }
    }

    @Override
    public void showMiaosha(final List<HomeBean.MiaoshaBean.ListBeanX> list) {
        GridLayoutManager mar = new GridLayoutManager(getActivity(), 1);
        mar.setOrientation(GridLayoutManager.HORIZONTAL);
        msRe.setLayoutManager(mar);
        MSAdapter adapter = new MSAdapter(getActivity(), list);
        msRe.setAdapter(adapter);
        adapter.setOnItemClickListener(new MSAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), XQActivity.class);
                // intent.putExtra("url", sj.getTuijian().getList().get(position).getDetailUrl());
                String img=new String(list.get(position).getImages());
                String[] spilt=img.split("\\|");
                intent.putExtra("img",spilt[0]);
                intent.putExtra("pid",list.get(position).getPid());
                intent.putExtra("title",list.get(position).getTitle());
                intent.putExtra("price",list.get(position).getSalenum());
                intent.putExtra("subhead",list.get(position).getSubhead());
                intent.putExtra("time",list.get(position).getCreatetime());
                startActivity(intent);
            }
        });
    }


    @Override
    public void showTuijian(final List<HomeBean.TuijianBean.ListBean> list) {
        GridLayoutManager mar = new GridLayoutManager(getActivity(), 2);
        tjRe.setLayoutManager(mar);
        TJAdapter adapter_tj = new TJAdapter(getActivity(), list);
        tjRe.setAdapter(adapter_tj);
        adapter_tj.setOnItemClickListener(new TJAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), XQActivity.class);
                // intent.putExtra("url", sj.getTuijian().getList().get(position).getDetailUrl());
                String img = new String(list.get(position).getImages());
                String[] spilt = img.split("\\|");
                intent.putExtra("img", spilt[0]);
                Log.i("++++++++++++", "onItemClick: " + list.get(position).getPid());
                intent.putExtra("pid", list.get(position).getPid());
                intent.putExtra("title", list.get(position).getTitle());
                intent.putExtra("subhead", list.get(position).getSubhead());
                intent.putExtra("time", list.get(position).getCreatetime());
                startActivity(intent);
            }
        });


    }


   /*
   @Override
    public void showTuijian(final HomeBean sj) {
        GridLayoutManager mar = new GridLayoutManager(getActivity(), 2);
        tjRe.setLayoutManager(mar);
        TJAdapter adapter_tj = new TJAdapter(getActivity(), sj);
        tjRe.setAdapter(adapter_tj);
        adapter_tj.setOnItemClickListener(new TJAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), XQActivity.class);
               // intent.putExtra("url", sj.getTuijian().getList().get(position).getDetailUrl());
                String img=new String(sj.getTuijian().getList().get(position).getImages());
                String[] spilt=img.split("\\|");
                intent.putExtra("img",spilt[0]);
                Log.i("++++++++++++", "onItemClick: "+sj.getTuijian().getList().get(position).getPid());
                intent.putExtra("pid",sj.getTuijian().getList().get(position).getPid());
                intent.putExtra("title",sj.getTuijian().getList().get(position).getTitle());
                intent.putExtra("subhead",sj.getTuijian().getList().get(position).getSubhead());
                intent.putExtra("time",sj.getTuijian().getList().get(position).getCreatetime());
                startActivity(intent);
            }
        });

    }*/

    public void createpresenter() {
        presenter = new VPHomepresenter(this,this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // presenter.detch();
        unbinder.unbind();
        timeHandler.removeMessages(1);
        isRun = false;
    }
}
