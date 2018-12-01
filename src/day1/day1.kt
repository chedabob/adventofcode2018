package day1

import java.io.File

fun main(args : Array<String>) {
    test1()
    input1()
    input2()
}

fun test1() {
    val tests = arrayOf(
        TestInput("+1, +1, +1", 3),
        TestInput("+1, +1, -2", 0),
        TestInput("-1, -2, -3", -6)
    )

    var count = 0
    tests.forEach {
        val res = run(it.input)
        if (res == it.count) {
            count++
        }
    }

    if (count == tests.size) {
        println("Tests pass")
    }
    else {
        println("Tests failed")
    }
}

fun input1 () {
    val input = File("./res/day1/day1input1.txt").readLines().joinToString(",")
    val result = run(input)
    println(result)
}

fun input2 () {
    val input = File("./res/day1/day1input1.txt").readLines().joinToString(",")
    val instructions = input.split(",").map { it.trim().toInt() }
    var seen = ArrayList<Int>()
    var currFreq = 0
    var running = true
    while (running) {
        for (ins in instructions) {
            currFreq += ins
            if (seen.contains(currFreq)) {
                running = false
                break
            }
            else {
                seen.add(currFreq)
            }
        }
    }

    println(currFreq)
}

fun run (input: String) : Int {
    val instructions = input.split(",").map { it.trim().toInt() }

    return instructions.reduce { acc, i -> acc + i }
}

data class TestInput(val input : String, val count : Int)



