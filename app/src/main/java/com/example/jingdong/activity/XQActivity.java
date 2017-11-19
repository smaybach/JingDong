package com.example.jingdong.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.jingdong.R;
import com.example.jingdong.okhttp.OKHttpUtils;
import com.example.jingdong.okhttp.OnUiCallback;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

public class XQActivity extends AppCompatActivity {
    SimpleDraweeView pop_img;
    TextView pop_title;
    Button pop_send;
    @BindView(R.id.sim)
    SimpleDraweeView sim;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_subhead)
    TextView tvSubhead;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.bn)
    Button bn;
   /* @BindView(R.id.web)
    WebView web;*/
   DraweeController con;
   DraweeController con1;
    String title,img,price,subhead,time;
    int pid;
    String pathadd="https://www.zhaoapi.cn/product/addCart";
    String urladd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xq);
        ButterKnife.bind(this);
      /*  Intent intent = getIntent();
        String url1 = intent.getStringExtra("url");
        web.loadUrl(url1);*/
      initdata();
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v=View.inflate(XQActivity.this,R.layout.popwidow,null);
                pop_img=  v.findViewById(R.id.pop_img);
                pop_title= v.findViewById(R.id.pop_title);
                pop_send= v.findViewById(R.id.pop_send);
                PopupWindow pp= new PopupWindow(v, LinearLayout.LayoutParams.MATCH_PARENT,500,true);
                pp.setOutsideTouchable(true);
                pp.setBackgroundDrawable(new BitmapDrawable());
                pp.setAnimationStyle(R.style.mypopwindow_anim_style);
                pp.showAtLocation(v, Gravity.BOTTOM,0,0);
                con1 = Fresco.newDraweeControllerBuilder()
                        .setUri(Uri.parse(img))
                        .build();
                pop_img.setController(con1);
                pop_title.setText(title);


                urladd=pathadd+"?uid="+"2476"+"&pid="+pid+"&token="+"B4878262E2D6BB6B4E23A0D83987C99C";
                pop_send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        inittj();
                    }


                });
            }
        });
    }
    private void inittj() {
        OKHttpUtils.getInstance().doGet(urladd, new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onsuccess(String result) throws IOException {
                Log.i("eeeeeee", "onsuccess: "+result.toString());
            }
        });
    }
    private void initdata() {
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        img = intent.getStringExtra("img");
        subhead = intent.getStringExtra("subhead");
        time = intent.getStringExtra("time");
        pid = intent.getIntExtra("pid",0);
        con = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(img))
                .build();
        sim.setController(con);
        tvName.setText(title);
        tvSubhead.setText(subhead);
        tvTime.setText(time);
        tvPrice.setText(price);



    }


}
