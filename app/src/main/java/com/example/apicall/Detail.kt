package com.example.apicall

import com.google.gson.annotations.SerializedName

data class Detail(
    @SerializedName("data")
    val informations: List<Information>
)