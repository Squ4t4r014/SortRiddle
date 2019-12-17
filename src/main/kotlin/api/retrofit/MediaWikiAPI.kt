package api.retrofit

import api.Resource
import retrofit2.http.GET
import retrofit2.Response
import api.model.MediaWikiAPIResponseModel

interface MediaWikiAPI {
    @GET(Resource.random)
    suspend fun call(): Response<MediaWikiAPIResponseModel>
}