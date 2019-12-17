package main

import api.wikipedia.Wikipedia
import shape.Shape
import kotlin.system.exitProcess

fun main(args: Array<String>) {
        val wikipedia = Wikipedia()
        val str = wikipedia.getRandomWikiTitle()
        println(str)
        println(Shape.isSupportName(str))
        println(Shape.randomize(str))
        exitProcess(0)
}
