package com.example.bishkekrielt.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bishkekrielt.data.model.Images
import com.example.bishkekrielt.databinding.ViewpagerViewBinding
import com.squareup.picasso.Picasso

class ViewPagerAdapter(private val listener: (item: Images) -> Unit): RecyclerView.Adapter<PagerViewHolder>() {

    var list = arrayListOf<Images>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val binding =
            ViewpagerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(list[position], listener)
    }

    fun update(list: List<Images>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount() = list.size
}

class PagerViewHolder(private val binding: ViewpagerViewBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(item: Images, listener: (item: Images) -> Unit){
        Picasso.get()
            .load(item.image)
            .into(binding.viewpagerImage)

    }

}