package com.reesehu.share

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.reesehu.componentbase.ServiceFactory

@Route(path = "/share/share")
class ShareActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        share()
    }

    private fun share() {
        if (ServiceFactory.getInstance().accountService.isLogin) {
            Log.d("TAG", "登录成功")
        } else {
            Log.d("TAG", "登录失败")
        }
    }
}
