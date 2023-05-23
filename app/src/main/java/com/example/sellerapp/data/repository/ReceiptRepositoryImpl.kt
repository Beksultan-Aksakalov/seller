package com.example.sellerapp.data.repository

import com.example.sellerapp.data.network.ApiService
import com.example.sellerapp.data.network.dto.toDomain
import com.example.sellerapp.domain.model.Receipt
import com.example.sellerapp.domain.repository.ReceiptRepository
import javax.inject.Inject

class ReceiptRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    ReceiptRepository {

    override suspend fun getReceiptInfo(code: String): Receipt {
        return apiService.getReceiptInfo(code).toDomain()
    }
}