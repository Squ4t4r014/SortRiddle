package question.wikipedia

import question.wikipedia.retrofit.MediaWikiAPI
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.IllegalStateException

class Wikipedia {
    private var randomAPI: MediaWikiAPI? = null

    init {
        this.randomAPI = Retrofit.Builder()
                .baseUrl(Resource.root)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .build()
                .create(MediaWikiAPI::class.java)
    }

    /**
     * Wikipediaのランダムな記事を返します
     */
    fun getRandomWikiTitle(): String {
        val res = runBlocking {
            withContext(Dispatchers.Default) {
                this@Wikipedia.randomAPI?.call()
            }
        }

        return res?.body()?.query?.let{
            it.pages[it.pageids[0]]?.title
        } ?: throw IllegalStateException("Wikipediaからのデータ取得に失敗")
    }
}