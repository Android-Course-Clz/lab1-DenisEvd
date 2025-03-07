package com.example.denisevdlab1.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.denisevdlab1.model.Post
import com.example.denisevdlab1.model.Profile
import com.example.denisevdlab1.repo.MockRepo

class ProfileViewModel: ViewModel() {
    private val repository = MockRepo()

    private val _prof = MutableLiveData<Profile>()
    val prof: LiveData<Profile> get() = _prof

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> get() = _posts

    init {
        _prof.value = repository.getProfile()
        _posts.value = repository.getPosts()
    }
}