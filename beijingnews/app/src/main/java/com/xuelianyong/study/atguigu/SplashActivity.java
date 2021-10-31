package com.xuelianyong.study.atguigu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.xuelianyong.study.atguigu.activity.GuideActivity;
import com.xuelianyong.study.atguigu.activity.MainActivity;
import com.xuelianyong.study.atguigu.utils.CacheUtils;

public class SplashActivity extends Activity {

    /**
     * 静态常量
     */
    public static final String START_MAIN = "start_main";


    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        relativeLayout=findViewById(R.id.rl_splash_root);

        AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
        alphaAnimation.setFillAfter(true);

        ScaleAnimation scaleAnimation=new ScaleAnimation(0,1,0,1,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f);
        alphaAnimation.setFillAfter(true);

        RotateAnimation rotateAnimation= new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setFillAfter(true);
        //动画集合
        AnimationSet animationSet=new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.setDuration(1000);
        relativeLayout.setAnimation(animationSet);
        //动画播放监听事件
        animationSet.setAnimationListener(new MyAnimationListener());
    }

    class MyAnimationListener implements AnimationSet.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            /**
             * 判断是否进入过主界面
             * 如果进入过：则直接进入主界面
             * 如果没有进入过：则进入引导页
             */
            boolean isStartMain=CacheUtils.getBoolean(SplashActivity.this,START_MAIN);
            Intent intent=null;
            if(isStartMain){
                intent=new Intent(SplashActivity.this, MainActivity.class);
            }else{
                intent=new Intent(SplashActivity.this, GuideActivity.class);
            }
            startActivity(intent);
            finish();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}