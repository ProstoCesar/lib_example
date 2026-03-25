package ru.eugene.test.mainsdkactivity.counter

/**
 * Тест коммент
 *
 * @property count Видно ли счетчик?
 */
object Counter {
    //Комментарий
    private var count = 0

    /**
     * Комментарий
     */
    fun addToCounter(value: Int) {
        count += value
    }

    fun currentCount() = count
}