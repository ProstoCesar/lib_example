package ru.lib.example

object MySingleton {
    var counter = 0

    fun doSomething(): String {
        counter++
        return "Singleton called $counter times"
    }
}