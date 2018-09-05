package com.example.f.submision2

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.f.submision2.model.EventsItem
import com.squareup.picasso.Picasso

class MainAdapter(private val listEvents: List<EventsItem?>?,
                  private val click:(EventsItem)->Unit):RecyclerView.Adapter<MainAdapter.MainVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainVH {
        return MainVH(LayoutInflater.from(parent.context).inflate(R.layout.list_schedule,parent,false))
    }

    override fun getItemCount(): Int = listEvents!!.size

    override fun onBindViewHolder(holder: MainVH, position: Int) {
        holder.bind(listEvents!![position],click)
    }

    inner class MainVH(itemView: View?) : RecyclerView.ViewHolder(itemView!!){

        val gbrA = itemView?.findViewById<ImageView>(R.id.itemGbrTeamA)
        val gbrB = itemView?.findViewById<ImageView>(R.id.itemGbrTeamB)
        val skorA = itemView?.findViewById<TextView>(R.id.itemSkorTeamA)
        val skorB = itemView?.findViewById<TextView>(R.id.itemSkorTeamB)
        val namaTeamA = itemView?.findViewById<TextView>(R.id.nextMatchTv)
        val namaTeamB = itemView?.findViewById<TextView>(R.id.itemTeamB)
        val tanggal = itemView?.findViewById<TextView>(R.id.itemTgl)


        fun bind(events: EventsItem?, clk:(EventsItem)->Unit){

//            val team = TeamsItem()
            val skorTeamA = events?.intHomeScore.toString()
            val skorTeamB = events?.intAwayScore.toString()
//
//            val idAway = events.events?.get().idAwayTeam
//            NetworkServices().getTeam(idAway!!.toInt(),{},{})


            Picasso.get().load("https://www.thesportsdb.com/images/media/team/badge/vrtrtp1448813175.png").into(gbrA)
//            val idHome = events.events?.get().idHomeTeam
//            NetworkServices().getTeam(idHome!!.toInt(),{},{})
//            Picasso.get().load(team.strTeamBadge).to(gbrB)

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

    }
}