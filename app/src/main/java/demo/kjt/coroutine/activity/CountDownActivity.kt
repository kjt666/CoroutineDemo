package demo.kjt.coroutine.activity

import android.os.Bundle
import android.view.View
import demo.kjt.coroutine.R
import demo.kjt.coroutine.onClick
import kotlinx.android.synthetic.main.activity_count_down.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay

@ExperimentalCoroutinesApi
class CountDownActivity : ScopedActivity() {

    lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_down)
        title = "CountDownActivity"
        /*tv_countdown.setOnClickListener {
            job = launch {
                btn_stop.visibility = View.VISIBLE
                tv_countdown.isClickable = false
                for (i in 10 downTo 1) {
                    tv_countdown.text = "$i"
                    delay(1000)
                }
                btn_stop.visibility = View.GONE
                tv_countdown.text = "reStart"
                tv_countdown.isClickable = true
            }
        }
        btn_stop.setOnClickListener {
            job.cancel()
            btn_stop.visibility = View.GONE
            tv_countdown.isClickable = true
            btn_stop.text = "reStart"
        }*/
        tv_countdown.onClick {
            for (i in 10 downTo 1) {
                tv_countdown.text = "$i"
                delay(1000)
            }
            tv_countdown.text = "reStart"
        }
    }

}
