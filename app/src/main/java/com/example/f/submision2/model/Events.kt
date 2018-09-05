package com.example.f.submision2.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Events(

	@field:SerializedName("events")
	val events: List<EventsItem?>? = null
) : Parcelable {
	constructor() : this(TODO("events")) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {

	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Events> {
		override fun createFromParcel(parcel: Parcel): Events {
			return Events()
		}

		override fun newArray(size: Int): Array<Events?> {
			return arrayOfNulls(size)
		}
	}
}