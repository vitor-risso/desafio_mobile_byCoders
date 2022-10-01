package com.vitorhr.locator.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var pwd = MutableLiveData("")
    var email = MutableLiveData("")

    fun loginButtonClick() {
        Log.d("VITOR", "CLICK")
    }
}