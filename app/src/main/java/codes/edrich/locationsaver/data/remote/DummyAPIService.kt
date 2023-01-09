package codes.edrich.locationsaver.data.remote

import codes.edrich.locationsaver.model.Location
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET


private const val BASE_URL = "https://public.syntax-institut.de/apps/batch2/PhilippEdrich/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DummyAPIService {
    @GET("data")
    suspend fun getLocations() : List<Location>
}

object DummyAPI {
    val retrofitService: DummyAPIService by lazy { retrofit.create(DummyAPIService::class.java) }
}