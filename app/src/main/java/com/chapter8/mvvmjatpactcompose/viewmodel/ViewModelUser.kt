package com.chapter8.mvvmjatpactcompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chapter8.mvvmjatpactcompose.model.DataUserResponseItem
import com.chapter8.mvvmjatpactcompose.network.UserService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class ViewModelUser @Inject constructor(@Named("staff") api: UserService) : ViewModel() {
    private val userState = MutableStateFlow(emptyList<DataUserResponseItem>())
    val dataState: StateFlow<List<DataUserResponseItem>> get() = userState


    init {
        viewModelScope.launch {
            val dataUser = api.getAllStaff()
            userState.value = dataUser
        }
    }
}