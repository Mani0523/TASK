package com.example.practice.util

import com.example.practice.Retrofit.Post

sealed class ApiState {
    class Success(val data:List<Post>) :ApiState()
    class Failure(val msg:Throwable) :ApiState()
    object Loading :ApiState()
    object Empty :ApiState()
}