package com.example.kkboxdemo.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.Observable
import android.databinding.PropertyChangeRegistry
import java.util.*

open class ObservableViewModel : ViewModel(), Observable {
    val mCallback: PropertyChangeRegistry = PropertyChangeRegistry()
    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallback.remove(callback)

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallback.add(callback)
    }

    fun basicChange(fieldId: Int) {
        mCallback.notifyCallbacks(this, fieldId, null)
    }

}