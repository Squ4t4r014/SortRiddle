package question.bot

import question.wikipedia.Wikipedia
import shape.Shape

class Bot(val wikipedia: Wikipedia) {
    private var questionStr: String? = null
    private var answerStr: String? = null

    fun question() {
        if (this.questionStr == null) {
            this.answerStr = wikipedia.getRandomWikiTitle()
            this.questionStr = Shape.randomize(this.answerStr ?: throw KotlinNullPointerException())
        }

        println("問題は${this.questionStr}です。")
    }

    fun judge(str: String) {
        when {
            str == this.answerStr -> {
                println("正解です。")
                clear()
                return
            }
            str.length == this.answerStr?.length -> {
                System.err.println("正解の文字数を書く")
                return
            }
            else -> {
                println("文字数が違います。")
            }
        }
    }

    fun giveup() {
        println("正解は${this.answerStr}でした。")
        clear()
    }

    fun clear() {
        println("リセットします。")
        this.questionStr = null
        this.answerStr = null
    }
}