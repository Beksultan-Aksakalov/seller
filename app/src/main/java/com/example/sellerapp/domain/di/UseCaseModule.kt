package com.example.sellerapp.domain.di

import com.example.sellerapp.domain.repository.AuthStaffRepository
import com.example.sellerapp.domain.repository.GlobalKeyValueRepository
import com.example.sellerapp.domain.repository.OnBoardingRepository
import com.example.sellerapp.domain.repository.ProductRepository
import com.example.sellerapp.domain.repository.ReceiptRepository
import com.example.sellerapp.domain.repository.UserRepository
import com.example.sellerapp.domain.usecase.AuthKeySaveUseCase
import com.example.sellerapp.domain.usecase.AuthStaffUseCase
import com.example.sellerapp.domain.usecase.GetOnBoardingItemsUseCase
import com.example.sellerapp.domain.usecase.GetProductByBarCodeUseCase
import com.example.sellerapp.domain.usecase.GetReceiptByCodeUseCase
import com.example.sellerapp.domain.usecase.GetUserInfoUseCase
import com.example.sellerapp.domain.usecase.PinChangeUseCase
import com.example.sellerapp.domain.usecase.PinCheckUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetOnBoardingItems(onBoardingRepository: OnBoardingRepository): GetOnBoardingItemsUseCase =
        GetOnBoardingItemsUseCase(onBoardingRepository)

    @Singleton
    @Provides
    fun provideAuthStaff(authStaffRepository: AuthStaffRepository): AuthStaffUseCase =
        AuthStaffUseCase(authStaffRepository)

    @Singleton
    @Provides
    fun providePinChang(authStaffRepository: AuthStaffRepository): PinChangeUseCase =
        PinChangeUseCase(authStaffRepository)

    @Singleton
    @Provides
    fun provideAuthKeySave(repository: GlobalKeyValueRepository): AuthKeySaveUseCase =
        AuthKeySaveUseCase(repository)

    @Singleton
    @Provides
    fun providePinCheck(authStaffRepository: AuthStaffRepository): PinCheckUseCase =
        PinCheckUseCase(authStaffRepository)

    @Singleton
    @Provides
    fun provideGetUserInfoUseCase(userRepository: UserRepository): GetUserInfoUseCase =
        GetUserInfoUseCase(userRepository)

    @Singleton
    @Provides
    fun provideGetProductByBarCodeUseCase(productRepository: ProductRepository): GetProductByBarCodeUseCase =
        GetProductByBarCodeUseCase(productRepository)

    @Singleton
    @Provides
    fun provideGetReceiptByCodeUseCase(receiptRepository: ReceiptRepository): GetReceiptByCodeUseCase =
        GetReceiptByCodeUseCase(receiptRepository)
}