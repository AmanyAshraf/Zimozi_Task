package com.example.zimozitask.data.model


import com.google.gson.annotations.SerializedName


data class Person (

  @SerializedName("status"  ) var status  : String?         = null,
  @SerializedName("message" ) var message : String?         = null,
  @SerializedName("data"    ) var data    : ArrayList<Data> = arrayListOf()

)