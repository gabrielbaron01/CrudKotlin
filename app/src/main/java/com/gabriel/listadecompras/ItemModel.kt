package com.gabriel.listadecompras

import androidx.arch.core.internal.SafeIterableMap.SupportRemove

data class ItemModel(val nome: String, val onRemove: (ItemModel) -> Unit)