package com.akirachix.postsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class PostsAdaptor (var postList: List<Post>):
   RecyclerView.Adapter<PostsAdaptor.AppViewHolder>(){


    class AppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val myBody = itemView.findViewById<TextView>(R.id.tvwords)
        val  myTitle = itemView.findViewById<TextView>(R.id.tvTitle)
//    val  userId = itemView.findViewById<TextView>(R.id.tvId)
//    val  id = itemView.findViewById<TextView>(R.id.tvId)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val  itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.details_main, parent, false)
        return AppViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return postList.size

    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val post = postList[position]
//        holder.userId.text = "UserID: ${post.userId}"
//        holder.id.text = "ID: ${post.id}"
        holder.myBody.text = post.body
        holder.myTitle.text = post.title

    }

    fun updatePost(newPost: List<Post>){
        postList = newPost
        notifyDataSetChanged()
    }


}


//
//class AppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//    val myBody = itemView.findViewById<TextView>(R.id.tvwords)
//    val  myTitle = itemView.findViewById<TextView>(R.id.tvTitle)
////    val  userId = itemView.findViewById<TextView>(R.id.tvId)
////    val  id = itemView.findViewById<TextView>(R.id.tvId)
//}