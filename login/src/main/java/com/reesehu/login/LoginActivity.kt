package com.reesehu.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 需要注意的是，如果不使用自动注入，那么可以不写 ARouter.getInstance().inject(this)，
 * 但是需要取值的字段仍然需要标上 @Autowired 注解，因为 只有标上注解之后，
 * ARouter才能知道以哪一种数据类型提取URL中的参数并放入Intent中，这样您才能在intent中获取到对应的参数
 */
@Route(path = "/account/login")
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 如果需要接收 URL 中的参数，需要在 Activity 调用自动注入初始化方法
        ARouter.getInstance().inject(this)

//        setSupportActionBar(toolbar)
        if (intent.hasExtra("user_name")) {
            System.out.print("---TAG------->" + intent.getStringExtra("user_name"))
        }

        fab.setOnClickListener {
            //            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
            ARouter.getInstance()
                    .build("/share/share")
                    .navigation()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
