package com.cyinfo.onedata.android.iot.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cyinfo.onedata.android.iot.R;
import com.cyinfo.onedata.android.iot.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tv)
    protected TextView tv;

    @BindView(R.id.btnDate)
    protected Button btnDate;

    @BindView(R.id.btnTime)
    protected Button btnTime;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        btnDate.setOnClickListener(mylistener);
        btnTime.setOnClickListener(mylistener);
    }

    View.OnClickListener mylistener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnDate:
                    showDialog();
            }
        }
    }
}
