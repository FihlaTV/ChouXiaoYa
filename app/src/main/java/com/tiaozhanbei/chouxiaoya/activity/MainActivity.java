package com.tiaozhanbei.chouxiaoya.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.tiaozhanbei.chouxiaoya.R;
import com.tiaozhanbei.chouxiaoya.fragment.ClassFragment;
import com.tiaozhanbei.chouxiaoya.fragment.MainFragment;
import com.tiaozhanbei.chouxiaoya.fragment.MeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.ll_main_activity)
    LinearLayout activityMain;
    @BindView(R.id.bottom_navigation)
    public AHBottomNavigation bottomNavigation;

    private MainFragment mMainFragment;
    private ClassFragment mClassFragment;
    private MeFragment mMeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        initFragment();
        initView();
    }

    private void initView() {
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.bottom_item1, R.drawable.ic_view_gallery, R.color.colorAccent);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.bottom_item2, R.drawable.ic_lights, R.color.text);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.bottom_item3, R.drawable.ic_account, R.color.text);
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.setAccentColor(ContextCompat.getColor(this, R.color.colorAccent));
        bottomNavigation.setInactiveColor(ContextCompat.getColor(this, R.color.text));
        bottomNavigation.setForceTint(true);
        bottomNavigation.setUseElevation(false);
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                switchTo(position);
                return true;
            }
        });
    }

    public void initFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        int currentTabPosition = 0;
        if (mMainFragment == null) {
            mMainFragment = new MainFragment();
            transaction.add(R.id.ll_main_activity, mMainFragment);
        }

        if (mClassFragment == null) {
            mClassFragment = new ClassFragment();
            transaction.add(R.id.ll_main_activity, mClassFragment);
        }
        if (mMeFragment == null) {
            mMeFragment = new MeFragment();
            transaction.add(R.id.ll_main_activity, mMeFragment);
        }
        transaction.commit();
        switchTo(currentTabPosition);
    }

    private void switchTo(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                transaction.show(mMainFragment);
                transaction.hide(mClassFragment);
                transaction.hide(mMeFragment);
                transaction.commitAllowingStateLoss();
                break;
            case 1:
                transaction.show(mClassFragment);
                transaction.hide(mMainFragment);
                transaction.hide(mMeFragment);
                transaction.commitAllowingStateLoss();
                break;
            case 2:
                transaction.show(mMeFragment);
                transaction.hide(mMainFragment);
                transaction.hide(mClassFragment);
                transaction.commitAllowingStateLoss();
                break;
            default:
                break;
        }
    }
}
