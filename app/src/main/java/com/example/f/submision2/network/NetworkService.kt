package com.example.f.submision2.network

import com.example.f.submision2.model.Events
import com.example.f.submision2.model.Team
import com.example.f.submision2.util.BASE_URL
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

interface NetworkService {

    fun loadData():NetworkInterface{
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build().create(NetworkInterface::class.java)
    }


     fun getNextMatch(disposable:CompositeDisposable){
        disposable.add(this.loadData().getNext()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::handleRequest,
                        this::handleError
                ))
    }

     fun getLastMatch(disposable:CompositeDisposable){
        disposable.add(this.loadData().getPast()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::handleRequest,
                        this::handleError
                ))
    }

    fun getTeamDetailA(disposable:CompositeDisposable,id:String){
        disposable.add(this.loadData().getTeam(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::handleTeamRequestA,
                        this::handleError
                ))
    }

    fun getTeamDetailB(disposable:CompositeDisposable,id:String){
        disposable.add(this.loadData().getTeam(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::handleTeamRequestB,
                        this::handleError
                ))
    }



    fun handleTeamRequestA(team: Team)
    fun handleTeamRequestB(team: Team)

    fun handleRequest(events: Events)
    fun handleError(throwable: Throwable)
}