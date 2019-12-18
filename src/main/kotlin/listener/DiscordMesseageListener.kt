package listener

interface DiscordMesseageListener {
    fun onCreate()
    fun onDestroy()
    fun onMessageRecieved()
    fun onConnect()
    fun onDisconnected()
}