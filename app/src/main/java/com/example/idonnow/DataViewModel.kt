package com.example.idonnow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel :ViewModel(){

 private var _myData=MutableLiveData<Person>()
    val myData:LiveData<Person>get() =_myData

    init{
        _myData.value= Person()
    }
    fun setPerson(p:Person){
        val newPerson=Person()
        newPerson.name = p.name
        newPerson.pwd = p.pwd

        _myData.postValue(newPerson)
    }

}