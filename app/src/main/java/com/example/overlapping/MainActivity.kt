package com.example.overlapping

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.overlapping.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val adapters = ImgAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listImg.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = adapters
        }

        val list = listOf(
            fakeModel(1,
                listOf(R.drawable.ellipse_one,
                    R.drawable.ellipse_two,
                    R.drawable.ellipse_three,
                    R.drawable.ellipse_f,
                    R.drawable.ellipse_five,
                    R.drawable.ellipse_one,
                    R.drawable.ellipse_two,
                    R.drawable.ellipse_two,
                    R.drawable.ellipse_two,
                    R.drawable.ellipse_three)),
            fakeModel(2,
                listOf(R.drawable.ellipse_one,
                    R.drawable.ellipse_two,
                    R.drawable.ellipse_three,
                    R.drawable.ellipse_f,
                    R.drawable.ellipse_five,
                    R.drawable.ellipse_one,
                    R.drawable.ellipse_two,
                    R.drawable.ellipse_three)),
            fakeModel(3,
                listOf(R.drawable.ellipse_one,
                    R.drawable.ellipse_two,
                    R.drawable.ellipse_three,
                    R.drawable.ellipse_two,
                    R.drawable.ellipse_three)),
            fakeModel(4,
                listOf(R.drawable.ellipse_one,
                    R.drawable.ellipse_two,
                    R.drawable.ellipse_two,
                    R.drawable.ellipse_two,
                    R.drawable.ellipse_two,
                    R.drawable.ellipse_two,
                    R.drawable.ellipse_two,
                    R.drawable.ellipse_two,
                    R.drawable.ellipse_two,
                    R.drawable.ellipse_two,
                    R.drawable.ellipse_two,
                    R.drawable.ellipse_two,
                    R.drawable.ellipse_three,
                    R.drawable.ellipse_two,
                    R.drawable.ellipse_three))
        )
        adapters.submitList(list)
    }


}

data class fakeModel(val id: Int, val list: List<Int>)
