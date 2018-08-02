package com.reesehu.componentbase;

import com.reesehu.componentbase.empty_service.EmptyIAccountService;
import com.reesehu.componentbase.empty_service.EmptyIShareService;
import com.reesehu.componentbase.service.IAccountService;
import com.reesehu.componentbase.service.IShareService;

/**
 * Function:
 * <br/>
 * Describe: 待定，可以仿照Retrofit库进行封装处理
 * <br/>
 * Author: reese on 2018/8/1.
 * <br/>
 * Email: reese@jiuhuar.com
 */
public class ServiceFactory {
    private IAccountService accountService; // Login组件对外暴露
    private IShareService mIShareService; // 分享对外暴露

    /**
     * 禁止外部创建 ServiceFactory 对象
     */
    private ServiceFactory() {
    }

    /**
     * 通过静态内部类方式实现 ServiceFactory 的单例
     */
    public static ServiceFactory getInstance() {
        return Inner.serviceFactory;
    }

    private static class Inner {
        private static ServiceFactory serviceFactory = new ServiceFactory();
    }

    /**
     * 接收 Login 组件实现的 Service 实例
     */
    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 返回 Login 组件的 Service 实例
     */
    public IAccountService getAccountService() {
        if (accountService == null) {
            accountService = new EmptyIAccountService();
        }
        return accountService;
    }

    public IShareService getIShareService() {
        if (null == mIShareService) {
            mIShareService = new EmptyIShareService();
        }
        return mIShareService;
    }

    public void setIShareService(IShareService mIShareService) {
        this.mIShareService = mIShareService;
    }
}
