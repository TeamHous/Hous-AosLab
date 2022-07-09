package com.hous.housaoslab.util

import androidx.lifecycle.MutableLiveData

class ListLiveDataUtil<T> : MutableLiveData<MutableList<T>>() {

    init {
        value = mutableListOf<T>()
    }

    fun add(item: T) {
        val items = value
        items?.add(item)
        value = items
    }

    fun addAll(item: List<T>) {
        val items = value
        items?.addAll(item)
        value = items
    }

    fun clear() {
        val items = value
        items?.clear()
        value = items
    }

    fun remove(item: T) {
        val items = value
        items?.remove(item)
        value = items
    }

    fun removeAt(index: Int) {
        val items = value
        items?.removeAt(index)
        value = items
    }

    fun changeItemAt(index: Int, item: T) {
        val items = value
        items?.set(index, item)
        value = items
    }
}
