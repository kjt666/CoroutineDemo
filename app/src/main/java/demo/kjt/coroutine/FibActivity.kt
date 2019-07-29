package demo.kjt.coroutine

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fib.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class FibActivity : ScopedActivity() {

    private var mKey = 0
    private var mValue = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fib)
        launch {
            var count = 0
            while (true){
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
                mKey += 5
                mValue = "fib($mKey) = ..."
                mValue = "fib($mKey) = ${fib(mKey)}"
            }
        }
    }

    private fun fib(x: Int): Int =
        if (x <= 1) x else fib(x - 1) + fib(x - 2)

}
