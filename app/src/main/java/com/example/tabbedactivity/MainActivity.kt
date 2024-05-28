package com.example.tabbedactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(MoviesFragment.newInstance("Боевик"), "Боевик")
        adapter.addFragment(MoviesFragment.newInstance("Комедия"), "Комедия")
        adapter.addFragment(MoviesFragment.newInstance("Драма"), "Драма")

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}

