package com.example.viewpagertablayout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.viewpagertablayout.databinding.ItemVpBinding
import com.example.viewpagertablayout.models.User


class MyPageAdapter(var list: ArrayList<User>) : PagerAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemVpBinding =
            ItemVpBinding.inflate(LayoutInflater.from(container.context), container, false)
        itemVpBinding.BMW.setImageResource(list[position].image)
        itemVpBinding.tvText.text = list[position].name
        container.addView(itemVpBinding.root)
        return itemVpBinding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}