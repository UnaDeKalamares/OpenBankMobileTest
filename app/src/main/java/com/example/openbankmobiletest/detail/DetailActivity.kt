package com.example.openbankmobiletest.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.openbankmobiletest.databinding.ActivityDetailBinding
import com.example.openbankmobiletest.model.CharacterDataWrapper
import com.example.openbankmobiletest.utils.ImageUtils
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), HasAndroidInjector {

    companion object {

        const val CHARACTER_ID_ARG = "CHARACTER_ID_ARG"

    }

    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Any?>

    @Inject lateinit var viewModel: DetailViewModel
    private lateinit var binding: ActivityDetailBinding

    override fun androidInjector(): AndroidInjector<Any?> {
        return androidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let {

            if (it.containsKey(CHARACTER_ID_ARG)) {

                val characterId = it.getInt(CHARACTER_ID_ARG)
                viewModel.getCharacterById(characterId)

            }

        }

        initObserver()

    }

    private fun initObserver() {

        val characterObserver = Observer<CharacterDataWrapper> { newWrapper ->
            val character = newWrapper.data.results[0]
            val path = ImageUtils.getImageURL(character.thumbnail, ImageUtils.IMAGE_SIZES.PORTRAIT_UNCANNY)
            Glide.with(this@DetailActivity).load(path).into(binding.image)
        }

        viewModel.characterDataWrapper.observe(this, characterObserver)

    }

}