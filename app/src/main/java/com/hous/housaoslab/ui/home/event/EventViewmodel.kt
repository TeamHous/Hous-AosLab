package com.hous.housaoslab.ui.home.event

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EventViewModel : ViewModel() {

    private val _selectedEvent = MutableLiveData(EventIcon.FIRST)
    val selectedEvent get() = _selectedEvent

    fun changeSelectedEvent(event: EventIcon) {
        _selectedEvent.value = event
    }
}
