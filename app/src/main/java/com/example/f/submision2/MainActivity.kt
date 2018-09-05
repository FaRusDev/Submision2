package com.example.f.submision2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.f.submision2.model.Events
import com.example.f.submision2.model.Team
import com.example.f.submision2.network.NetworkInterface
import com.example.f.submision2.network.NetworkService
import com.example.f.submision2.util.PARCELABLE_EXTRA
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener,NetworkService {



    val disposable:CompositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerSetting()
        loadData()

        nextMatch.setOnClickListener(this)
        lastMatch.setOnClickListener(this)

    }

    override fun loadData(): NetworkInterface {
        return super.loadData()
    }

    override fun getNextMatch(disposable: CompositeDisposable) {
        super.getNextMatch(disposable)
    }

    override fun getLastMatch(disposable: CompositeDisposable) {
        super.getLastMatch(disposable)
    }


    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.nextMatch->{
                getNextMatch(disposable)
                nextMatchIcon.setColorFilter(resources.getColor(R.color.colorAccent))
                nextMatchTv.setTextColor(resources.getColor(R.color.colorAccent))

                lastMatchIcon.setColorFilter(resources.getColor(R.color.primary_dark_material_light))
                lastMatchTv.setTextColor(resources.getColor(R.color.primary_dark_material_light))
            }
            R.id.lastMatch->{
                getLastMatch(disposable)
                lastMatchIcon.setColorFilter(resources.getColor(R.color.colorAccent))
                lastMatchTv.setTextColor(resources.getColor(R.color.colorAccent))

                nextMatchIcon.setColorFilter(resources.getColor(R.color.primary_dark_material_light))
                nextMatchTv.setTextColor(resources.getColor(R.color.primary_dark_material_light))
            }

        }
    }

    private fun recyclerSetting(){
        recycler.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager
    }


    override fun handleError(throwable: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleRequest(events: Events) {
        val mAdapter = MainAdapter(events.events!!){
            val i:Intent = Intent(this,DetailActivity::class.java)
            i.putExtra(PARCELABLE_EXTRA,it)
            startActivity(i)
        }

        recycler.adapter = mAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }
}
