package me.rezapour.f1app.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.rezapour.domain.usecase.DriverUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val driverUseCase: DriverUseCase) : ViewModel() {


    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = driverUseCase()
            } catch (e: Exception) {
                Log.d("MO", e.message.toString())
            }

            driverUseCase.driversFlow.collect {
                Log.d("MO", it.toString())
            }
        }
    }
}