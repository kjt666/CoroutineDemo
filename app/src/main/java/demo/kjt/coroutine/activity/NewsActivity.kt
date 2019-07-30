package demo.kjt.coroutine.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.csp.coroutines.NewsAdapter
import com.csp.coroutines.NewsBean
import com.csp.coroutines.net.ApiManager
import com.google.gson.Gson
import demo.kjt.coroutine.R
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.coroutines.*

class NewsActivity : ScopedActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        loadNews()
    }

    @ExperimentalCoroutinesApi
    private fun loadNews() {
        Log.i("kkk","Before launch")
        launch(CoroutineExceptionHandler { _, throwable -> Log.e("kkk", throwable.message) },start = CoroutineStart.UNDISPATCHED) {
            Log.i("kkk","Inside coroutine")
            delay(5000)
            val newsBean = ApiManager.getInstance().getApiService().getNews("top", "75c088a1daa9e51b558a74e2049c1aa0").await()
            Log.i("kkk", Gson().toJson(newsBean))
            initRecycler(newsBean.result.data)
        }
        Log.i("kkk","After launch")
    }

    private fun initRecycler(data: List<NewsBean.Result.Data>) {
        val adapter = NewsAdapter(this@NewsActivity, data)
        val manager = LinearLayoutManager(this)
        listView.adapter = adapter
        listView.layoutManager = manager
    }
}
