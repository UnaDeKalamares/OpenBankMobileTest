package com.example.openbankmobiletest.master.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.openbankmobiletest.model.Character

class MasterActivityRecyclerViewAdapter(private val listener: MasterItemViewHolder.MasterItemViewHolderListener) : RecyclerView.Adapter<MasterItemViewHolder>() {

    var characters: ArrayList<Character> = ArrayList()

    fun addAll(newCharacters: List<Character>) {
        characters.addAll(newCharacters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MasterItemViewHolder {

        return MasterItemViewHolder(parent, listener)

    }

    override fun onBindViewHolder(holder: MasterItemViewHolder, position: Int) {

        holder.bind(characters[position])

    }

    override fun getItemCount(): Int {

        return characters.size

    }

}