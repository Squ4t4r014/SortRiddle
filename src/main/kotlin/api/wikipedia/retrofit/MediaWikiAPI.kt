package api.wikipedia.retrofit

import api.wikipedia.Resource
import retrofit2.http.GET
import retrofit2.Response
import api.wikipedia.model.MediaWikiAPIResponseModel

interface MediaWikiAPI {
    @GET(Resource.random)
    suspend fun call(): Response<MediaWikiAPIResponseModel>
}