package com.garyhu.exploseview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.garyhu.exploseview.R;
import com.garyhu.exploseview.utils.NetworkHolder;
import com.garyhu.exploseview.viewexplosion.ExplosionField;
import com.garyhu.exploseview.viewexplosion.factory.ExplodeParticleFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： garyhu.
 * 时间： 2017/2/18.
 */

public class SecondActivity extends AppCompatActivity {

    private ConvenientBanner cb;
    private List<String> imgUrls;
    private ExplosionField explosionField;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        cb = (ConvenientBanner) findViewById(R.id.cb);
        explosionField = new ExplosionField(this,new ExplodeParticleFactory());
        initData();
        cb.setPages(new CBViewHolderCreator<NetworkHolder>() {
            @Override
            public NetworkHolder createHolder() {
                return new NetworkHolder();
            }
        },imgUrls);
        cb.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                startActivity(new Intent(SecondActivity.this,ThirdActivity.class));
            }
        });
    }

    public void initData(){
        imgUrls = new ArrayList<>();
        imgUrls.add("http://imglocal.miaodj.cn/Uploads/materials/201611/source/582d281e5894c.jpg");
        imgUrls.add("http://imglocal.miaodj.cn/Uploads/materials/201611/source/5833e12f60b18.jpg");
        imgUrls.add("http://imglocal.miaodj.cn/Uploads/materials/201702/source/589c22177f88a.png");
    }

    @Override
    protected void onResume() {
        super.onResume();
        cb.startTurning(3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        cb.stopTurning();
    }
}
