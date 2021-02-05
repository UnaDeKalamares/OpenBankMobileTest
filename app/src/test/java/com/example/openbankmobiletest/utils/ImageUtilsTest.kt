package com.example.openbankmobiletest.utils

import com.example.openbankmobiletest.model.Image
import org.junit.Assert.assertEquals
import org.junit.Test

class ImageUtilsTest {

    @Test
    fun image_url_correct() {

        val result = ImageUtils.getImageURL(Image("http://testpath/res/1", "jpg"), ImageUtils.IMAGE_SIZES.PORTRAIT_UNCANNY)
        assertEquals(result, "https://testpath/res/1/portrait_uncanny.jpg")

    }

}