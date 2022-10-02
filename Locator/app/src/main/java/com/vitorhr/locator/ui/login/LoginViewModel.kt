package com.vitorhr.locator.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vitorhr.locator.model.LoginUser

class LoginViewModel : ViewModel() {
    var pwd = MutableLiveData("")
    var email = MutableLiveData("")

    var didLoginButtonClick = MutableLiveData<LoginUser>()

    fun loginButtonClick() {
        didLoginButtonClick.value = LoginUser(email.value!!, pwd.value!!)
    }
}