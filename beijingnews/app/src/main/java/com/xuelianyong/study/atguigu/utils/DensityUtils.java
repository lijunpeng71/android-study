package com.xuelianyong.study.atguigu.utils;

import android.content.Context;

public class DensityUtils {

    /**
     * 根据手机的分辨率从dip的单位转成px(像素)
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context,float dpValue){
        final float scale=context.getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);
    }

    /**
     * 根据手机的分比率从 px(像素) 的单位 转成 dp
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context,float pxValue){
        final float scale=context.getResources().getDisplayMetrics().density;
        return (int)(pxValue/scale+0.5f);
    }
}
