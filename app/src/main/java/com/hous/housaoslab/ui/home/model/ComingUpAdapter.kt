package com.hous.housaoslab.ui.home.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hous.housaoslab.databinding.ItemHomeComingUpBinding

class ComingUpAdapter : RecyclerView.Adapter<ComingUpAdapter.ComingUpViewHolder>() {
    val comingUpList = mutableListOf<ComingUpData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComingUpViewHolder {
        val binding =
            ItemHomeComingUpBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ComingUpViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComingUpViewHolder, position: Int) {
        holder.onBind(comingUpList[position])
    }

    override fun getItemCount(): Int = comingUpList.size

    class ComingUpViewHolder(
        private val binding: ItemHomeComingUpBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ComingUpData) {
            binding.ivHomeComingUpShape.setImageResource(data.shape)
            binding.ivHomeComingUpImage.setImageResource(data.image)
            binding.tvHomeComingUpDay.text = data.day
            binding.position = adapterPosition
        }
    }
}