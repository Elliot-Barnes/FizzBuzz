package com.example.fizzbuzz

import android.provider.UserDictionary
import java.text.FieldPosition
import kotlin.reflect.typeOf

//returns a function that does the normal mod rules
fun constructModRule(rule:Int, word:String): (Int) -> String {
    return (fun(i: Int): String {
        return if (i% rule == 0){
            word
        } else {
            ""
        }
    })
}
// rule for 11
fun constructModReplaceRule(rule: Int, word: String): (Int, List<String>) -> List<String> {
    return (fun(i: Int, output: List<String>): List<String> {
        return if (i % rule == 0){
            // 11 rule keeps fezz but removes everything else
            val out = if (i % 13 == 0){
                listOf("Fezz")
            } else {
                listOf()
            }
            out + word
        } else {
            output
        }
    })
}

fun constructModReverseRule(rule: Int): (Int, List<String>) -> List<String> {
    return (fun(i: Int, output: List<String>): List<String> {
        return if(i % rule == 0){
            output.asReversed()
        } else {
            output
        }
    })
}

fun constructInsertionModRule(rule: Int, word: String): (Int, List<String>) -> List<String> {
    return (fun(i: Int, output: List<String>): List<String>{
        var out = output
        if (i % rule == 0){
            var existB = false
            //Find first element beginning with a B
            for (j in output.indices){
                if (output[j].isNotEmpty()){
                    if (output[j][0] == 'B') {
                        out = output.subList(0, j) + word + output.subList(j, output.size)
                        existB = true
                        break
                    }
                }
            }
            if (!existB){
                out = out + word
            }
        }
        return out
    })
}

fun main(){
    var ruleList = listOf<(Int)->String>()
    var replaceRuleList = listOf<(Int, List<String>)-> List<String>>()
    var reverseRuleList = listOf<(Int, List<String>)-> List<String>>()
    var insertRuleList = listOf<(Int, List<String>)-> List<String>>()
    ruleList = ruleList + constructModRule(3,"Fizz")
    ruleList = ruleList + constructModRule(5,"Buzz")
    ruleList = ruleList + constructModRule(7, "Bang")
    replaceRuleList = replaceRuleList + constructModReplaceRule(11, "Bong")
    insertRuleList = insertRuleList + constructInsertionModRule(13, "Fezz")
    reverseRuleList = reverseRuleList + constructModReverseRule(17)

    for (i in 1..3315){
        var output = ruleList.map{f -> f(i)}
        output = replaceRuleList.fold(output,{ x,rule -> rule(i,x)})
        output = insertRuleList.fold(output,{x,rule -> rule(i,x)})
        //reverses if divisible by 17
        output = reverseRuleList.fold(output,{x,f -> f(i,x) })
        val outputString = output.joinToString("")
        if (outputString == ""){
            println(i)
        } else {
            println(outputString)
        }

    }
}