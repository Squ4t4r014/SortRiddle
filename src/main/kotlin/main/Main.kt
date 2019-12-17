package main

import api.Wikipedia
import kotlin.system.exitProcess

fun main(args: Array<String>) {
        val wikipedia = Wikipedia()
        println(wikipedia.getRandomWikiTitle())
        exitProcess(0)
}
