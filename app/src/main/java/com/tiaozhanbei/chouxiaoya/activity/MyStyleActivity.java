package com.tiaozhanbei.chouxiaoya.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.tiaozhanbei.chouxiaoya.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyStyleActivity extends AppCompatActivity {

    @BindView(R.id.iv_back_feed_back_activity)
    ImageView ivBackFeedBackActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_style);
        ButterKnife.bind(this);
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
}
