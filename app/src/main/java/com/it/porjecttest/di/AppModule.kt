package com.example.hiltwithroomandcoroutine.di

import com.example.hiltwithroomandcoroutine.data.remote.ApiServices
import com.it.porjecttest.utils.Constants

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.android.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object AppModule {
    @Provides
    fun providesUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun apiService(url: String): ApiServices {
        return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(provideOkHtttpClient())
                .build()
                .create(ApiServices::class.java)
    }

    var time: Long = 1

    @Provides
    @Singleton
    fun provideOkHtttpClient(): OkHttpClient {

        var okHttpClient: OkHttpClient.Builder =
                OkHttpClient.Builder().addInterceptor(object : Interceptor {
                    override fun intercept(chain: Interceptor.Chain): Response {
                         val request =
                                chain.request().newBuilder().addHeader("Accept", "application/json")
                                        .addHeader("Content-Type", "application/json")
                                        .addHeader("Cookie", "appLang=" + "en" + ";DeviceType=" +1 + ";AppVersion=" + BuildConfig.VERSION_NAME)
                                        .addHeader("authorization", "Basic " +"HPOF8I0Tw0n76fGCbn5Eyiy1SaXpPJChCnEnJrv0BshpsOkjhkkC7ErRvI6HhcUjpl1FpTZfLqxe3uR1cyZQ4G6j9iP7BqS9YrzFXx37JnA3oftnt+BiWM9tWqRQmeI2gH7Jk5Ju2/FsdTal93rkj4AueCHyNSExLIA1qBBKkCEUsWYHoMBQChn/URWVu/C+5GNE3D8aRPJin6FkZ8KEwWdtbsM45G5zG+2SAsyJRdHtrqECYnO/22Su70EOO/x9IGX3jf6PFvnWBrAGgisYwfx7fyM8DH0KsxTLrs2V7QhjNFlsqTn5zSr/PK9PRofOX4ZGodxIu1EH4T8vIVfbsh3qK3q4jlIi58/MQEFu6t2oHuROTr3wdXZdmTbCadhibQG01yMLGBMNU0J+hbob/w==").build()
                        return chain.proceed(request)
                    }

                })
        okHttpClient.readTimeout(time, TimeUnit.MINUTES)
        okHttpClient.writeTimeout(time, TimeUnit.MINUTES)


        var client: OkHttpClient = okHttpClient.build()
        return client
    }


}