package com.reesehu.fitcomponent

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_scrolling.*
import kotlinx.android.synthetic.main.content_scrolling.*

class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        btn_login.setOnClickListener {
            intentToLoginPage()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> {
                intentToLoginPage()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun intentToLoginPage() {
        ARouter.getInstance().build("/account/login")
                .navigation(this, object : NavigationCallback {
                    override fun onFound(postcard: Postcard) {
                        Log.d("TAG", "-----onFound--->" + postcard.group)
                    }

                    override fun onLost(postcard: Postcard) {
                        Log.d("TAG", "---onLost----->" + postcard.group)

                    }

                    override fun onArrival(postcard: Postcard) {
                        Log.d("TAG", "----onArrival---->" + postcard.group)

                    }

                    override fun onInterrupt(postcard: Postcard) {
                        Log.d("TAG", "----onInterrupt---->" + postcard.group)
                        // 通过组件提供的 Service 实现 Fragment 的实例化
//                        ServiceFactory.getInstance().getAccountService().newUserFragment(this, R.id.layout_fragment, getSupportFragmentManager(), null, "");

                    }
                })
    }
}
