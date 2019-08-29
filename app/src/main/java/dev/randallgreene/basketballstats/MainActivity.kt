package dev.randallgreene.basketballstats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dev.randallgreene.basketballstats.viewmodels.PlayerViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var searchAutoCompleteTextView: AutoCompleteTextView
    private lateinit var viewModel: PlayerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))

        searchAutoCompleteTextView = findViewById(R.id.searchAutoCompleteTextView)

        subscribeToViewModel()

    }

    private fun subscribeToViewModel() {

        // Find the viewModel
        viewModel = ViewModelProviders.of(this)
            .get(PlayerViewModel::class.java)

        // Tell viewModel to fetch all Player Names
        viewModel.fetchPlayerInfosList()

        // Observe the viewModel and change the adapter whenever the list is updated
        viewModel.playerInfosList.observe(this, Observer { playerInfoList ->
            val names = arrayListOf<String>()
            playerInfoList.forEach{ names.add("${it.name}    ${it.year_from}-${it.year_to}")  }

            val adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, names)

            searchAutoCompleteTextView.setAdapter(adapter)
        })
    }
}
