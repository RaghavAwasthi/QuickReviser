package com.app.easyreviser.models

import java.io.Serializable

data class CardModel(
        var id: String = "",
        var textFront: String = "",
        var textBack: String = "",
        var timestamp: Long = 0,
        var shortdesctiption: String = "",
        var repeatFrequency: ArrayList<Int> = ArrayList(),
        var priority: Int=0
) : Serializable
