package com.example.f.submision2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import com.example.f.submision2.model.Events
import com.example.f.submision2.model.Team
import com.example.f.submision2.network.NetworkService
import com.example.f.submision2.util.PARCELABLE_EXTRA
import com.squareup.picasso.Picasso
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


    }

}
