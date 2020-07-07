package com.example.fizzbuzz

import android.provider.UserDictionary
//returns a function that does the normal mod rules
fun constructModRule(words: List<String>, rules: List<Int>): (Int, Array<String>) -> Array<String> {
    return (fun(i: Int, output: Array<String>):Array<String>{
        for (j in rules.indices) {
            if (i%rules[j] == 0){
                output[j] = words[j]
            }
        }
        return output
    })
}

fun main(){
    val numberOfRules = 5 //17 doesn't add anything so ignore that
    val rules = listOf(3,13,5,7) //11 works differently
    val words = listOf("Fizz","Fezz", "Buzz", "Bang")
    val modRule = constructModRule(words,rules)
    for (i in 1..105){
        // a flag to check if the number passes any of the checks
        var output = Array(numberOfRules) {""}
        output = modRule(i,output)

        //bong should be printed alone or after fezz
        if (i % 11 == 0){
            output[0] = ""
            //Leaves Fezz alone
            output[2] = "Bong"
            output[3] = ""
        }
        //reverses if divisible by 17
        if (i % 17 == 0){
            output.reverse()
        }
        if (output.contentEquals(Array(numberOfRules){""})){
            println(i)
        } else {
            println(output.joinToString(""))
        }

    }
}