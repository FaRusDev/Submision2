package com.example.f.submision2.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class EventsItem(

	@SerializedName("intHomeShots")
	val intHomeShots: Any? = null,

	@SerializedName("strSport")
	val strSport: String? = null,

	@SerializedName("strHomeLineupDefense")
	val strHomeLineupDefense: Any? = null,

	@SerializedName("strAwayLineupSubstitutes")
	val strAwayLineupSubstitutes: Any? = null,

	@SerializedName("idLeague")
	val idLeague: String? = null,

	@SerializedName("idSoccerXML")
	val idSoccerXML: String? = null,

	@SerializedName("strHomeLineupForward")
	val strHomeLineupForward: Any? = null,

	@SerializedName("strTVStation")
	val strTVStation: Any? = null,

	@SerializedName("strHomeGoalDetails")
	val strHomeGoalDetails: Any? = null,

	@SerializedName("strAwayLineupGoalkeeper")
	val strAwayLineupGoalkeeper: Any? = null,

	@SerializedName("strAwayLineupMidfield")
	val strAwayLineupMidfield: Any? = null,

	@SerializedName("idEvent")
	val idEvent: String? = null,

	@SerializedName("intRound")
	val intRound: String? = null,

	@SerializedName("strHomeYellowCards")
	val strHomeYellowCards: Any? = null,

	@SerializedName("idHomeTeam")
	val idHomeTeam: String? = null,

	@SerializedName("intHomeScore")
	val intHomeScore: Any? = null,

	@SerializedName("dateEvent")
	val dateEvent: String? = null,

	@SerializedName("strCountry")
	val strCountry: Any? = null,

	@SerializedName("strAwayTeam")
	val strAwayTeam: String? = null,

	@SerializedName("strHomeLineupMidfield")
	val strHomeLineupMidfield: Any? = null,

	@SerializedName("strDate")
	val strDate: String? = null,

	@SerializedName("strHomeFormation")
	val strHomeFormation: Any? = null,

	@SerializedName("strMap")
	val strMap: Any? = null,

	@SerializedName("idAwayTeam")
	val idAwayTeam: String? = null,

	@SerializedName("strAwayRedCards")
	val strAwayRedCards: Any? = null,

	@SerializedName("strBanner")
	val strBanner: Any? = null,

	@SerializedName("strFanart")
	val strFanart: Any? = null,

	@SerializedName("strDescriptionEN")
	val strDescriptionEN: Any? = null,

	@SerializedName("strResult")
	val strResult: Any? = null,

	@SerializedName("strCircuit")
	val strCircuit: Any? = null,

	@SerializedName("intAwayShots")
	val intAwayShots: Any? = null,

	@SerializedName("strFilename")
	val strFilename: String? = null,

	@SerializedName("strTime")
	val strTime: String? = null,

	@SerializedName("strAwayGoalDetails")
	val strAwayGoalDetails: Any? = null,

	@SerializedName("strAwayLineupForward")
	val strAwayLineupForward: Any? = null,

	@SerializedName("strLocked")
	val strLocked: String? = null,

	@SerializedName("strSeason")
	val strSeason: String? = null,

	@SerializedName("intSpectators")
	val intSpectators: Any? = null,

	@SerializedName("strHomeRedCards")
	val strHomeRedCards: Any? = null,

	@SerializedName("strHomeLineupGoalkeeper")
	val strHomeLineupGoalkeeper: Any? = null,

	@SerializedName("strHomeLineupSubstitutes")
	val strHomeLineupSubstitutes: Any? = null,

	@SerializedName("strAwayFormation")
	val strAwayFormation: Any? = null,

	@SerializedName("strEvent")
	val strEvent: String? = null,

	@SerializedName("strAwayYellowCards")
	val strAwayYellowCards: Any? = null,

	@SerializedName("strAwayLineupDefense")
	val strAwayLineupDefense: Any? = null,

	@SerializedName("strHomeTeam")
	val strHomeTeam: String? = null,

	@SerializedName("strThumb")
	val strThumb: Any? = null,

	@SerializedName("strLeague")
	val strLeague: String? = null,

	@SerializedName("intAwayScore")
	val intAwayScore: Any? = null,

	@SerializedName("strCity")
	val strCity: Any? = null,

	@SerializedName("strPoster")
	val strPoster: Any? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
			TODO("intHomeShots"),
			parcel.readString(),
			TODO("strHomeLineupDefense"),
			TODO("strAwayLineupSubstitutes"),
			parcel.readString(),
			parcel.readString(),
			TODO("strHomeLineupForward"),
			TODO("strTVStation"),
			TODO("strHomeGoalDetails"),
			TODO("strAwayLineupGoalkeeper"),
			TODO("strAwayLineupMidfield"),
			parcel.readString(),
			parcel.readString(),
			TODO("strHomeYellowCards"),
			parcel.readString(),
			TODO("intHomeScore"),
			parcel.readString(),
			TODO("strCountry"),
			parcel.readString(),
			TODO("strHomeLineupMidfield"),
			parcel.readString(),
			TODO("strHomeFormation"),
			TODO("strMap"),
			parcel.readString(),
			TODO("strAwayRedCards"),
			TODO("strBanner"),
			TODO("strFanart"),
			TODO("strDescriptionEN"),
			TODO("strResult"),
			TODO("strCircuit"),
			TODO("intAwayShots"),
			parcel.readString(),
			parcel.readString(),
			TODO("strAwayGoalDetails"),
			TODO("strAwayLineupForward"),
			parcel.readString(),
			parcel.readString(),
			TODO("intSpectators"),
			TODO("strHomeRedCards"),
			TODO("strHomeLineupGoalkeeper"),
			TODO("strHomeLineupSubstitutes"),
			TODO("strAwayFormation"),
			parcel.readString(),
			TODO("strAwayYellowCards"),
			TODO("strAwayLineupDefense"),
			parcel.readString(),
			TODO("strThumb"),
			parcel.readString(),
			TODO("intAwayScore"),
			TODO("strCity"),
			TODO("strPoster")) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(strSport)
		parcel.writeString(idLeague)
		parcel.writeString(idSoccerXML)
		parcel.writeString(idEvent)
		parcel.writeString(intRound)
		parcel.writeString(idHomeTeam)
		parcel.writeString(dateEvent)
		parcel.writeString(strAwayTeam)
		parcel.writeString(strDate)
		parcel.writeString(idAwayTeam)
		parcel.writeString(strFilename)
		parcel.writeString(strTime)
		parcel.writeString(strLocked)
		parcel.writeString(strSeason)
		parcel.writeString(strEvent)
		parcel.writeString(strHomeTeam)
		parcel.writeString(strLeague)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<EventsItem> {
		override fun createFromParcel(parcel: Parcel): EventsItem {
			return EventsItem(parcel)
		}

		override fun newArray(size: Int): Array<EventsItem?> {
			return arrayOfNulls(size)
		}
	}
}