package com.example.f.submision2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.f.submision2.model.EventsItem
import com.example.f.submision2.network.NetworkInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val network by lazy {
        NetworkInterface.create()
    }

    var disposable: CompositeDisposable? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getNextEvent()


    }

    private fun getNextEvent(){
        disposable?.add(network.getNext()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> setupRecycler(result.get(0).events) },
                        { error -> Log.e("ERROR", error.message) }
                ))

    }

    fun setupRecycler(eventsItem: List<EventsItem?>?) {

        recycler.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager

        recycler.adapter = MainAdapter(eventsItem,this){
            Log.v("tes", it.toString())
        }

    }




}
