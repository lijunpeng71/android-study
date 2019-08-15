package com.cyinfo.android.study.activity;

import android.os.Bundle;
import android.view.Window;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.cyinfo.android.study.R;
import com.cyinfo.android.study.fragment.BookFragment;
import com.cyinfo.android.study.fragment.FavoriteFragment;
import com.cyinfo.android.study.fragment.FindFragment;
import com.cyinfo.android.study.fragment.LocationFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {
    @BindView(R.id.bottom_navigation_bar)
    public BottomNavigationBar bottomNavigationBar;

    private LocationFragment mLocationFragment;

    private FindFragment mFindFragment;

    private FavoriteFragment mFavoriteFragment;

    private BookFragment mBookFragment;

    private int lastSelectedPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_DEFAULT);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.ic_location_on_white_24dp, R.string.tab_location)).setActiveColor(R.color.orange)
                .addItem(new BottomNavigationItem(R.mipmap.ic_find_replace_white_24dp, R.string.tab_find)).setActiveColor(R.color.blue)
                .addItem(new BottomNavigationItem(R.mipmap.ic_favorite_white_24dp, R.string.tab_favorite)).setActiveColor(R.color.green)
                .addItem(new BottomNavigationItem(R.mipmap.ic_book_white_24dp, R.string.tab_book)).setActiveColor(R.color.blue)
                .setFirstSelectedPosition(lastSelectedPosition)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        mLocationFragment = LocationFragment.newInstance(R.string.tab_location);
        transaction.replace(R.id.tb, mLocationFragment);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (position) {
            case 0:
                if (mLocationFragment == null) {
                    mLocationFragment = LocationFragment.newInstance(R.string.tab_location);
                }
                transaction.replace(R.id.tb, mLocationFragment);
                break;
            case 1:
                if (mFindFragment == null) {
                    mFindFragment = FindFragment.newInstance(R.string.tab_find);
                }
                transaction.replace(R.id.tb, mFindFragment);
                break;
            case 2:
                if (mFavoriteFragment == null) {
                    mFavoriteFragment = FavoriteFragment.newInstance(R.string.tab_favorite);
                }
                transaction.replace(R.id.tb, mFavoriteFragment);
                break;
            case 3:
                if (mBookFragment == null) {
                    mBookFragment = BookFragment.newInstance(R.string.tab_book);
                }
                transaction.replace(R.id.tb, mBookFragment);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
