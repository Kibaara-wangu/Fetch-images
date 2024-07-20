package com.akirachix.postsapp

import android.net.DnsResolver.Callback
import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akirachix.postsapp.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity(){
//    lateinit var binding: ActivityMainBinding
    lateinit var  recyclerView: RecyclerView
    lateinit var adaptor: PostsAdaptor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvAppPosts)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adaptor = PostsAdaptor(emptyList())
        recyclerView.adapter = adaptor

        fetchPosts()
    }
    fun fetchPosts(){
        val apiInterface = ApiClient.buildApiInterface(PostsApiInterface::class.java)
        val request = apiInterface.getPosts()
        request.enqueue(object :retrofit2.Callback<List<Post>>{
            override fun onResponse(p0: retrofit2.Call<List<Post>>, p1: Response<List<Post>>) {
                if (p1.isSuccessful){
                    val posts = p1.body()
                    if(posts != null){
                        adaptor.updatePost(posts)
                    }
                    Toast.makeText(baseContext, "fetched ${posts!!.size} posts", Toast.LENGTH_LONG).show()
                }

            }
            override fun onFailure(p0: retrofit2.Call<List<Post>>, p1: Throwable) {
                Toast.makeText(baseContext,p1.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}

