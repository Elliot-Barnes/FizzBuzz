package com.example.fizzbuzz

fun main(){
    val numberOfRules = 5 //17 doesn't add anything so ignore that
    for (i in 1..1785){
        // a flag to check if the number passes any of the checks
        var divisible = false
        val output = Array(numberOfRules) {""}
        if (i % 3 == 0){
            output[0] = "Fizz"
            divisible = true
        }

        if (i % 5 == 0){
            output[2] = "Buzz"
            divisible = true
        }
        if (i % 7 == 0){
            output[3] = "Bang"
            divisible = true
        }
        //Bong should be printed alone
        if (i % 11 == 0){
            for (j in 0..4) output[j] = ""
            output[4] = "Bong"
            divisible = true
        }
        if (i % 13 == 0) {
            output[1] = "Fezz"
            divisible = true
        }

        //Reverses the output
        if (i % 17 == 0){
            output.reverse()
        }
        if (!divisible){
            output[0] = i.toString()
        }
        println(output.joinToString(""))
    }
}