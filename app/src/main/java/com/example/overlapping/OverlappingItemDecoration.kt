package com.example.overlapping

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView



class OverlappingItemDecoration(private val space:Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        if (parent.getChildAdapterPosition(view) != RecyclerView.NO_POSITION) {
            outRect.set(0, 0, -60, -60)
        }
    }

}