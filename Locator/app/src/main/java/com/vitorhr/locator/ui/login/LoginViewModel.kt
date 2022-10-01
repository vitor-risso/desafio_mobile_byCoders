package com.vitorhr.locator.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var pwd = MutableLiveData("")
    var email = MutableLiveData("")

    fun loginButtonClick() {

    }
}