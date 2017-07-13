package com.lsy.hebao.app;

import android.app.Application;
import android.content.Context;


import java.io.File;

import me.yokeyword.fragmentation.BuildConfig;
import me.yokeyword.fragmentation.Fragmentation;
import me.yokeyword.fragmentation.helper.ExceptionHandler;

/**
 * Created by lsy on 2017/4/17.
 */

public class HebaoApplication extends Application {
    public static Context context = null;
    private static HebaoApplication application;


    /**
     * 获取Application 运行实例
     * @return
     */
    public static HebaoApplication getInstance() {
        return application;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        context=getApplicationContext();

        Fragmentation.builder()
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(BuildConfig.DEBUG)
                .handleException(new ExceptionHandler() {
                    @Override
                    public void onException(Exception e) {
                    }
                })
                .install();
    }




    /**
     * 获取Context实力
     * @return
     */
    public static Context getContext(){
        if (null!=context) {
            return context;
        }
        return application.getApplicationContext();

    }

}
