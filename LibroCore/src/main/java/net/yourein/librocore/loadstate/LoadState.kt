package net.yourein.librocore.loadstate

sealed class LoadState<out T> {
    data class Loading<T>(val model: T?) : LoadState<T>()
    data class Success<T>(val model: T) : LoadState<T>()
    data class Error<T>(val model: T?, val error: Throwable) : LoadState<T>()
}