package com.reesehu.fitcomponent;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Function:
 * <br/>
 * Describe:
 * <br/>
 * Author: reese on 2018/8/2.
 * <br/>
 * Email: reese@jiuhuar.com
 */
public class Test {
    public void testJn(Context context) {
        ARouter.getInstance().build("").navigation(context, new NavigationCallback() {
            @Override
            public void onFound(Postcard postcard) {

            }

            @Override
            public void onLost(Postcard postcard) {

            }

            @Override
            public void onArrival(Postcard postcard) {

            }

            @Override
            public void onInterrupt(Postcard postcard) {

            }
        });
    }
}
