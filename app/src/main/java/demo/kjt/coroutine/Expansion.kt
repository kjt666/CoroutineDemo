package demo.kjt.coroutine

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.actor

/**
 * Created by kjt on 2019-07-30
 */
fun View.onClick(action: suspend (View) -> Unit) {
    var currentTime: Long
    var lastTime = 0L
    val eventAction = GlobalScope.actor<View>(Dispatchers.Main) {
            for (event in channel) action(event)
    }
    setOnClickListener {
        currentTime = System.currentTimeMillis()
        if (currentTime - lastTime >= 1500) {
            lastTime = currentTime
            eventAction.offer(it)
        }
    }
    /*val channel = Channel<View>(capacity = Channel.RENDEZVOUS)
    GlobalScope.launch(Dispatchers.Main) {
        for (item in channel) action(item)
    }
    setOnClickListener {
        GlobalScope.launch { channel.offer(it) }
    }*/
}

fun ImageView.loadUrl(url: String) {
    val options = RequestOptions.fitCenterTransform().placeholder(R.mipmap.ic_image_loading)
    Glide.with(this.context).setDefaultRequestOptions(options).load(url)
        .transition(DrawableTransitionOptions.withCrossFade()).into(this)
}