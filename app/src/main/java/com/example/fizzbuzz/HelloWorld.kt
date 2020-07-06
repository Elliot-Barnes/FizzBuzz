package com.example.fizzbuzz

fun main(){
    val numberOfRules = 5 //17 doesn't add anything so ignore that
    for (i in 1..1786){
        // a flag to check if the number passes any of the checks
        var divisible = false
        val output = Array(numberOfRules) {""}
        val rules = listOf(3,13,5,7) //11 works differently
        val words = listOf("Fizz","Fezz", "Buzz", "Bang")
        val result = rules.map { j -> i%j==0 }

        for (k in 0..3){
            if (result[k]) {
                output[k] = words[k]
                divisible = true
            }
        }
        //bong should be printed alone or after fezz
        if (i % 11 == 0){
            output[0] = ""
            //Leaves Fezz alone
            output[2] = "Bong"
            output[3] = ""
            divisible = true
        }
        //reverses if divisible by 17
        if (i % 17 == 0){
            output.reverse()
        }
        if (divisible){
            println(output.joinToString(""))
        } else {
            println(i)
        }

    }
}