package com.y4gamilight.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseViewModel: ViewModel() {
    override fun onCleared() {
        super.onCleared()
    }
}


inline fun <reified T : BaseViewModel> Fragment.getViewModel(noinline creator: (() -> T)? = null): T {
    if (creator == null) {
        return ViewModelProvider(this).get(T::class.java)
    } else {
        return ViewModelProvider(this, BaseViewModelFactory(creator)).get(T::class.java)

    }
}
inline fun <reified T : BaseViewModel> FragmentActivity.getViewModel(noinline creator: (() -> T)? = null): T {
    return if (creator == null)
        ViewModelProvider(this).get(T::class.java)
    else
        ViewModelProvider(this, BaseViewModelFactory(creator)).get(T::class.java)
}




