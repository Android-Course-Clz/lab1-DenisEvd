package com.example.denisevdlab1.repo

import com.example.denisevdlab1.model.Post
import com.example.denisevdlab1.model.Profile

class MockRepo {
    fun getProfile(): Profile = Profile(
        userName = "DenisEvdokimov",
        avatarURL = "https://i.pinimg.com/736x/34/84/84/348484298091386e26dfbaa4036a1306.jpg",
        subscribersAmount = 13,
        subscriptionsAmount = 57,
        postsAmount = 132,
    )

    fun getPosts(): List<Post> = listOf(
        Post(
            id = 1,
            text = "Spectacular views of Toussaint!",
            imageURL = "https://www.wallpaperflare.com/static/879/90/553/the-witcher-3-wild-hunt-screen-shot-video-games-cd-projekt-red-wallpaper.jpg",
            likesAmount = 7,
            commentsAmount = 2,
        ),
        Post(
            id = 2,
            text = "Hi everyone!",
            imageURL = null,
            likesAmount = 9,
            commentsAmount = 21,
        ),
        Post(
            id = 3,
            text = "This is my blog! I'll post here beautiful photos and interesting ideas.",
            imageURL = null,
            likesAmount = 99,
            commentsAmount = 3,
        ),
    )
}