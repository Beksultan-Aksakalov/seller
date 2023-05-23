package com.example.sellerapp.data.repository

import com.example.sellerapp.data.local.GlobalKeyValueCache
import com.example.sellerapp.domain.repository.GlobalKeyValueRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GlobalKeyValueRepositoryImpl @Inject constructor(private val globalKeyValueCache: GlobalKeyValueCache) :
    GlobalKeyValueRepository {

    override suspend fun putAuthKey(key: String) {
        globalKeyValueCache.putAuthKey(key)
    }

    override suspend fun getAuthKey(): Flow<String?> {
        return globalKeyValueCache.getAuthKey()
    }

    override suspend fun clearAuthKey() {
        return globalKeyValueCache.cleaAuthKey()
    }
}