package com.xuelianyong.study.atguigu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.xuelianyong.study.atguigu.R;
import com.xuelianyong.study.atguigu.SplashActivity;
import com.xuelianyong.study.atguigu.utils.CacheUtils;
import com.xuelianyong.study.atguigu.utils.DensityUtils;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends Activity {

    private ViewPager viewPager;
    private Button btnStartMain;
    private LinearLayout llPointGroup;
    private ImageView ivRedPoint;

    private List<ImageView> imageViewList;

    /**
     * 两点的间距
     */
    private int leftMax;

    private int widthDpi,heightDpi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        viewPager=findViewById(R.id.view_pager);
        btnStartMain=findViewById(R.id.btn_start_main);
        llPointGroup=findViewById(R.id.ll_point_group);
        ivRedPoint=findViewById(R.id.iv_red_point);

        //准备数据
        int[] ids=new int[]{R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
        imageViewList=new ArrayList<>();
        for(int i=0;i<ids.length;i++){
            ImageView imageView=new ImageView(this);
            imageView.setBackgroundResource(ids[i]);
            //添加到集合中
            imageViewList.add(imageView);
            //创建点，添加到线性布局里面
            ImageView pointView=new ImageView(this);
            pointView.setBackgroundResource(R.drawable.point_gray);
            //单位像数
            widthDpi= DensityUtils.dip2px(this,10);
            heightDpi=DensityUtils.dip2px(this,10);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(widthDpi,heightDpi);
            if(i!=0){
                //不包括第一个点，其他点距离左边有10个像素
                params.leftMargin=widthDpi;
            }
            pointView.setLayoutParams(params);
            //添加到线性布局里面
            llPointGroup.addView(pointView);

        }
        //设置ViewPager适配器
        viewPager.setAdapter(new MyPageAdapter());

        //根据view的生命周期，当视图执行到onLayout或者onDraw的时候，视图的高和宽，边距都有了
        ivRedPoint.getViewTreeObserver().addOnGlobalLayoutListener(new MyOnGlobalLayoutListener());
        //得到屏幕滑动的百分比
        viewPager.addOnPageChangeListener(new MyOnPageChangeListener());
        //设置按钮的点击事件
        btnStartMain.setOnClickListener(new MyOnClickListener());
    }

    class MyOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //1.保存曾经进入过主页面
            CacheUtils.putBoolean(GuideActivity.this, SplashActivity.START_MAIN,true);
            //2.跳转到主页面
            Intent intent=new Intent(GuideActivity.this,MainActivity.class);
            startActivity(intent);
            //关闭引导页
            finish();
        }
    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{
        /**
         * 在页面滑动时
         * @param position 当前滑动页面的位置
         * @param positionOffset 页面滑动的百分比
         * @param positionOffsetPixels 滑动的像素
         */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            int leftMargin = position * leftMax + (int)(positionOffset * leftMax);
            RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) ivRedPoint.getLayoutParams();
            params.leftMargin=leftMargin;
            ivRedPoint.setLayoutParams(params);
        }

        /**
         * 当页面选中时回调方法
         * @param position
         */
        @Override
        public void onPageSelected(int position) {
            if(position==imageViewList.size()-1){
                //最后一个页面
                btnStartMain.setVisibility(Button.VISIBLE);
            }else{
                btnStartMain.setVisibility(Button.GONE);
            }
        }

        /**
         * 当页面滑动状态改变时的回调方法
         * @param state
         */
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    class MyOnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener{

        @Override
        public void onGlobalLayout() {
            //执行不止一次
            ivRedPoint.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            //两点之间的间距
            leftMax=llPointGroup.getChildAt(1).getLeft()-llPointGroup.getChildAt(0).getLeft();
        }
    }

    class MyPageAdapter extends PagerAdapter {
        /**
         * 返回数据的总个数
         * @return
         */
        @Override
        public int getCount() {
            return imageViewList.size();
        }

        /**
         * getView
         * @param container
         * @param position
         * @return 返回和创建当前页面有关系值
         */
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView imageView=imageViewList.get(position);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}