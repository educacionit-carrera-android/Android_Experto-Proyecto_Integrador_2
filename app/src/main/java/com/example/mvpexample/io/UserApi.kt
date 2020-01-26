package com.example.mvpexample.io

import com.example.mvpexample.data.UserResponse
import io.reactivex.Single

class UserApi {

    fun login(): Single<UserResponse> = Single.just(UserResponse("Jose", "Argento"))

    fun loginError(): Single<UserResponse> = Single.error(Throwable("Datos incorrectos"))

}