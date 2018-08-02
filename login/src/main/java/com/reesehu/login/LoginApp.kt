package com.reesehu.login

import android.app.Application
import com.reesehu.base.BaseApp
import com.reesehu.componentbase.ServiceFactory
import com.reesehu.login.service.AccountService

/**
 * Function:
 * <br></br>
 * Describe:
 * <br></br>
 * Author: reese on 2018/8/1.
 * <br></br>
 * Email: reese@jiuhuar.com
 */
class LoginApp : BaseApp() {
    override fun onCreate() {
        super.onCreate()
        initModuleApp(this)
        initModuleData(this)
    }

    override fun initModuleData(application: Application) {
    }

    override fun initModuleApp(application: Application) {
        ServiceFactory.getInstance().accountService = AccountService()
    }


    override fun showTime() {

    }
}
