package com.example.f.submision2

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.f.submision2.model.Events
import com.example.f.submision2.model.EventsItem
import com.example.f.submision2.model.Team
import com.example.f.submision2.network.NetworkService
import com.squareup.picasso.Picasso
import io.reactivex.disposables.CompositeDisposable

class MainAdapter(private val listEvents: List<EventsItem?>?,
                  private val click:(EventsItem)->Unit):RecyclerView.Adapter<MainAdapter.MainVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainVH {
        return MainVH(LayoutInflater.from(parent.context).inflate(R.layout.list_schedule,parent,false))
    }

    override fun getItemCount(): Int = listEvents!!.size

    override fun onBindViewHolder(holder: MainVH, position: Int) {
        holder.bind(listEvents!![position],click)
    }

    inner class MainVH(itemView: View?) : RecyclerView.ViewHolder(itemView!!),NetworkService{

        val disposable:CompositeDisposable = CompositeDisposable()
        val gbrA = itemView?.findViewById<ImageView>(R.id.itemGbrTeamA)
        val gbrB = itemView?.findViewById<ImageView>(R.id.itemGbrTeamB)
        val skorA = itemView?.findViewById<TextView>(R.id.itemSkorTeamA)
        val skorB = itemView?.findViewById<TextView>(R.id.itemSkorTeamB)
        val namaTeamA = itemView?.findViewById<TextView>(R.id.nextMatchTv)
        val namaTeamB = itemView?.findViewById<TextView>(R.id.itemTeamB)
        val tanggal = itemView?.findViewById<TextView>(R.id.itemTgl)


        fun bind(events: EventsItem?, clk:(EventsItem)->Unit){

            val skorTeamA = events?.intHomeScore.toString()
            val skorTeamB = events?.intAwayScore.toString()

            val idHome:String? = events?.idHomeTeam
            val idAway:String? = events?.idAwayTeam

            getTeamDetailA(disposable,idHome!!)
            getTeamDetailB(disposable,idAway!!)

            if (skorTeamA.equals("null") && skorTeamB.equals("null") ){
                skorA?.visibility = View.GONE
                skorB?.visibility = View.GONE
            }else{
                skorA?.text = events?.intHomeScore.toString()
                skorB?.text = events?.intAwayScore.toString()
            }

            namaTeamA?.text = events?.strHomeTeam
            namaTeamB?.text = events?.strAwayTeam

            tanggal?.text = events?.strDate

            itemView.setOnClickListener{
                if (events != null) {
                    clk(events)
                }
            }

        }

        override fun handleTeamRequestA(team: Team) {
           Picasso.get().load(team.teams?.get(0)?.strTeamBadge.toString()).into(gbrA)
        }

        override fun handleTeamRequestB(team: Team) {
            Picasso.get().load(team.teams?.get(0)?.strTeamBadge.toString()).into(gbrB)
        }

        override fun handleRequest(events: Events) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun handleError(throwable: Throwable) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}