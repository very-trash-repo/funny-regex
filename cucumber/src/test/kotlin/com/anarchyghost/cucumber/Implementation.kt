package com.anarchyghost.cucumber

import io.cucumber.java.ru.Дано
import io.cucumber.java.ru.Когда
import io.cucumber.java.ru.То
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe


class TestImplementation {
    private lateinit var calc: Calc
    private var exception: Exception? = null
    @Дано("результат выражения равен {double}")
    fun `результат выражения равен`(double1: Double) {
        println("Init $double1")
        calc = Calc(double1)
    }

    @Когда("пользователь вычитает {double}")
    fun `пользователь вычитает`(double1: Double) {
        println("diff $double1")

        calc.difference(double1)
    }

    @Когда("пользователь делит на {double}")
    fun `пользователь делит на`(double1: Double) {
        try {
            calc.divide(double1)
        } catch (e: Exception) {
            exception = e
        }
    }

    @Когда("пользователь умножает на {double}")
    fun `пользователь умножает на`(double1: Double) {
        println("mul $double1")

        calc.multiply(double1)
    }

    @Когда("пользователь прибавляет {double}")
    fun `пользователь прибавляет`(double1: Double) {
        println("add $double1")

        calc.sum(double1)
    }
    @То("итоговый результат выражения равен {double}")
    fun `итоговый результат выражения равен`(double1: Double) {
        println("res $double1")
        calc.result() shouldBe double1
    }

    @То("пользователю выдается ошибка")
    fun `пользователю выдается ошибка`() {
        exception shouldNotBe null
    }
}