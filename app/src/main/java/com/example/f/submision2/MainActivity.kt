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
import com.example.f.submision2.util.*

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

        getNextMatch(disposable)
        nextMatchIcon.setColorFilter(resources.getColor(R.color.colorAccent))
        nextMatchTv.setTextColor(resources.getColor(R.color.colorAccent))
        lastMatchIcon.setColorFilter(resources.getColor(R.color.primary_dark_material_light))
        lastMatchTv.setTextColor(resources.getColor(R.color.primary_dark_material_light))


    }

    override fun loadData(): NetworkInterface {
        return super.loadData()
    }

    override fun handleTeamRequestA(team: Team) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleTeamRequestB(team: Team) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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

            val i = Intent(this,DetailActivity::class.java)

            i.putExtra(GOAL_A,it.strHomeGoalDetails.toString())
            i.putExtra(GOAL_B,it.strAwayGoalDetails.toString())
            i.putExtra(TEAM_A_ID,it.idHomeTeam)
            i.putExtra(TEAM_B_ID,it.idAwayTeam)
            i.putExtra(SKOR_A,it.intHomeScore.toString())
            i.putExtra(SKOR_B,it.intAwayScore.toString())
            i.putExtra(TEAM_A,it.strHomeTeam)
            i.putExtra(TEAM_B,it.strAwayTeam)
            i.putExtra(SHOTS_A,it.intHomeShots.toString())
            i.putExtra(SHOTS_B,it.intAwayShots.toString())
            i.putExtra(FORMATION_A,it.strHomeFormation.toString())
            i.putExtra(FORMATION_B,it.strAwayFormation.toString())
            i.putExtra(YELLOW_A,it.strHomeYellowCards.toString())
            i.putExtra(YELLOW_B,it.strAwayYellowCards.toString())
            i.putExtra(RED_A,it.strHomeRedCards.toString())
            i.putExtra(RED_B,it.strAwayRedCards.toString())
            i.putExtra(KEEPER_A,it.strHomeLineupGoalkeeper.toString())
            i.putExtra(KEEPER_B,it.strAwayLineupGoalkeeper.toString())
            i.putExtra(DEFENSE_A,it.strHomeLineupDefense.toString())
            i.putExtra(DEFENSE_B,it.strAwayLineupDefense.toString())
            i.putExtra(MIDDLE_A,it.strHomeLineupMidfield.toString())
            i.putExtra(MIDDLE_B,it.strAwayLineupMidfield.toString())
            i.putExtra(FORWARD_A,it.strHomeLineupForward.toString())
            i.putExtra(FORWARD_B,it.strAwayLineupForward.toString())
            i.putExtra(SUB_A,it.strHomeLineupSubstitutes.toString())
            i.putExtra(SUB_B,it.strAwayLineupSubstitutes.toString())

            startActivity(i)
        }

        recycler.adapter = mAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }
}
