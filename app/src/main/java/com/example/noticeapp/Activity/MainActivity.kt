package com.example.noticeapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.noticeapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /* val isConnected : Boolean = checkConnectionState()
        if (isConnected){
             Toast.makeText(this,"Estas conectado",Toast.LENGTH_SHORT).show()

         } else {
             Toast.makeText(this,"No estas conectado",Toast.LENGTH_SHORT).show()
         }*/
        btn_gotonotice.setOnClickListener {
            startActivity(Intent(this, NoticeActivity::class.java))
        }
    }

    /* private fun checkConnectionState():Boolean {
       val cm = this.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
       return cm.isDefaultNetworkActive
   }*/
}