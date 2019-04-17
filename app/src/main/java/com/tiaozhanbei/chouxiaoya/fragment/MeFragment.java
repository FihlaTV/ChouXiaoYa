package com.tiaozhanbei.chouxiaoya.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tiaozhanbei.chouxiaoya.R;
import com.tiaozhanbei.chouxiaoya.activity.CosmeticsActivity;
import com.tiaozhanbei.chouxiaoya.activity.MyStyleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;


public class MeFragment extends Fragment implements View.OnTouchListener {

    Unbinder unbinder;
    @BindView(R.id.civ_avatar) CircleImageView civAvatar;
    @BindView(R.id.tv_name) TextView tvName;
    @BindView(R.id.riv_item_class_adapter) CircleImageView rivItemClassAdapter;
    @BindView(R.id.tv_user_name_class_adapter) TextView tvUserNameClassAdapter;
    @BindView(R.id.ll_my_cosmetics) LinearLayout llMyCosmetics;
    @BindView(R.id.ll_my_style) LinearLayout llMyStyle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setOnTouchListener(this);
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

    @OnClick({R.id.ll_my_cosmetics})
    public void myCosmeticsClicked() {
        getActivity().startActivity(new Intent(getActivity(), CosmeticsActivity.class));
    }

    @OnClick({R.id.ll_my_style})
    public void myStyleClicked() {
        getActivity().startActivity(new Intent(getActivity(), MyStyleActivity.class));
    }
}
