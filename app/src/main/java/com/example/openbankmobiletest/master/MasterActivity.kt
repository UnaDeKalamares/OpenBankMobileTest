package com.example.openbankmobiletest.master

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.openbankmobiletest.databinding.ActivityMasterBinding
import com.example.openbankmobiletest.master.recyclerview.MasterActivityRecyclerViewAdapter

class MasterActivity : Activity() {

    private lateinit var binding: ActivityMasterBinding
    private lateinit var adapter: MasterActivityRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMasterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MasterActivityRecyclerViewAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this@MasterActivity)
    }

}