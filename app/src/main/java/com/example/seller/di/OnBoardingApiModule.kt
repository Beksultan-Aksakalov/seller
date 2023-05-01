package com.example.seller.di

import com.example.seller.data.api.ConstApi.BASE_URL
import com.example.seller.data.api.OnBoardingApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OnBoardingApiModule {

    @Provides
    fun provideApiService(): OnBoardingApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(OnBoardingApi::class.java)
    }

//    @Provides
//    @Singleton
//    fun provideApi(builder: Retrofit.Builder): OnBoardingApi {
//        return builder.build().create(OnBoardingApi::class.java)
//    }
//
//    fun provideRetrofit(): Retrofit.Builder {
//        return Retrofit.Builder().baseUrl(BASE_URL)
//            .addConverterFactory(MoshiConverterFactory.create())
//    }
}