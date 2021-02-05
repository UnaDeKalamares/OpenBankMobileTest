package com.example.openbankmobiletest.master.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.openbankmobiletest.databinding.ActivityMasterBinding
import com.example.openbankmobiletest.detail.DetailActivity
import com.example.openbankmobiletest.master.viewmodel.MasterViewModel
import com.example.openbankmobiletest.master.recyclerview.MasterActivityRecyclerViewAdapter
import com.example.openbankmobiletest.master.recyclerview.MasterItemViewHolder
import com.example.openbankmobiletest.model.CharacterDataWrapper
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import java.util.*
import javax.inject.Inject

class MasterActivity : AppCompatActivity(), HasAndroidInjector,
    MasterItemViewHolder.MasterItemViewHolderListener {

    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Any?>

    @Inject lateinit var viewModel: MasterViewModel
    private lateinit var binding: ActivityMasterBinding
    private lateinit var adapter: MasterActivityRecyclerViewAdapter

    override fun androidInjector(): AndroidInjector<Any?> {
        return androidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)

        binding = ActivityMasterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MasterActivityRecyclerViewAdapter(this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this@MasterActivity)

        initObserver()

        viewModel.getCharacters()

    }

    private fun initObserver() {

        val characterObserver = Observer<CharacterDataWrapper> { newWrapper ->
            adapter.addAll(newWrapper.data.results)
        }

        viewModel.characterDataWrapper.observe(this, characterObserver)

    }

    override fun onCharacterClick(characterId: Int) {

        val intent = Intent(this@MasterActivity, DetailActivity::class.java).apply {
            putExtra(DetailActivity.CHARACTER_ID_ARG, characterId)
        }
        startActivity(intent)

    }

}