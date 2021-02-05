package com.example.openbankmobiletest.di

import com.example.openbankmobiletest.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {

        return Retrofit.Builder()
                .baseUrl(BuildConfig.MARVEL_ENDPOINT)
                .client(buildClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }

    private fun buildClient() : OkHttpClient {

        val builder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            builder.addInterceptor(interceptor)
        }

        return builder.build()

    }

}