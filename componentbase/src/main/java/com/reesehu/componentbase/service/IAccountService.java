package com.reesehu.componentbase.service;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

/**
 * Function:
 * <br/>
 * Describe:
 * <br/>
 * Author: reese on 2018/8/1.
 * <br/>
 * Email: reese@jiuhuar.com
 */
public interface IAccountService {
    /**
     * 是否已经登录
     *
     * @return
     */
    boolean isLogin();

    /**
     * 获取登录用户的 AccountId
     *
     * @return
     */
    String getAccountId();

    Fragment newUserFragment(Activity activity, int containerId, FragmentManager fragmentManager, Bundle bundle, String
            tag);
}
