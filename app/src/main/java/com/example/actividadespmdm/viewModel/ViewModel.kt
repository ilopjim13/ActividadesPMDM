package com.example.actividadespmdm.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class ViewModel {

    private var _text = mutableStateOf("")
    val text:State<String> = _text


    fun onValueChangeText(t: String) {
        val regex = Regex("^[0-9,]*\\.?[0-9]?\$")

        if (t.isBlank() || regex.matches(t)) {
            _text.value = t.replace(",", ".")
        } else {
            _text.value = t.take(t.length - 1)
        }
    }

}