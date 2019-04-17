package com.tiaozhanbei.chouxiaoya.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.tiaozhanbei.chouxiaoya.R;
import com.tiaozhanbei.chouxiaoya.adapter.CosmeticsAdapter;
import com.tiaozhanbei.chouxiaoya.bean.ClassBean;
import com.tiaozhanbei.chouxiaoya.utils.ResourceUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CosmeticsActivity extends AppCompatActivity {

    @BindView(R.id.iv_back_feed_back_activity)
    ImageView ivBackFeedBackActivity;
    @BindView(R.id.tv_title) TextView tvTitle;
    @BindView(R.id.rlv_cosmetics) RecyclerView mRecyclerView;
    private CosmeticsAdapter mClassAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosmetics);
        ButterKnife.bind(this);
        initRecyclerView();
        ivBackFeedBackActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void initRecyclerView() {
        ClassBean classBean1 = new ClassBean(ResourceUtil.getDrawable(R.drawable.testlib_lipstick), "口红");
        ClassBean classBean2 = new ClassBean(ResourceUtil.getDrawable(R.drawable.subscript01), "腮红");
        ClassBean classBean3 = new ClassBean(ResourceUtil.getDrawable(R.drawable.testlib_makeup), "眼影");
        ClassBean classBean4 = new ClassBean(ResourceUtil.getDrawable(R.drawable.sub_bbww_01), "粉底");
        ClassBean classBean5 = new ClassBean(ResourceUtil.getDrawable(R.drawable.sub_hz_01), "口红");
        ClassBean classBean6 = new ClassBean(ResourceUtil.getDrawable(R.drawable.sub_hz_02), "腮红");
        ClassBean classBean7 = new ClassBean(ResourceUtil.getDrawable(R.drawable.product1_a), "眼影");
        ClassBean classBean8 = new ClassBean(ResourceUtil.getDrawable(R.drawable.product1_b1), "粉底");
        ClassBean classBean9 = new ClassBean(ResourceUtil.getDrawable(R.drawable.product2_a), "口红");
        ClassBean classBean10 = new ClassBean(ResourceUtil.getDrawable(R.drawable.product2_b1), "腮红");
        ClassBean classBean11 = new ClassBean(ResourceUtil.getDrawable(R.drawable.product2_b2), "眼影");
        ClassBean classBean12 = new ClassBean(ResourceUtil.getDrawable(R.drawable.product2_c), "粉底");
        ClassBean classBean13 = new ClassBean(ResourceUtil.getDrawable(R.drawable.product3_a), "口红");
        ClassBean classBean14 = new ClassBean(ResourceUtil.getDrawable(R.drawable.product4_a), "腮红");
        ClassBean classBean15 = new ClassBean(ResourceUtil.getDrawable(R.drawable.product5_a), "眼影");
        ClassBean classBean16 = new ClassBean(ResourceUtil.getDrawable(R.drawable.product6_a), "粉底");
        ClassBean classBean17 = new ClassBean(ResourceUtil.getDrawable(R.drawable.ic_sub_yx), "口红");
        ClassBean classBean18 = new ClassBean(ResourceUtil.getDrawable(R.drawable.product4_onetwo21), "腮红");

        List<ClassBean> classBeanList = new ArrayList<>();
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

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mClassAdapter = new CosmeticsAdapter();
        mClassAdapter.setDataSilently(classBeanList);
        mClassAdapter.setOnItemClickListener(itemClickListener);
        mRecyclerView.setAdapter(mClassAdapter);
    }

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
            if (mClassAdapter == null) { return; }
            ClassBean classBean = mClassAdapter.getItem(position);
            if (classBean == null) {return;}
            Intent intent = new Intent(CosmeticsActivity.this, LipstickActivity.class);
            startActivity(intent);
        }
    };
}
