package com.anarchyghost.cucumber

class Calc(
    private var number: Double,
) {
    fun sum(number: Double) {
        this.number += number
    }

    fun difference(number: Double) {
        this.number -= number
    }
    fun multiply(number: Double) {
        this.number *= number
    }
    fun divide(number: Double) {
        check(number!=0.0) { "$number should not be 0" }
        this.number /= number
    }
    fun result(): Double {
        return this.number
    }

    fun testMethod() {
        return 0
    }
}