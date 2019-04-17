package com.tiaozhanbei.chouxiaoya.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.tiaozhanbei.chouxiaoya.R;
import com.tiaozhanbei.chouxiaoya.activity.ClassActivity;
import com.tiaozhanbei.chouxiaoya.adapter.ClassAdapter;
import com.tiaozhanbei.chouxiaoya.bean.ClassBean;
import com.tiaozhanbei.chouxiaoya.utils.ResourceUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class ClassFragment extends Fragment implements View.OnTouchListener {

    Unbinder unbinder;
    @BindView(R.id.rlv_class_fragment)
    RecyclerView mRecyclerView;
    private ClassAdapter mClassAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_class, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setOnTouchListener(this);
        initRecyclerView();
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

    public void initRecyclerView() {
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

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mClassAdapter = new ClassAdapter();
        mClassAdapter.setOnItemClickListener(itemClickListener);
        mClassAdapter.setDataSilently(classBeanList);
        mRecyclerView.setAdapter(mClassAdapter);
    }

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
            if (mClassAdapter == null) { return; }
            ClassBean classBean = mClassAdapter.getItem(position);
            if (classBean == null) {return;}
            Intent intent = new Intent(getActivity(), ClassActivity.class);
            intent.putExtra("position", position);
            getActivity().startActivity(intent);
        }
    };
}
