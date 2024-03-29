package com.example.tokosembako.ui.theme.data.repository

import com.example.tokosembako.ui.theme.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {

    fun getAll(): Flow<List<Transaction>>

    suspend fun getById(id: Int): Transaction?

    suspend fun insert(transactionData: Transaction)

    suspend fun update(transactionData: Transaction)

    suspend fun delete(transactionData: Transaction)
}