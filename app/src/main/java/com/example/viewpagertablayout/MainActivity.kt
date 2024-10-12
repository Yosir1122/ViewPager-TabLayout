package com.example.viewpagertablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.viewpagertablayout.adapter.MyPageAdapter
import com.example.viewpagertablayout.databinding.ActivityMainBinding
import com.example.viewpagertablayout.utils.MyData
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var myPageAdapter: MyPageAdapter
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        MyData.addUser()

        myPageAdapter = MyPageAdapter(MyData.list)
        binding.pg.adapter = myPageAdapter
        loadTabLayout()
    }

    private fun loadTabLayout() {
        val tabCount = binding.myTab.tabCount

        for (i in 0 until tabCount) {
            val tabView = LayoutInflater.from(this).inflate(R.layout.item_tab_layout, null, false)
            val tab = binding.myTab.getTabAt(i)
            tab?.customView = tabView
            tabView.findViewById<TextView>(R.id.tv_tabTitle).text = MyData.list[i].name
            val imageView = tabView.findViewById<ImageView>(R.id.tab_img)
            if (i == 0) {
                imageView.visibility = View.VISIBLE
            } else {
                imageView.visibility = View.GONE
            }
        }
        binding.myTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val costomView = tab?.customView
                val image = costomView?.findViewById<ImageView>(R.id.tab_img)
                image?.visibility = View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val costomView = tab?.customView
                val image = costomView?.findViewById<ImageView>(R.id.tab_img)
                image?.visibility = View.GONE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }
        })
    }
}