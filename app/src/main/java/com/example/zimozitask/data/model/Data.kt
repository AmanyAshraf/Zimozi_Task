package com.example.zimozitask.data.model

import com.google.gson.annotations.SerializedName


data class Data (

  @SerializedName("id"      ) var id      : String? = null,
  @SerializedName("name"    ) var name    : String? = null,
  @SerializedName("country" ) var country : String? = null,
  @SerializedName("city"    ) var city    : String? = null,
  @SerializedName("imgURL"  ) var imgURL  : String? = null

)