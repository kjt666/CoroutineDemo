package demo.kjt.coroutine.activity

import android.support.v7.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

/**
 * Created by kjt on 2019-07-29
 */
@ExperimentalCoroutinesApi
abstract class ScopedActivity:AppCompatActivity(),CoroutineScope by MainScope() {

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}