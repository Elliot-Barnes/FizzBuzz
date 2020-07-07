package com.example.fizzbuzz

//returns a function that does the normal mod rules
fun constructModRule(rule:Int, word:String): (Int, List<String>) -> List<String> {
    return (fun(i: Int, output: List<String>): List<String> {
        return if (i% rule == 0){
            output + word
        } else {
            output
        }
    })
}
// rule for 11
fun constructModReplaceRule(rule: Int, word: String): (Int, List<String>) -> List<String> {
    return (fun(i: Int, output: List<String>): List<String> {
        return if (i % rule == 0){
            listOf(word)
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
            //Find first element beginning with a B
            val firstList = out.takeWhile { !it.startsWith('B') }
            val endList = out.subList(firstList.size,out.size)
            out = firstList + word + endList
        }
        return out
    })
}

fun main(){
    val ruleList = listOf(constructModRule(3,"Fizz"),
        constructModRule(5,"Buzz"),
        constructModRule(7, "Bang"),
        constructModReplaceRule(11, "Bong"),
        constructInsertionModRule(13, "Fezz"),
        constructModReverseRule(17)
    )
    for (i in 1..1785){
        val output = ruleList.fold(listOf(),{ x:List<String>, rule -> rule(i,x)})
        val outputString = output.joinToString("")
        if (outputString == ""){
            println(i)
        } else {
            println(outputString)
        }

    }
}