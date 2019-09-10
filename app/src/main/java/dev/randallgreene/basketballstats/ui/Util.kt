package dev.randallgreene.basketballstats.ui

import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AutoCompleteTextView
import android.widget.TextView
import dev.randallgreene.basketballstats.R

fun convertYearToYYHyphenYY(year: Int): String {

    val fYear = (year - 1).toString()
    val sYear = year.toString()

    return fYear.substring(2) + '-' + sYear.substring(2)
}

fun convertYearRangeToYYYYHyphenYY(yearFrom: Int, yearTo: Int): String {
    val yearFromStr = yearFrom.toString()
    val yearToStr = yearTo.toString()

    return yearFromStr + '-' + yearToStr.substring(2)
}

fun AutoCompleteTextView.setupClearButtonWithAction(inputManager: InputMethodManager) {

    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            val clearIcon = if (editable?.isNotEmpty() == true) R.drawable.ic_clear_black_24dp else 0
            setCompoundDrawablesWithIntrinsicBounds(0, 0, clearIcon, 0)
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit
    })

    setOnTouchListener(View.OnTouchListener { _, event ->
        if (event.action == MotionEvent.ACTION_UP) {
            if (event.rawX >= (this.right - this.compoundPaddingRight)) {

                // clear the text
                this.setText("")

                if (!this.hasFocus() && this.requestFocus()) {
                    inputManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
                }
            }
        }
        return@OnTouchListener false // returning false because don't want vibration after clear
    })
}

// Below are some extensions functions to handle displaying potentially null values
fun TextView.displayValue(number: Number?) {
    this.text = number?.toString() ?: ""
}

fun TextView.displayValue(text: String?) {
    this.text = text ?: ""
}

fun TextView.displayPercentValue(value: Double?) {
    if (value == null)
        this.text = ""
    else if (value > 1)
        this.text = value.toString()
    else {
        val percent = String.format("%.1f", value * 100)
        this.text = percent
    }
}