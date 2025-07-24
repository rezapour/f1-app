package me.rezapour.f1app.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.rezapour.network.ApiProvider
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(apiProvider: ApiProvider) : ViewModel() {


    init {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = apiProvider.getDrivers(0, 10)
                Log.d("MO", result.mRData?.driverTable!!.drivers[0]!!.givenName!!)
            } catch (e: Exception) {
                Log.d("MO", e.message.toString())
            }

        }


    }

}