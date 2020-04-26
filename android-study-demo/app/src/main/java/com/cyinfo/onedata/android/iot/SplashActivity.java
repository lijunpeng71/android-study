package com.cyinfo.onedata.android.iot;

import android.content.Intent;
import android.os.CountDownTimer;

import com.cyinfo.onedata.android.iot.activity.MainActivity;
import com.cyinfo.onedata.android.iot.base.BaseActivity;

public class SplashActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        countDownTimer.start();
    }


    /**
     * 定时器
     */
    private final CountDownTimer countDownTimer = new CountDownTimer(2000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            //跳转到主页
            gotoMainActivity();
        }
    };


    /**
     * 跳转主页方法
     */
    private void gotoMainActivity() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
