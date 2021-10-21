package com.example.pl_android.ui.shoppinglist

import com.example.pl_android.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}