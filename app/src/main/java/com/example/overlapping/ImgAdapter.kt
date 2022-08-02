package com.example.overlapping


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.overlapping.databinding.LayoutItemImgStudentBinding


class ImgAdapter : ListAdapter<fakeModel, ImgAdapter.ImgViewHolder>(IMgDiffUtil) {

    inner class ImgViewHolder(val binding: LayoutItemImgStudentBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ImgViewHolder {
        return ImgViewHolder(
            LayoutItemImgStudentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: ImgViewHolder,
        position: Int,
    ) {
        val item = getItem(position)

        var child: View? = null

        holder.binding.apply {
            layoutImg.removeAllViews()
            val list = item.list

            val size = if (list.size > 8) 8 else list.size


            for (img in 0 until size) {
                child =
                    LayoutInflater.from(holder.itemView.context).inflate(R.layout.item_img, null)
                val studentImg: ImageView = child!!.findViewById(R.id.img_item)
                studentImg.setImageResource(list[img])
                val layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)

                layoutParams.setMargins(0, 0, -40, 0)
                layoutImg.addView(child, layoutParams)
            }

            if (list.size > 8) {
                textView.text = "+${list.size - 8}"
            }

        }
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

}


object IMgDiffUtil : DiffUtil.ItemCallback<fakeModel>() {
    override fun areItemsTheSame(oldItem: fakeModel, newItem: fakeModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: fakeModel, newItem: fakeModel): Boolean {
        return oldItem == newItem
    }
}