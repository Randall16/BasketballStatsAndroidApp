package dev.randallgreene.basketballstats.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.randallgreene.basketballstats.data.models.Player
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

    private val _player = MutableLiveData<Player>()
    val player: LiveData<Player> = _player

    fun fetchPlayerInfosList() {
        viewModelScope.launch {
            val playerInfos = basketballStatsRepository.fetchAllPlayerInfos()
            _playerInfosList.postValue(playerInfos)
        }
    }

    fun fetchPlayerById(playerID: String) {
        viewModelScope.launch {
            val player = basketballStatsRepository.fetchPlayerByID(playerID)
            _player.postValue(player)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}