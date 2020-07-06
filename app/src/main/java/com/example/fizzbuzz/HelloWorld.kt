package com.example.fizzbuzz

fun main(){
    for (i in 1..100){
        var output = ""
        if (i % 3 == 0){
            output += "Fizz"
        }
        if (i % 5 == 0){
            output += "Buzz"
        }
        if (output == ""){
            output = i.toString()
        }
        println(output)
    }
}