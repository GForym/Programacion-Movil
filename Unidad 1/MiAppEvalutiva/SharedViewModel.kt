//PRESENTADO POR: GUSTAVO FORY
package com.gustavo.miappevaluativa
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData

class SharedViewModel : ViewModel() {
    private val _backgroundColor = MutableLiveData(Color.White)
    val backgroundColor: LiveData<Color> = _backgroundColor

    fun setBackgroundColor(color: Color) {
        _backgroundColor.value = color
    }
}
