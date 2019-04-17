package com.tiaozhanbei.chouxiaoya.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tiaozhanbei.chouxiaoya.R;
import com.tiaozhanbei.chouxiaoya.base.BaseRVAdapter;
import com.tiaozhanbei.chouxiaoya.base.IViewHolder;
import com.tiaozhanbei.chouxiaoya.bean.ClassBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class ClassAdapter extends BaseRVAdapter<ClassBean, ClassAdapter.ClassAdapterHolder> {

    @Override
    protected ClassAdapterHolder doCreateViewHolder(ViewGroup parent, int viewType) {
        return new ClassAdapterHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class, parent, false));
    }

    @Override
    protected void bindItemData(ClassAdapterHolder viewHolder, ClassBean friend, int position) {
        viewHolder.bindView(friend, position);
    }


    public class ClassAdapterHolder extends RecyclerView.ViewHolder implements IViewHolder<ClassBean> {

        @BindView(R.id.riv_item_class_adapter) CircleImageView mAvatar;
        @BindView(R.id.tv_user_name_class_adapter) TextView mUserName;

        public ClassAdapterHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindView(final ClassBean classBean, final int position) {
            mAvatar.setImageDrawable(classBean.getmDrawable());
            mUserName.setText(classBean.getName());
        }
    }
}
