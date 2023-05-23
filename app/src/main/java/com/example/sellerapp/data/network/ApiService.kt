package com.example.sellerapp.data.network

import com.example.sellerapp.data.network.dto.OnBoardingItemRes
import com.example.sellerapp.data.network.dto.ProductRes
import com.example.sellerapp.data.network.dto.ReceiptRes
import com.example.sellerapp.data.network.dto.auth.AuthStaffReq
import com.example.sellerapp.data.network.dto.auth.AuthStaffRes
import com.example.sellerapp.data.network.dto.auth.PinChangeReq
import com.example.sellerapp.data.network.dto.auth.PinCheckReq
import com.example.sellerapp.data.network.dto.user_info.UserInfoReq
import com.example.sellerapp.data.network.dto.user_info.UserInfoRes
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface ApiService {

    @GET("info/onboarding")
    suspend fun getOnBoarding(): List<OnBoardingItemRes>

    @POST("auth/staff")
    suspend fun authStaff(@Body authStaffReq: AuthStaffReq): AuthStaffRes

    @POST("auth/pin/change")
    suspend fun authPinChange(@Body pinChangeReq: PinChangeReq)

    @POST("auth/pin/check")
    suspend fun authPinCheck(@Body pinCheckReq: PinCheckReq)

    @GET("user")
    suspend fun getUserInfo(): UserInfoRes

    @DELETE("auth/logout")
    suspend fun authLogout()

    @GET("store/item")
    suspend fun getProductInfo(
        @Query("barcode") barcode: String,
        @Query("storeId") storeId: Long,
        @Query("uid") uid: String?
    ): ProductRes

    @GET("order/qr")
    suspend fun getReceiptInfo(
        @Query("code") code: String
    ): ReceiptRes

    @PUT("user")
    suspend fun updateUserInfo(@Body userInfoReq: UserInfoReq): UserInfoRes

}