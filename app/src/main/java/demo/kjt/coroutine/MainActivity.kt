package demo.kjt.coroutine

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_countdown.setOnClickListener {
            startActivity(Intent(this,CountDownActivity::class.java))
        }
        btn_fib.setOnClickListener {
            startActivity(Intent(this,FibActivity::class.java))
        }
    }
}
