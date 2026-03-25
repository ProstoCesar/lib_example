package ru.eugene.test.mainsdkactivity.counter

object HiddenCounter {

    private var count = 0

    fun addToCounter(value: Int) {
        count += value
    }

    fun currentCount() = count
}