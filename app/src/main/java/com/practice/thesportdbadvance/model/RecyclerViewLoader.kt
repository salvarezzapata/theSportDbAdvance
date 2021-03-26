package com.practice.thesportdbadvance.model

import androidx.recyclerview.widget.RecyclerView
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen
import com.ethanhua.skeleton.Skeleton
import com.practice.thesportdbadvance.R

class RecyclerViewLoader(private val recyclerView: RecyclerView) : ScreenLoader() {

    private var recyclerViewSkeletonScreen: RecyclerViewSkeletonScreen? = null

    override fun isConfigurationOn(): Boolean {
        return true
    }

    override fun showLoader() {
        recyclerViewSkeletonScreen = Skeleton.bind(recyclerView)
            .shimmer(true)
            .angle(20)
            .frozen(false)
            .duration(2000)
            .color(R.color.white_opaque)
            .count(6)
            .load(R.layout.skeleton_team_list_item)
            .show()
    }

    override fun hideLoader() {
        recyclerViewSkeletonScreen?.hide()
    }
}