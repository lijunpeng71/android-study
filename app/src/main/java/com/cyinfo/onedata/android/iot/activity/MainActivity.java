package com.cyinfo.onedata.android.iot.activity;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.cyinfo.onedata.android.iot.R;
import com.cyinfo.onedata.android.iot.base.BaseActivity;
import com.cyinfo.onedata.android.iot.fragment.DashboardFragment;
import com.cyinfo.onedata.android.iot.fragment.DeviceFragment;
import com.cyinfo.onedata.android.iot.fragment.MainFragment;
import com.cyinfo.onedata.android.iot.fragment.MineFragment;
import com.cyinfo.onedata.android.iot.fragment.MyFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.fragment_view_page)
    public ViewPager viewPager;


    @BindView(R.id.tab_radio_group)
    public RadioGroup radioGroup;


    private List<Fragment> fragmentList;


    private FragmentPagerAdapter adapter;


    @Override
    protected int getLayoutId() {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        fragmentList = new ArrayList<>(4);
        fragmentList.add(new MainFragment());
        fragmentList.add(new DashboardFragment());
        fragmentList.add(new DeviceFragment());
        fragmentList.add(new MineFragment());

        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(myPageChangeListener);
        radioGroup.setOnCheckedChangeListener(myOnCheckedChangeListener);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewPager.removeOnPageChangeListener(myPageChangeListener);
    }


    private ViewPager.OnPageChangeListener myPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            RadioButton radioButton = (RadioButton) radioGroup.getChildAt(position);
            radioButton.setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private RadioGroup.OnCheckedChangeListener myOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            for (int i = 0; i < group.getChildCount(); i++) {
                if (group.getChildAt(i).getId() == checkedId) {
                    viewPager.setCurrentItem(i);
                    return;
                }
            }
        }
    };

}
