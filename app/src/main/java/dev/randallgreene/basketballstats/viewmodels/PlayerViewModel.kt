package dev.randallgreene.basketballstats.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.randallgreene.basketballstats.data.models.PlayerInfo
import dev.randallgreene.basketballstats.data.repositories.BasketballStatsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PlayerViewModel(application: Application) : AndroidViewModel(application) {

    // Scope for coroutines
    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.IO + viewModelJob)

    private val basketballStatsRepository = BasketballStatsRepository()

    // Live data
    private val _playerInfosList = MutableLiveData<List<PlayerInfo>>()
    val playerInfosList: LiveData<List<PlayerInfo>> = _playerInfosList

    fun fetchPlayerInfosList() {
        viewModelScope.launch {
            val playerInfos = basketballStatsRepository.fetchAllPlayerInfos()
            _playerInfosList.postValue(playerInfos)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}