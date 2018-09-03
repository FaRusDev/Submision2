package com.example.f.submision2.network

import com.example.f.submision2.model.Events
import com.example.f.submision2.model.EventsItem
import com.example.f.submision2.model.Team
import com.example.f.submision2.util.BASE_URL
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkInterface {
    //fungsi untuk ambil endpoint dari retrofit
    @GET("eventsnextleague.php?id=4328")
    fun getNext():Observable<List<EventsItem>>

    @GET("eventspastleague.php?id=4328")
    fun getPast():Observable<List<EventsItem>>

    @GET("lookupteam.php")
    fun getTeam(@Query("id")id:Int):Observable<List<Team>>

    companion object {

        fun create(): NetworkInterface {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()

            return retrofit.create(NetworkInterface::class.java)

        }
    }

}