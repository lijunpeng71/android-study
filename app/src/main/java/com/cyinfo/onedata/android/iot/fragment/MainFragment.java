package com.cyinfo.onedata.android.iot.fragment;

import android.widget.TextView;

import com.cyinfo.onedata.android.iot.R;
import com.cyinfo.onedata.android.iot.base.BaseFragment;

import butterknife.BindView;

public class MainFragment extends BaseFragment {

    @BindView(R.id.content_tv)
    public TextView contentTv;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {
        contentTv.setText("111111111111111111111111");
    }
}
