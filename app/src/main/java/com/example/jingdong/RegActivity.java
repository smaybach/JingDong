package com.example.jingdong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jingdong.activity.BaseActivity;
import com.example.jingdong.presenter.Regpresener;
import com.example.jingdong.view.Regview;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegActivity extends BaseActivity<Regpresener> implements Regview {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_pass)
    EditText etPass;
    @BindView(R.id.log_start)
    Button logStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);
        logStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.Showreg();
            }
        });
    }

    @Override
    public void createpresenter() {
        presenter = new Regpresener(this, this);
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
