package utils

import java.io.File

fun loadResource (day : String, filename : String): List<String> {
    return File("./res/$day/$filename").readLines()
}