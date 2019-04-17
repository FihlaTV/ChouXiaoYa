package com.tiaozhanbei.chouxiaoya.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tiaozhanbei.chouxiaoya.R;
import com.tiaozhanbei.chouxiaoya.bean.Cosmetic;

import java.util.List;

/**
 * Created by SailFlorve on 2017/11/19 0019.
 */

public class TodayWellChosenListAdapter extends BaseQuickAdapter<Cosmetic, BaseViewHolder> {

    public TodayWellChosenListAdapter(int layoutResId, @Nullable List<Cosmetic> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Cosmetic item) {
        helper.setText(R.id.tv_title, item.getName())
                .setText(R.id.tv_des, item.getDes())
                .setImageResource(R.id.iv_cosmetic, item.getImageId());
    }
}
