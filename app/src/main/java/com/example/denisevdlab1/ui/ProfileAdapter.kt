package com.example.denisevdlab1.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.denisevdlab1.R
import com.example.denisevdlab1.media_content.loadImage
import com.example.denisevdlab1.model.Post

class PostAdapter : ListAdapter<Post, PostAdapter.PostViewHolder>(PostDiffUtil()) {

    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val postText: TextView = view.findViewById(R.id.postText)
        private val postImage: ImageView = view.findViewById(R.id.postImage)
        private val likeButton: Button = view.findViewById(R.id.likeButton)
        private val commentButton: Button = view.findViewById(R.id.commentButton)

        @SuppressLint("SetTextI18n")
        fun bind(post: Post) {
            post.imageURL?.let {
                postImage.visibility = View.VISIBLE
                postImage.loadImage(it)
            }

            postText.text = post.text
            likeButton.text = "Likes: ${post.likesAmount}"
            commentButton.text = "Comments:  ${post.commentsAmount}"

            likeButton.setOnClickListener {
                Toast.makeText(it.context, "Already liked!", Toast.LENGTH_SHORT).show()
            }
            commentButton.setOnClickListener {
                Toast.makeText(
                    it.context,
                    "It is not implemented yet :(",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }
}