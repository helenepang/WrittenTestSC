package com.example.writtentestsc

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

/**
 * Created by xiaomin10 on 2023/4/28.
 */
class NumberViewModel(application: Application) : AndroidViewModel(application) {

    var listLiveData = MutableLiveData<MutableList<Double>>()
    var list = mutableListOf<Double>()

    fun setValue(value1: String?, value2: String?) {
        var v1 = if (value1.isNullOrBlank()) 0.0 else value1.toDouble()
        var v2 = if (value2.isNullOrBlank()) 0 else value2.toInt()
        list.add(v1 * v2)
        listLiveData.value = list
    }



    fun getValue(): MutableList<Double>? {
        return listLiveData.value
    }
}