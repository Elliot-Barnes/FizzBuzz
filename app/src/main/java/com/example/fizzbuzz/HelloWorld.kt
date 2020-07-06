package com.example.fizzbuzz

fun main(){
    for (i in 1..300){
        var output = ""
        if (i % 5 == 0){
            output += "Buzz"
        }
        if (i % 7 == 0){
            output += "Bang"
        }
        //Bong should be printed alone
        if (i % 11 == 0){
            output = "Bong"
        }
        //Fezz should be printed infront of all the B's
        if (i % 13 == 0) {
            output = "Fezz" + output
        }
        //Fizz should be printed first unless bong is present
        if (i % 3 == 0 && i % 11 != 0){
            output = "Fizz" + output
        }
        //Takes the last 4 characters and places them at the front of the new string
        if (i % 17 == 0){
            var reversedOutput = ""
            while (output != ""){
                reversedOutput += output.subSequence(output.length-4,output.length)
                output = output.subSequence(0,output.length - 4).toString()
            }
            output = reversedOutput
        }
        if (output == ""){
            output = i.toString()
        }
        println(output)
    }
}