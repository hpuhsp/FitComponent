package com.reesehu.base.config;

/**
 * Function:
 * <br/>
 * Describe:
 * <br/>
 * Author: reese on 2018/8/1.
 * <br/>
 * Email: reese@jiuhuar.com
 */
public class AppConfig {
    private static final String LoginApp = "com.reesehu.login.LoginApp";
    // 记录需要初始化的Application的类完整路径
    public static String[] moduleApps = {
            LoginApp
    };
}
