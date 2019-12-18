package question.bot

import question.wikipedia.Wikipedia

class BotPresenter {
    val wikipedia = Wikipedia()
    val bot = Bot(this.wikipedia)

    fun build() {

    }

    fun start() {
        while (true) {
            var str = readLine()

            when (str) {
                "/r", "/run" -> this.bot.question()
                "/c", "/clear" -> this.bot.clear()
                "/giveup" -> this.bot.giveup()
            }
            if (Regex("/a [^ ]+").containsMatchIn(str!!)) {
                this.bot.judge(str.replace("/a ", ""))
            }
        }
    }
}