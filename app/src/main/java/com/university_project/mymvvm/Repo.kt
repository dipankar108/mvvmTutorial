package com.university_project.mymvvm

object Repo {
    val nameList = ArrayList<String>()
    fun getList(): ArrayList<String> {

        return nameList
    }

    //pretend to be get data form api
    fun getDataFromApi() {
        nameList.add("dipto")
        nameList.add("shanto")
        nameList.add("pranto")
    }
}