package com.example.jingdong.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jingdong.R;
import com.example.jingdong.RegActivity;
import com.example.jingdong.presenter.Logpresenter;
import com.example.jingdong.view.Logview;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LogActivity extends BaseActivity<Logpresenter> implements Logview {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_pass)
    EditText etPass;
    @BindView(R.id.log_start)
    Button logStart;
    @BindView(R.id.zc)
    TextView zc;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg2);
        ButterKnife.bind(this);
      /*  sharedPreferences=getSharedPreferences("config",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        final boolean isno=sharedPreferences.getBoolean("isco",false);*/
        zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogActivity.this, RegActivity.class));
            }
        });

        logStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    presenter.ShowLOFIN();


            }
        });
    }

    @Override
    public void createpresenter() {
            presenter=new Logpresenter(this,this);
    }

    @Override
    public String getName() {
        return etName.getText().toString();
    }

    @Override
    public String getPass() {
        return etPass.getText().toString();
    }
}
