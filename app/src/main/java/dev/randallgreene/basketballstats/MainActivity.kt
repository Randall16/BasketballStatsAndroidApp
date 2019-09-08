package dev.randallgreene.basketballstats

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dev.randallgreene.basketballstats.ui.AutoCompletePlayerNameAdapter
import dev.randallgreene.basketballstats.viewmodels.PlayerViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PlayerViewModel
    private lateinit var searchAutoCompleteTextView: AutoCompleteTextView
    private var autoCompletePlayerNameAdapter: AutoCompletePlayerNameAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))

        setUpAutocompleteTextView()
        subscribeToViewModel()
    }

    private fun setUpAutocompleteTextView() {
        // find and limit the search view to a single line
        searchAutoCompleteTextView = findViewById(R.id.searchAutoCompleteTextView)
        searchAutoCompleteTextView.setSingleLine(true)

        // Make request to viewModel when user selects a player from the list\
        searchAutoCompleteTextView.setOnItemClickListener { parent, view, position, id ->

            val s = autoCompletePlayerNameAdapter?.getItem(position)?.player_id ?: "default id"
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show()

            // Hide the keyboard
            val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(searchAutoCompleteTextView.windowToken, 0)

            viewModel.fetchPlayerById(s)
        }
    }

    private fun subscribeToViewModel() {

        // Find the viewModel
        viewModel = ViewModelProviders.of(this).get(PlayerViewModel::class.java)

        // Tell viewModel to fetch all Player Names
        viewModel.fetchPlayerInfosList()

        // Observe the viewModel and change the autoCompletePlayerNameAdapter whenever the list is updated
        viewModel.playerInfosList.observe(this, Observer { playerInfoList ->
            autoCompletePlayerNameAdapter = AutoCompletePlayerNameAdapter(this, playerInfoList)
            searchAutoCompleteTextView.setAdapter(autoCompletePlayerNameAdapter)
        })

    }
}
