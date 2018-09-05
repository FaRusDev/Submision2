package com.example.f.submision2.network

import com.example.f.submision2.model.Events
import com.example.f.submision2.model.Team
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkInterface {
    //fungsi untuk ambil endpoint dari retrofit
    @GET("eventsnextleague.php?id=4328")
    fun getNext():Observable<Events>

    @GET("eventspastleague.php?id=4328")
    fun getPast():Observable<Events>

    @GET("lookupteam.php")
    fun getTeam(@Query("id")id:String):Observable<Team>


}