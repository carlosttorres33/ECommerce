package com.carlostorres.ecommerce.util

sealed class ResponseUI <out T> {

    data object Loading: ResponseUI<Nothing>()
    data class Success<out T>(val data: T): ResponseUI<Nothing>()
    data class Failure<out T>(val e: Exception): ResponseUI<T>()

}