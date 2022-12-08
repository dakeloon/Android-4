package com.example.recyclerview

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ColorAdapter(private val context: Context,
              private val list: ArrayList<ColorData>,
              private val cellClickListener: CellClickListener
) : RecyclerView.Adapter<ColorAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val view: View = view.findViewById(R.id.view)
        val text: TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rview_item,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.view.setBackgroundColor(Color.parseColor(data.colorHex))
        holder.text.text = data.colorName
        holder.view.setOnClickListener {
            cellClickListener.onCellClickListener(context, data)
        }
        holder.text.setOnClickListener{
            cellClickListener.onCellClickListener(context, data)
        }
    }

    interface CellClickListener {
        fun onCellClickListener(context: Context, data: ColorData) {
            Toast.makeText(context, "IT`S " + data.colorName, Toast.LENGTH_SHORT).show()
        }

    }

}
