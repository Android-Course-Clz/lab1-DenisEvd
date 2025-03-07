package com.example.denisevdlab1.model

data class Post(
    val id: Int,

    val text: String,
    val imageURL: String? = null,

    val likesAmount: Int,
    val commentsAmount: Int,
)
