package com.tiaozhanbei.chouxiaoya.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.tiaozhanbei.chouxiaoya.R;
import com.tiaozhanbei.chouxiaoya.adapter.TodayWellChosenListAdapter;
import com.tiaozhanbei.chouxiaoya.bean.Cosmetic;
import com.tiaozhanbei.chouxiaoya.view.BannerGlideImageLoader;
import com.tiaozhanbei.chouxiaoya.view.DividerGridItemDecoration;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MainFragment extends Fragment implements View.OnTouchListener {

    @BindView(R.id.banner)
    public Banner banner;
    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;

    private TodayWellChosenListAdapter adapter;
    private List<Cosmetic> dataList = new ArrayList<>();
    public List<Integer> imageList = Arrays.asList(
            R.drawable.banner_bg1,
            R.drawable.banner_bg1,
            R.drawable.banner_bg1);

    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setOnTouchListener(this);
        initView();
        initData();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }

    private void initView() {
        banner.setImageLoader(new BannerGlideImageLoader())
                .setImages(imageList)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setDelayTime(4000)
                .setIndicatorGravity(BannerConfig.RIGHT)
                .start();
        adapter = new TodayWellChosenListAdapter(R.layout.today_well_chosen_item, dataList);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerGridItemDecoration(getActivity(), 2));

    }

    private void initData() {
        dataList.add(new Cosmetic(
                "科颜氏高保湿霜",
                "来自纽约医药专业品牌的科颜氏向来以最温和却有效的护肤配方原则而响誉全球，其中【高保湿系列】更是自1970年推出以来，即不限男女、适用于各肤质的经典热卖品。",
                R.drawable.cosmetic1));
        dataList.add(new Cosmetic(
                "兰蔻清滢嫩肤水",
                "透明的化妆水,不但能温和的洁净肌肤,还能给予肌肤度的湿润。",
                R.drawable.cosmetic2
        ));
        dataList.add(new Cosmetic(
                "雅诗兰黛特润修护精华露",
                "雅诗兰黛密集特润修护精华露，内含突破性配方，拥有5倍浓度的神秘修护复合物，彻底改善肌肤状况。强力聚合三种创新科技，集中作用于21个夜晚，大幅度加强了肌肤自我修复功能，使之能够对抗更多压力伤害，重获健康新生。",
                R.drawable.cosmetic3
        ));
        dataList.add(new Cosmetic(
                "HABA润泽柔肤水",
                "无添加色素、香料,多元醇替代传统防腐,以透明质酸钠、软骨素硫磺酸、藻提取物、水解大豆蛋白等做为保湿剂,同时甘草酸二钾。",
                R.drawable.cosmetic4
        ));
        adapter.notifyDataSetChanged();
    }

}
