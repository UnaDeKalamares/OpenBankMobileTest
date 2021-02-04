package com.example.openbankmobiletest.master.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.openbankmobiletest.R
import com.example.openbankmobiletest.databinding.ItemMasterBinding
import com.example.openbankmobiletest.model.Character

class MasterItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var binding: ItemMasterBinding = ItemMasterBinding.bind(itemView)

    constructor(parent: ViewGroup) : this(
        LayoutInflater.from(parent.context).inflate(R.layout.item_master, parent, false)
    )

    fun bind(character: Character) {

        binding.name.text = character.name

    }

}