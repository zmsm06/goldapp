package com.zeinabmallaki.goldapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.zeinabmallaki.goldapp.databinding.RecyclerMainItemBinding
import com.zeinabmallaki.goldapp.remote.dataModel.dataModel.ContentModel

class RecyclerMainAdapter(

    private val allData : ArrayList<ContentModel>


):RecyclerView.Adapter<RecyclerMainAdapter.MainViewHolder>() {
    inner class MainViewHolder (
        private val binding: RecyclerMainItemBinding
            ): ViewHolder(binding.root){

                fun setData(data: ContentModel){
                    binding.txtLabel.text = data.label
                    binding.txtPrice.text = (data.price /10).toString()

                }

            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        return MainViewHolder(
            RecyclerMainItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int = allData.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        holder.setData(allData[position])

    }
}