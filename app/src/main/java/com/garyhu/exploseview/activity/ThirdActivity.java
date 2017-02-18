package com.garyhu.exploseview.activity;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.garyhu.exploseview.R;
import com.garyhu.exploseview.viewexplosion.ExplosionField;
import com.garyhu.exploseview.viewexplosion.factory.ExplodeParticleFactory;

/**
 * 作者： garyhu.
 * 时间： 2017/2/18.
 */

public class ThirdActivity extends AppCompatActivity {

    private SimpleDraweeView sdf1,sdf2,sdf3;
    private FrameLayout f;
    private ExplosionField explosionField;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        explosionField = new ExplosionField(this,new ExplodeParticleFactory());
        sdf1 = (SimpleDraweeView) findViewById(R.id.sdf1);
        sdf2 = (SimpleDraweeView) findViewById(R.id.sdf2);
        sdf3 = (SimpleDraweeView) findViewById(R.id.sdf3);
        f = (FrameLayout) findViewById(R.id.f);
        sdf1.setImageURI(Uri.parse("http://imglocal.miaodj.cn/Uploads/materials/201611/source/582d281e5894c.jpg"));
        sdf2.setImageURI(Uri.parse("http://imglocal.miaodj.cn/Uploads/materials/201611/source/5833e12f60b18.jpg"));
        sdf3.setImageURI(Uri.parse("http://imglocal.miaodj.cn/Uploads/materials/201702/source/589c22177f88a.png"));
        explosionField.addListener(sdf1);
        explosionField.addListener(sdf2);
        explosionField.addListener(sdf3);
        explosionField.setCallback(new ExplosionField.Callback() {
            @Override
            public void setL(View v) {
                int id = v.getId();
                switch (id){
                    case R.id.sdf1:
                        sdf2.setVisibility(View.VISIBLE);
                        sdf1.setVisibility(View.GONE);
                        sdf3.setVisibility(View.GONE);
                        break;
                    case R.id.sdf2:
                        sdf3.setVisibility(View.VISIBLE);
                        sdf2.setVisibility(View.GONE);
                        sdf1.setVisibility(View.GONE);
                        break;
                    case R.id.sdf3:
                        sdf1.setVisibility(View.VISIBLE);
                        sdf2.setVisibility(View.GONE);
                        sdf3.setVisibility(View.GONE);
                        break;
                }
            }
        });
    }
}
