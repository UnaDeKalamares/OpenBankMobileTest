package com.example.openbankmobiletest.master.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.openbankmobiletest.R
import com.example.openbankmobiletest.databinding.ItemMasterBinding
import com.example.openbankmobiletest.model.Character

class MasterItemViewHolder(itemView: View, private val listener: MasterItemViewHolderListener) : RecyclerView.ViewHolder(itemView) {

    private var binding: ItemMasterBinding = ItemMasterBinding.bind(itemView)

    constructor(parent: ViewGroup, listener: MasterItemViewHolderListener) : this(
        LayoutInflater.from(parent.context).inflate(R.layout.item_master, parent, false), listener
    )

    fun bind(character: Character) {

        binding.name.text = character.name
        binding.container.setOnClickListener { listener.onCharacterClick(character.id) }

    }

    interface MasterItemViewHolderListener {

        fun onCharacterClick(characterId: Int)

    }

}