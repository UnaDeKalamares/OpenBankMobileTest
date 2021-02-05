package com.example.openbankmobiletest.utils

import com.example.openbankmobiletest.model.Image

class ImageUtils {

    enum class IMAGE_SIZES(val value: String) {
        PORTRAIT_UNCANNY("portrait_uncanny")
    }

    companion object {

        fun getImageURL(image: Image, size: IMAGE_SIZES) : String {

            // Marvel provides unsecure url, which doesn't load with Glide
            val fixedImagePath = image.path.replace("http", "https")
            return fixedImagePath + "/" + size.value + "." + image.extension

        }

    }

}