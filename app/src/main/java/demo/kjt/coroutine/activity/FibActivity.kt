package demo.kjt.coroutine.activity

import android.os.Bundle
import demo.kjt.coroutine.R
import kotlinx.android.synthetic.main.activity_fib.*
import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
class FibActivity : ScopedActivity() {

    private var mKey = 0
    private var mValue = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fib)
        launch {
            var count = 0
            while (true) {
                tv_value.text = "${++count}:\n$mValue"
                delay(100)
            }
        }
        btn_key.setOnClickListener {
            /*launch {
                mKey += 5
                mValue = "fib($mKey) = ..."
                delay(100)
                mValue = "fib($mKey) = ${fib(mKey)}"
            }*/
            launch(Dispatchers.IO) {
                btn_key.isClickable = false
                mKey += 5
                mValue = "fib($mKey) = ..."
                mValue = "fib($mKey) = ${fib(mKey)}"
                btn_key.isClickable = true
            }
        }
    }

    private fun fib(x: Int): Int =
        if (x <= 1) x else fib(x - 1) + fib(x - 2)

}
