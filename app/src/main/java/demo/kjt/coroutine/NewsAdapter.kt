package com.csp.coroutines

import android.content.Context
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.util.MultiTypeDelegate
import demo.kjt.coroutine.R
import demo.kjt.coroutine.loadUrl


/**
 * Created by kjt on 2019/3/20
 */
class NewsAdapter(val ctx: Context, data: List<NewsBean.Result.Data>) : BaseQuickAdapter<NewsBean.Result.Data, BaseViewHolder>(data) {

    init {
        multiTypeDelegate = object : MultiTypeDelegate<NewsBean.Result.Data>() {
            override fun getItemType(entity: NewsBean.Result.Data): Int {
                //根据你的实体类来判断布局类型
                return if (entity.thumbnailPicS03.isNotEmpty()) NewsBean.MULLTI else NewsBean.SINGLE
            }
        }
        multiTypeDelegate.registerItemType(NewsBean.SINGLE, R.layout.item_news)
        multiTypeDelegate.registerItemType(NewsBean.MULLTI, R.layout.item_news_multi)
    }

    override fun convert(helper: BaseViewHolder, item: NewsBean.Result.Data) {
        helper.setText(R.id.title, item.title)
        helper.setText(R.id.type, item.category)
        helper.setText(R.id.realType, item.authorName)
        helper.setText(R.id.date, item.date)
        when (helper.itemViewType) {
            NewsBean.SINGLE -> {
                helper.getView<ImageView>(R.id.img).loadUrl(item.thumbnailPicS)
            }
            NewsBean.MULLTI -> {
                helper.getView<ImageView>(R.id.imgOne).loadUrl(item.thumbnailPicS)
                helper.getView<ImageView>(R.id.imgTwo).loadUrl(item.thumbnailPicS02)
                helper.getView<ImageView>(R.id.imgThree).loadUrl(item.thumbnailPicS03)
            }
        }
    }
}