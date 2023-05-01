package com.example.seller.presentation.screen.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seller.data.api.model.dto.OnBoardingDTO
import com.example.seller.data.repo.OnBoardingRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val onBoardingRepo: OnBoardingRepo
) : ViewModel() {

    private val _state = MutableLiveData<List<OnBoardingDTO>>()
    val state: LiveData<List<OnBoardingDTO>> = _state

    init {
        viewModelScope.launch {
            val data = onBoardingRepo.getAllOnBoardingList()
            _state.value = data
        }
    }

}