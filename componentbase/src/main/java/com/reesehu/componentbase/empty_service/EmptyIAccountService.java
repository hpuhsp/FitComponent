package com.reesehu.componentbase.empty_service;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import com.reesehu.componentbase.service.IAccountService;

/**
 * Function:
 * <br/>
 * Describe: 空实现类
 * <br/>
 * Author: reese on 2018/8/1.
 * <br/>
 * Email: reese@jiuhuar.com
 */
public class EmptyIAccountService implements IAccountService {
    @Override
    public boolean isLogin() {
        return false;
    }

    @Override
    public String getAccountId() {
        return null;
    }

    @Override
    public Fragment newUserFragment(Activity activity, int containerId, FragmentManager fragmentManager, Bundle bundle, String tag) {
        return null;
    }
}
