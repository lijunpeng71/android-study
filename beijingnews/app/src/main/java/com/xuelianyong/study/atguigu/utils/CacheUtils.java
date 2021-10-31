package com.xuelianyong.study.atguigu.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.xuelianyong.study.atguigu.activity.GuideActivity;

public class CacheUtils {

    /**
     * 静态常量
     */
    public static final String ATGUIGU="atguigu";
    /**
     * 获取boolean缓存
     * @param context
     * @param key
     * @return
     */
    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ATGUIGU,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key,false);
    }

    /**
     * 这种boolean缓存
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static boolean putBoolean(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ATGUIGU,Context.MODE_PRIVATE);
        return sharedPreferences.edit().putBoolean(key,value).commit();
    }
}
