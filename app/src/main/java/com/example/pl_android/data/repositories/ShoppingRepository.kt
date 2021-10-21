package com.example.pl_android.data.repositories

import com.example.pl_android.data.db.ShoppingDatabase
import com.example.pl_android.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {

    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllSHoppingItems()

}