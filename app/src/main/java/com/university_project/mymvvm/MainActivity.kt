package com.university_project.mymvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivityp"
    private lateinit var rv: RecyclerView
    private lateinit var liveData: BaseViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        liveData = ViewModelProvider(this)[BaseViewModel::class.java]
        liveData.init()
        rv = findViewById(R.id.rv_Recyclerview_id)
        val myAdapter = MyAdapter()
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = myAdapter

        // Log.d(TAG, "onCreate: ${liveData.getLIveNameList().value}")
        liveData.getLIveNameList().observe(this, { nameList ->
            myAdapter.setValueToArray(nameList)
            myAdapter.notifyDataSetChanged()
        })
        GlobalScope.launch {
            delay(1000)
            liveData.addLiveData("Rahim")
            delay(1000)
            liveData.addLiveData("Karim")
            delay(1000)
            liveData.addLiveData("Jodu")
            delay(1000)
            liveData.addLiveData("Modhu")
            delay(1000)

            liveData.addLiveData("Kodhu")
            delay(1000)
            liveData.addLiveData("Kaisa")
            delay(1000)
            liveData.addLiveData("John")
            delay(1000)
            liveData.addLiveData("Don")
        }
    }
}