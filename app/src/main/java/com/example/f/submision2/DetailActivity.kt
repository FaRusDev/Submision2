package com.example.f.submision2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.f.submision2.model.Events
import com.example.f.submision2.model.EventsItem
import com.example.f.submision2.model.Team
import com.example.f.submision2.network.NetworkInterface
import com.example.f.submision2.network.NetworkService
import com.example.f.submision2.util.*
import com.squareup.picasso.Picasso
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(),NetworkService {

    val disposable:CompositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        loadData()
        val idTeamA =  intent.getStringExtra(TEAM_A_ID)
        val idTeamB = intent.getStringExtra(TEAM_B_ID)


        getTeamDetailA(disposable,idTeamA)
        getTeamDetailB(disposable,idTeamB)

        detailSkorA.text = intent.getStringExtra(SKOR_A)
        detailSkorB.text = intent.getStringExtra(SKOR_B)

        detailFormasiA.text = intent.getStringExtra(FORMATION_A)
        detaiFormasiB.text = intent.getStringExtra(FORWARD_B)
        detailNamaTeamA.text = intent.getStringExtra(TEAM_A)
        detailNamaTeamB.text = intent.getStringExtra(TEAM_B)
        detailGoalA.text = intent.getStringExtra(GOAL_A)
        detailGoalB.text = intent.getStringExtra(GOAL_B)
        detailYellowA.text = intent.getStringExtra(YELLOW_A)
        detailYellowB.text = intent.getStringExtra(YELLOW_B)
        detailRedA.text = intent.getStringExtra(RED_A)
        detailRedB.text = intent.getStringExtra(RED_B)
        keeperA.text = intent.getStringExtra(KEEPER_A)
        keeperB.text = intent.getStringExtra(KEEPER_B)
        defenseA.text = intent.getStringExtra(DEFENSE_A)
        defenseB.text = intent.getStringExtra(DEFENSE_B)
        middleA.text = intent.getStringExtra(MIDDLE_A)
        middleB.text = intent.getStringExtra(MIDDLE_B)
        forwardA.text = intent.getStringExtra(FORWARD_A)
        forwardB.text = intent.getStringExtra(FORWARD_B)
        subA.text = intent.getStringExtra(SUB_A)
        subB.text = intent.getStringExtra(SUB_B)

    }

    override fun loadData(): NetworkInterface {
        return super.loadData()
    }

    override fun handleTeamRequestA(team: Team) {
       Picasso.get().load(team.teams?.get(0)?.strTeamBadge.toString()).into(detailImgTeamA)
    }

    override fun handleTeamRequestB(team: Team) {
        Picasso.get().load(team.teams?.get(0)?.strTeamBadge.toString()).into(detailImgTeamB)
    }

    override fun getTeamDetailA(disposable: CompositeDisposable, id: String) {
        super.getTeamDetailA(disposable, id)
    }

    override fun getTeamDetailB(disposable: CompositeDisposable, id: String) {
        super.getTeamDetailB(disposable, id)
    }

    override fun handleRequest(events: Events) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleError(throwable: Throwable) {
        Log.v("ERROR",throwable.localizedMessage)
    }

}
