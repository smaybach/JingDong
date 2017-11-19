package com.example.jingdong;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.jingdong.fragment.FragMentCarShop;
import com.example.jingdong.fragment.FragMentFaxian;
import com.example.jingdong.fragment.FragMentFenLei;
import com.example.jingdong.fragment.FragMentHome;
import com.example.jingdong.fragment.FragMentMy;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {
    @BindView(R.id.vp)
    NoScrollViewPager vp;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.bt)
    RadioButton bt;
    private List<Fragment> flist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        //数据源
        initData();
        rg.check(R.id.bt);
        MyFragmentadapter myadapter = new MyFragmentadapter(getSupportFragmentManager());
        vp.setAdapter(myadapter);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.bt:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.bt1:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.bt2:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.bt3:
                        vp.setCurrentItem(3);
                        break;
                    case R.id.bt4:
                        vp.setCurrentItem(4);
                        break;
                }
            }
        });
    }

    private void initData() {
        flist = new ArrayList<>();
        flist.add(new FragMentHome());
        flist.add(new FragMentFenLei());
        flist.add(new FragMentFaxian());
        flist.add(new FragMentCarShop());
        flist.add(new FragMentMy());
    }

    class MyFragmentadapter extends FragmentPagerAdapter {

        public MyFragmentadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return flist.get(position);
        }

        @Override
        public int getCount() {
            return flist.size();
        }
    }

}
