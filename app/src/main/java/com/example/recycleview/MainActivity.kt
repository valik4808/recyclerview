package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   lateinit var binding: ActivityMainBinding
   private val adapter = RecyclerAdapter()
    private val imageIdList = listOf(R.drawable.equi1, R.drawable.equi2,R.drawable.equi3,R.drawable.equi4,R.drawable.equi5)
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }
    private fun init() = with(binding){

            recView.layoutManager = LinearLayoutManager(this@MainActivity)
            recView.adapter = adapter
            buttonAdd.setOnClickListener {
                if(index > 4) index = 0
                val equipment = Equipment(imageIdList[index],"Equipment $index")
                adapter.addEquipment(equipment)
                index++

            }
    }
}