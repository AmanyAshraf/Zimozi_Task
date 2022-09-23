package com.example.zimozitask.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zimozitask.data.model.Person
import com.example.zimozitask.domain.repository.DataRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel:ViewModel() {
    val dataRepository= DataRepository()
    private var _mutableResponse = MutableLiveData<Person>()
    val response: LiveData<Person> = _mutableResponse

    init {
       getData()
    }
    fun getData(){
        dataRepository.list.enqueue(object :Callback<Person>{
            override fun onResponse(call: Call<Person>, response: Response<Person>) {
                _mutableResponse.value=response.body()
            }
            override fun onFailure(call: Call<Person>, t: Throwable) {
            }

        })
    }
}