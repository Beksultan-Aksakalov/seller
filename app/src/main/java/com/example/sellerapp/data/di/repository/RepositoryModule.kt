package com.example.sellerapp.data.di.repository

import com.example.sellerapp.data.local.GlobalKeyValueCache
import com.example.sellerapp.data.network.ApiService
import com.example.sellerapp.data.repository.AuthStaffRepositoryImpl
import com.example.sellerapp.data.repository.GlobalKeyValueRepositoryImpl
import com.example.sellerapp.data.repository.OnBoardingRepositoryImpl
import com.example.sellerapp.data.repository.ProductRepositoryImpl
import com.example.sellerapp.data.repository.ReceiptRepositoryImpl
import com.example.sellerapp.data.repository.UserRepositoryImpl
import com.example.sellerapp.domain.repository.AuthStaffRepository
import com.example.sellerapp.domain.repository.GlobalKeyValueRepository
import com.example.sellerapp.domain.repository.OnBoardingRepository
import com.example.sellerapp.domain.repository.ProductRepository
import com.example.sellerapp.domain.repository.ReceiptRepository
import com.example.sellerapp.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideOnBoardingRepository(apiService: ApiService): OnBoardingRepository =
        OnBoardingRepositoryImpl(apiService)

    @Singleton
    @Provides
    fun provideAuthorizationRepository(apiService: ApiService): AuthStaffRepository =
        AuthStaffRepositoryImpl(apiService)

    @Singleton
    @Provides
    fun provideGlobalKeyValueRepository(globalKeyValueCache: GlobalKeyValueCache): GlobalKeyValueRepository =
        GlobalKeyValueRepositoryImpl(globalKeyValueCache)

    @Singleton
    @Provides
    fun provideUserRepository(apiService: ApiService): UserRepository =
        UserRepositoryImpl(apiService)

    @Singleton
    @Provides
    fun provideProductRepository(apiService: ApiService): ProductRepository =
        ProductRepositoryImpl(apiService)

    @Singleton
    @Provides
    fun provideReceiptRepository(apiService: ApiService): ReceiptRepository =
        ReceiptRepositoryImpl(apiService)
}