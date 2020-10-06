package com.san22.retrofitsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    val myadpater=rvadapter()
    val mylist= arrayListOf<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val query="harshit"
        GlobalScope.launch(Dispatchers.Main) {

            val response= withContext(Dispatchers.IO) { client.api.getusers() }
            if (response.isSuccessful)
            {
                response.body()?.let {
                    mylist.addAll(it)
                    myadpater.sendtoadapter(mylist)
                }




            }
        }
        rv.apply {

            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=myadpater
        }

    }
}