package com.hous.housaoslab.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hous.housaoslab.util.ListLiveDataUtil

class EventViewModel : ViewModel() {

    private var _checkedImageRes = MutableLiveData<Int>(EventIcon.FIRST.drawableRes)
    val checkedImageRes: LiveData<Int> get() = _checkedImageRes
    val checkList = ListLiveDataUtil<Boolean>().apply {
        addAll(mutableListOf(false, false, false, false))
    }

    fun isCheckedIndexAt(index: Int): Boolean {
        return checkList.value!!.get(index)
    }

    fun changeCheckedList(index: Int) {
        when (index) {
            0 -> {
                if (checkList.value!![0].equals(true)) {
                    return
                }
                _checkedImageRes.value = EventIcon.FIRST.drawableRes
                checkList.changeItemAt(index, true)
            }
            1 -> {
                if (checkList.value!![1].equals(true)) {
                    return
                }
                _checkedImageRes.value = EventIcon.SECOND.drawableRes
                checkList.changeItemAt(index, true)
            }
            2 -> {
                if (checkList.value!![2].equals(true)) {
                    return
                }
                _checkedImageRes.value = EventIcon.THIRD.drawableRes
                checkList.changeItemAt(index, true)
            }
            3 -> {
                if (checkList.value!![3].equals(true)) {
                    return
                }
                _checkedImageRes.value = EventIcon.FOURTH.drawableRes
                checkList.changeItemAt(index, true)
            }
        }
    }
}

//    private var _year = MutableLiveData<Long>(0)
//    private var _month = MutableLiveData<Long>(0)
//    private var _date = MutableLiveData<Long>(0)
//    init {
//        val today: String = SimpleDateFormat("yyyyMMdd").format(Date())
//        val year = today.substring(0..5)
//        val month = today.substring(5..7)
//        val date = today.substring(7..9)
//    }
// 먼저 아이템 클릭 시 화면에 이미지 띄우기
// 폭죽 아이콘이 가장 먼저 떠야함
