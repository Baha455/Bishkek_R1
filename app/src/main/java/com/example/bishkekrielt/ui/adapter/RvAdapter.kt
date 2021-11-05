package com.example.bishkekrielt.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bishkekrielt.R
import com.example.bishkekrielt.data.model.Recatalog
import com.example.bishkekrielt.databinding.RecyclerViewBinding
import com.example.bishkekrielt.ui.home.HomeViewModel


class RvAdapter(private val listener: (Recatalog) -> Unit) : RecyclerView.Adapter<RvAdapter.MyViewHolder>() {

    var items1 = arrayListOf<Recatalog>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            RecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }

    fun updateData(list: List<Recatalog>){
            this.items1.clear()
            this.items1.addAll(list)
            notifyDataSetChanged()


    }

    override fun getItemCount(): Int {
       return items1.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items1[position], listener)


    }

    class MyViewHolder(
    private val binding: RecyclerViewBinding): RecyclerView.ViewHolder(binding.root){

        private val slideAdapter by lazy { ViewPagerAdapter{

        } }

        fun bind(reCatalog: Recatalog, listener: (list: Recatalog) -> Unit){
            binding.price.text =  itemView.context.getString(R.string.priceFormat, reCatalog.price)
            binding.info.text = reCatalog.title
            binding.addres.text = reCatalog.location
            reCatalog.images.let { slideAdapter.update(it) }
            binding.image1.adapter = slideAdapter
            binding.itemConstr.setOnClickListener{
                listener.invoke(reCatalog)

            }
        }
    }
}