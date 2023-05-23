package com.example.sellerapp.domain.repository

import com.example.sellerapp.domain.model.Receipt

interface ReceiptRepository {

    suspend fun getReceiptInfo(code: String): Receipt
}