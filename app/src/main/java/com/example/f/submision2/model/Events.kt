package com.example.f.submision2.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Events(
	@field:SerializedName("events")
	val events: List<EventsItem?>? = null

)