package com.android.daracare.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.daracare.data.model.User

class AuthViewModel : ViewModel() {
    private val _registeredUser = MutableLiveData<User?>()
    val registeredUser: LiveData<User?> get() = _registeredUser

    fun registerUser(user: User) {
        _registeredUser.value = user
    }

    fun validateLogin(email: String, password: String): Boolean {
        val user = _registeredUser.value
        return user?.email == email && user.password == password
    }
}
