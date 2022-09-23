package com.example.zimozitask.dependency

import android.content.Context
import android.content.SharedPreferences
import com.example.zimozitask.data.model.Data
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PreferenceManager(context: Context) {
    var sharedPreferences: SharedPreferences

    init {
        sharedPreferences =
            context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
    }
    fun saveData(key: String, list: List<Data>) {
        val gson = Gson()
        val json: String = gson.toJson(list)
        val editor = sharedPreferences.edit()
        editor.putString(key,json)
        editor.apply()
    }

    fun getData(key: String): Flow<Data> {
        val gson = Gson()
        val jsonText: String = sharedPreferences.getString(key, "")!!
        val arr = gson.fromJson(jsonText, Array<Data>::class.java)
        return flow {
            for (item in arr) {
                emit(item)
            }
        }
    }
    companion object {
        const val KEY = "AppPreference"
    }


}