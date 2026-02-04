package com.example.testapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.testapp.repository.UserRepository
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class UserProfileVIewModel @Inject constructor(
    private val repository: UserRepository,
    private val ioScheduler: Scheduler,
    private val mainScheduler: Scheduler
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _state = MutableStateFlow<List<User>>(emptyList())
    val state: StateFlow<List<User>> = _state

    fun loadUsers() {
        disposables += repository.getUsers()
            .subscribeOn(ioScheduler)
            .observeOn(mainScheduler)
            .subscribe(
                { users -> _state.value = users },
                { error -> /* handle error */ }
            )
    }

    override fun onCleared() {
        disposables.clear()
    }
}