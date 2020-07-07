package com.example.fizzbuzz

import android.provider.UserDictionary
//returns a function that does the normal mod rules
fun constructModRule(rule: Pair<Int, String>): (Int) -> String {
    return (fun(i: Int): String {
        return if (i% rule.first == 0){
            rule.second
        } else {
            ""
        }
    })
}

fun main(){
    val rules = listOf(3,13,5,7) //11 works differently
    val words = listOf("Fizz","Fezz", "Buzz", "Bang")
    val modRules = rules zip words
    val ruleList = modRules.map { j-> constructModRule(j) }
    for (i in 1..1785){
        var output = ruleList.map{f -> f(i)}
        //bong should be printed alone or after fezz
        if (i % 11 == 0){
            output = if (i % 13 == 0) {
                listOf("Fezz")
            } else{
                listOf()
            }
            output = output + "Bong"
        }
        //reverses if divisible by 17
        if (i % 17 == 0){
            output = output.asReversed()
        }
        val outputString = output.joinToString("")
        if (outputString == ""){
            println(i)
        } else {
            println(outputString)
        }

    }
}