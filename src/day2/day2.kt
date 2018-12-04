package day2

import utils.loadResource

fun main(args : Array<String>) {
    test1()
    input1()
    input2()
}

fun test1 () {
    val tests = arrayOf(
        "abcdef",
        "bababc",
        "abbcde",
        "abcccd",
        "aabcdd",
        "abcdee",
        "ababab"
    )

    val expectedResult = 12

    val outputs = tests.map { analyseString(it) }

    val numTwos = outputs.count { it.twoChars }
    val numThrees = outputs.count { it.threeChars }
    val result = numTwos * numThrees

    if (result == expectedResult) {
        println("Tests pass")
    }
    else {
        println("Tests failed")
    }
}

fun input1 () {
    val input = loadResource("day2","day2input1.txt")
    val outputs = input.map { analyseString(it) }

    val numTwos = outputs.count { it.twoChars }
    val numThrees = outputs.count { it.threeChars }
    val result = numTwos * numThrees
    println("Day 2 Input 1 : $result")
}

fun input2 () {
    val input = loadResource("day2","day2input1.txt")
    val toCheck = input.toMutableList()

    loop@ for (a in input) {
        toCheck.remove(a)

        for (b in toCheck) {
            val ham = hammingDistance(a,b)
            if (ham == 1) {
                println(commonChars(a,b))
                break@loop
            }
        }
    }

}

fun hammingDistance (a : String, b : String): Int {
    val sameElements = (a zip b).count { input -> input.first == input.second }

    return a.length - sameElements
}

fun commonChars (a : String, b: String) : String {
    return (a zip b).filter { it.first == it.second }.map { it.first }.joinToString("")
}

fun analyseString (input : String) : StringAnalysis {
    val chars = input.toCharArray()
    val groups = chars.groupBy { it }

    return StringAnalysis(groups.any { it.value.size == 2 }, groups.any { it.value.size == 3 })
}

data class StringAnalysis (val twoChars : Boolean, val threeChars : Boolean)
