package com.example.noticeapp.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noticeapp.API.NoticeAPI
import com.example.noticeapp.Adapter.Notice
import com.example.noticeapp.Adapter.NoticeAdapter
import com.example.noticeapp.databinding.ActivityNoticeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class NoticeActivity : AppCompatActivity() {

    private var noticeList = mutableListOf<Notice>()
    lateinit var noticeAdapter: NoticeAdapter
    private lateinit var binding: ActivityNoticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getNoticesAPI()
        setListConfig()
    }

    private fun setListConfig() {
        noticeAdapter = NoticeAdapter(noticeList)
        binding.rvNotice.layoutManager = LinearLayoutManager(this)
        binding.rvNotice.adapter = noticeAdapter
    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder().
        baseUrl("https://jsonplaceholder.typicode.com/").
        addConverterFactory(MoshiConverterFactory.create()).
        build()
    }

    private fun getNoticesAPI(){

        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(NoticeAPI::class.java).getNotices()
            runOnUiThread {
                if (call.isSuccessful) {
                    val notices: List<Notice> = call.body() ?: emptyList()
                    noticeList.clear()
                    noticeList.addAll(notices)
                    noticeAdapter.notifyDataSetChanged()
                    Toast.makeText(this@NoticeActivity, "Exitoso", Toast.LENGTH_SHORT).show()
                } else {
                    showError()
                }
            }
        }


     /*   val noticeApi: NoticeAPI = retrofit.create(NoticeAPI::class.java)
        noticeApi.getNotices().enqueue(object : Callback<List<Notice>> {

            override fun onResponse(call: Call<List<Notice>>, response: Response<List<Notice>>) {
                if (response.isSuccessful) {
                    val notices = response.body()
                    Toast.makeText(this@NoticeActivity, "Cantidad de usuarios ${notices?.size}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@NoticeActivity, "Error", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: Call<List<Notice>>, t: Throwable) {
                Toast.makeText(this@NoticeActivity, "Error al conectar", Toast.LENGTH_SHORT).show()
            }

        })*/

    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error.", Toast.LENGTH_SHORT).show()
    }
}