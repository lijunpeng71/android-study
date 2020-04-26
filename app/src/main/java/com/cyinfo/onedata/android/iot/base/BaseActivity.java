package com.cyinfo.onedata.android.iot.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(getLayoutId());
        ButterKnife.bind(this);
        this.initView();

    }

    /**
     * layout
     *
     * @return
     */
    protected abstract int getLayoutId();


    /**
     * 初始化
     */
    protected abstract void initView();


    protected BaseActivity getActivity() {
        return this;
    }
}
