package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ColorAdapter.CellClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.rView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ColorAdapter(this, ListColor(), this)
    }

    private fun ListColor(): ArrayList<ColorData> {
        val list = arrayListOf<ColorData>()

        val Black = ColorData("#FF000000",
            "BLACK")
        val Orange = ColorData("#FFA500",
            "ORANGE")
        val Blue = ColorData("#0000FF",
            "BLUE")
        val Red = ColorData("#FF0000",
            "RED")
        val Purple = ColorData("#800080",
            "PURPLE")

        list.add(Orange)
        list.add(Black)
        list.add(Blue)
        list.add(Red)
        list.add(Purple)

        return list
    }

    data class ColorData(
        val colorHex: String,
        val colorName: String
    )
}
