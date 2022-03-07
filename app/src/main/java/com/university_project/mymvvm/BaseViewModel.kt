package com.university_project.mymvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BaseViewModel : ViewModel() {
    val liveNameList = MutableLiveData<ArrayList<String>>()
    fun getLIveNameList(): LiveData<ArrayList<String>> {
        liveNameList.value = Repo.getList()
        return liveNameList
    }
    fun init(){
        if (liveNameList!=null){
            Repo.getDataFromApi()
        }
        return
    }
    fun addLiveData(name:String){
        val newList=Repo.getList()
        newList.add(name)
        liveNameList.postValue(newList)
    }
}