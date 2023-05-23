package com.example.sellerapp.data.repository

import com.example.sellerapp.data.network.ApiService
import com.example.sellerapp.data.network.dto.toDomain
import com.example.sellerapp.domain.model.Product
import com.example.sellerapp.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val apiService: ApiService): ProductRepository {

    override suspend fun getProductInfo(barcode: String, storeId: Long, uid: String?): Product {
        return apiService.getProductInfo(barcode, storeId, uid).toDomain()
    }
}