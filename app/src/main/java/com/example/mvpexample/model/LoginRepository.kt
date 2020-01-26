package com.example.mvpexample.model

import com.example.mvpexample.data.UserResponse

interface LoginRepository {
    fun login(responseSuccess: (UserResponse) -> Unit, responseError: (String) -> Unit)
}