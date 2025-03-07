package com.example.denisevdlab1

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.denisevdlab1.media_content.loadImage
import com.example.denisevdlab1.ui.PostAdapter
import com.example.denisevdlab1.ui.ProfileViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        val adapter = PostAdapter()

        val recyclerView = findViewById<RecyclerView>(R.id.postsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.prof.observe(this) { prof ->
            findViewById<ImageView>(R.id.userAvatar).loadImage(prof.avatarURL)
            findViewById<TextView>(R.id.userName).text = prof.userName

            findViewById<TextView>(R.id.subscribersAmount).text = "${prof.subscribersAmount}"
            findViewById<TextView>(R.id.subscriptionsAmount).text = "${prof.subscriptionsAmount}"
            findViewById<TextView>(R.id.postsAmount).text = "${prof.postsAmount}"
        }

        val followButton = findViewById<Button>(R.id.followButton)
        val messageButton = findViewById<Button>(R.id.messageButton)
        followButton.setOnClickListener{
            Toast.makeText(this, "Followed!", Toast.LENGTH_SHORT).show()
        }
        messageButton.setOnClickListener{
            Toast.makeText(this, "Is not implemented yet!", Toast.LENGTH_SHORT).show()
        }

        viewModel.posts.observe(this) { posts ->
            adapter.submitList(posts)
        }
    }
}