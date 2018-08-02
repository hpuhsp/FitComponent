package com.reesehu.fitcomponent

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.reesehu.base.BaseApp
import com.reesehu.base.config.AppConfig

/**
 * Function:
 * <br></br>
 * Describe:
 * <br></br>
 * Author: reese on 2018/8/1.
 * <br></br>
 * Email: reese@jiuhuar.com
 */
class MyApplication : BaseApp() {

    override fun onCreate() {
        super.onCreate()
        // 初始化ARouter
        if (isDebug()) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)

        initModuleApp(this)
        initModuleData(this)
    }

    /**
     * 所有组件的初始化操作
     */
    override fun initModuleApp(application: Application) {
        for (moduleApp in AppConfig.moduleApps) {
            try {
                val clz = Class.forName(moduleApp)
                var baseApp: BaseApp = clz.newInstance() as BaseApp
                baseApp.initModuleApp(this)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    /**
     * 组件初始化完成后的操作
     */
    override fun initModuleData(application: Application) {
        for (moduleApp in AppConfig.moduleApps) {
            try {
                val clz = Class.forName(moduleApp)
                var baseApp: BaseApp = clz.newInstance() as BaseApp
                baseApp.initModuleData(this)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun showTime() {

    }


    private fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }
}
