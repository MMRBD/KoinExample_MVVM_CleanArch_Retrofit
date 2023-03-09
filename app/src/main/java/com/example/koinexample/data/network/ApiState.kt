package com.example.koinexample.data.network

sealed class ApiState {
    object Empty : ApiState()
    object Loading : ApiState()
    class Success<T>(val data: T) : ApiState()
    class Failed(val message: Throwable) : ApiState()
}
