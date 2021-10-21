package com.example.pl_android.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_item")
data class ShoppingItem(

    @ColumnInfo(name = "item_info")
    var name: String,

    @ColumnInfo(name = "item_amount")
    var amount: Int

) {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

}