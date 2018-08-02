package com.reesehu.login

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.reesehu.componentbase.ServiceFactory

/**
 *  Function:
 *  <br/>
 *  Describe: 登录模块自定义路由过滤器
 *  <br/>
 *  Author: reese on 2018/8/2.
 *  <br/>
 *  Email: reese@jiuhuar.com
 */
@Interceptor(priority = 0, name = "登录状态拦截器")
class LoginInterceptor : IInterceptor {
    private var context: Context? = null
    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        // onContinue 和 onInterrupt 至少需要调用其中一种，否则不会继续路由

        if (postcard!!.path == "/share/share") {
            if (ServiceFactory.getInstance().accountService.isLogin) {
                callback!!.onContinue(postcard)  // 处理完成，交还控制权
            } else {
                Log.d("TAG", "被拦截，需要先登录！")
                Toast.makeText(context, "被拦截，需要先登录", Toast.LENGTH_LONG).show()
                callback!!.onInterrupt(RuntimeException("请登录")) // 中断路由流程
            }
        } else {
            callback!!.onContinue(postcard);  // 处理完成，交还控制权
        }
    }

    override fun init(mContext: Context?) {
        // 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
        context = mContext
    }
}