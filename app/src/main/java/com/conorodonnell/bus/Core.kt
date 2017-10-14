package com.conorodonnell.bus

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object Core {

    fun service(): BusService {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
                .baseUrl("https://data.dublinked.ie/cgi-bin/rtpi/")
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(BusService::class.java)
    }

}