package com.example.sellerapp.domain.repository

import com.example.sellerapp.domain.model.Product

interface ProductRepository {

    suspend fun getProductInfo(barcode: String, storeId: Long, uid: String?): Product
}