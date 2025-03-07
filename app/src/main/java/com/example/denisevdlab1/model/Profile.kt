package com.example.denisevdlab1.model

data class Profile(
    val avatarURL: String,
    val userName: String,

    val subscribersAmount: Int,
    val subscriptionsAmount: Int,
    val postsAmount: Int,
)
