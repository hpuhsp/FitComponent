package com.reesehu.login.service;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.reesehu.componentbase.service.IAccountService;
import com.reesehu.login.fragment.UserFragment;

/**
 * Function:
 * <br/>
 * Describe:
 * <br/>
 * Author: reese on 2018/8/1.
 * <br/>
 * Email: reese@jiuhuar.com
 */
public class AccountService implements IAccountService {
    /**
     * 获取用户登录状态
     *
     * @return
     */
    @Override
    public boolean isLogin() {
        return false;
    }

    /**
     * 获取用户ID
     *
     * @return
     */
    @Override
    public String getAccountId() {
        return null;
    }

    @Override
    public Fragment newUserFragment(Activity activity, int containerId, FragmentManager fragmentManager, Bundle bundle, String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 创建 UserFragment 实例，并添加到 Activity 中
        Fragment userFragment = new UserFragment();
        transaction.add(containerId, userFragment, tag);
        transaction.commit();
        return userFragment;
    }
}
