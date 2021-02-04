package com.example.openbankmobiletest.master.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.openbankmobiletest.model.Character

class MasterActivityRecyclerViewAdapter : RecyclerView.Adapter<MasterItemViewHolder>() {

    private val characters: List<Character> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MasterItemViewHolder {

        return MasterItemViewHolder(parent)

    }

    override fun onBindViewHolder(holder: MasterItemViewHolder, position: Int) {

        holder.bind(characters[position])

    }

    override fun getItemCount(): Int {

        return characters.size

    }
}