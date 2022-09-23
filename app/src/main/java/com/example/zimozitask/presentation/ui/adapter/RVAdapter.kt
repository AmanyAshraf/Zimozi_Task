package com.example.zimozitask.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zimozitask.data.model.Data
import com.example.zimozitask.databinding.RvItemBinding


class RvAdapter(var data: List<Data>) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount() = data.size

     class ViewHolder private constructor(private val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Data) = with(itemView) {
            binding.listItem=item
        }
        companion object {
            fun create(parent: ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RvItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}