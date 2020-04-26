package com.cyinfo.onedata.android.iot.activity;

import android.widget.TextView;

import com.cyinfo.onedata.android.iot.R;
import com.cyinfo.onedata.android.iot.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.textTv)
    TextView textView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //textView.setText("I am a Android Developer");
    }
}
