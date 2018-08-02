package com.reesehu.base

import android.app.Application

/**
 * Function:
 * <br></br>
 * Describe: 基础Application
 * <br></br>
 * Author: reese on 2018/8/1.
 * <br></br>
 * Email: reese@jiuhuar.com
 */
public abstract class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    // Application的初始化
    abstract fun initModuleApp(application: Application)

    // Application 初始化后的自定义操作
    abstract fun initModuleData(application: Application)

    protected abstract fun showTime()
}
