package com.tiaozhanbei.chouxiaoya.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tiaozhanbei.chouxiaoya.R;
import com.tiaozhanbei.chouxiaoya.bean.ClassBean;
import com.tiaozhanbei.chouxiaoya.utils.ResourceUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClassActivity extends AppCompatActivity {

    @BindView(R.id.iv_back_feed_back_activity)
    ImageView ivBackFeedBackActivity;
    @BindView(R.id.tv_title) TextView tvTitle;
    @BindView(R.id.iv_class) ImageView ivClass;
    ;
    private List<ClassBean> classBeanList = new ArrayList<>();
    private int mPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        ButterKnife.bind(this);
        initData();
        mPosition = getIntent().getIntExtra("position", 0);
        int size = classBeanList.size();
        if (mPosition >= size) {onBackPressed();}
        ClassBean classBean = classBeanList.get(mPosition);
        if (classBean == null) {onBackPressed();}
//        tvTitle.setText(classBean.getName());
        ivClass.setImageDrawable(classBean.getmDrawable());
        ivBackFeedBackActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    public void initData() {
        ClassBean classBean1 = new ClassBean(ResourceUtil.getDrawable(R.drawable.luozhuang1), "luozhuang1");
        ClassBean classBean2 = new ClassBean(ResourceUtil.getDrawable(R.drawable.luozhuang2), "luozhuang2");
        ClassBean classBean3 = new ClassBean(ResourceUtil.getDrawable(R.drawable.luozhuang3), "luozhuang3");
        ClassBean classBean4 = new ClassBean(ResourceUtil.getDrawable(R.drawable.luozhuang4), "luozhuang4");
        ClassBean classBean5 = new ClassBean(ResourceUtil.getDrawable(R.drawable.newlook1), "newlook1");
        ClassBean classBean6 = new ClassBean(ResourceUtil.getDrawable(R.drawable.newlook2), "newlook2");
        ClassBean classBean7 = new ClassBean(ResourceUtil.getDrawable(R.drawable.newlook3), "newlook3");
        ClassBean classBean8 = new ClassBean(ResourceUtil.getDrawable(R.drawable.newlook4), "newlook4");
        ClassBean classBean9 = new ClassBean(ResourceUtil.getDrawable(R.drawable.newlook5), "newlook5");
        ClassBean classBean10 = new ClassBean(ResourceUtil.getDrawable(R.drawable.newlook6), "newlook6");
        ClassBean classBean11 = new ClassBean(ResourceUtil.getDrawable(R.drawable.newlook7), "newlook7");
        ClassBean classBean12 = new ClassBean(ResourceUtil.getDrawable(R.drawable.newlook8), "newlook8");
        ClassBean classBean13 = new ClassBean(ResourceUtil.getDrawable(R.drawable.newlook9), "newlook9");
        ClassBean classBean14 = new ClassBean(ResourceUtil.getDrawable(R.drawable.newlook10), "newlook10");
        ClassBean classBean15 = new ClassBean(ResourceUtil.getDrawable(R.drawable.newlook11), "newlook11");
        ClassBean classBean16 = new ClassBean(ResourceUtil.getDrawable(R.drawable.newlook12), "newlook12");
        ClassBean classBean17 = new ClassBean(ResourceUtil.getDrawable(R.drawable.newlook13), "newlook13");
        ClassBean classBean18 = new ClassBean(ResourceUtil.getDrawable(R.drawable.newlook14), "newlook14");


        classBeanList.add(classBean1);
        classBeanList.add(classBean2);
        classBeanList.add(classBean3);
        classBeanList.add(classBean4);
        classBeanList.add(classBean5);
        classBeanList.add(classBean6);
        classBeanList.add(classBean7);
        classBeanList.add(classBean8);
        classBeanList.add(classBean9);
        classBeanList.add(classBean10);
        classBeanList.add(classBean11);
        classBeanList.add(classBean12);
        classBeanList.add(classBean13);
        classBeanList.add(classBean14);
        classBeanList.add(classBean15);
        classBeanList.add(classBean16);
        classBeanList.add(classBean17);
        classBeanList.add(classBean18);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
