package com.example.webgridcardview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.webgridcardview.databinding.GridviewItemBinding

class GridViewAdapter (
    private val list: List<GridViewModal>,
    private val context: Context
) : BaseAdapter () {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var binding: GridviewItemBinding

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return  0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        var convertView = convertView
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        if (convertView == null) {
            binding = GridviewItemBinding.inflate(layoutInflater!!,parent, false)

        } else {
            binding = GridviewItemBinding.bind(convertView)
        }

        binding.imageViewIV.setImageResource(list[position].image)
        binding.mainActivityNameBrowserTextViewTV.text = list[position].name


        return binding.root
    }
}