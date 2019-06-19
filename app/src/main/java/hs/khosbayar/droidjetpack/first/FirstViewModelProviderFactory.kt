package hs.khosbayar.droidjetpack.first

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class FirstViewModelProviderFactory(private val text: String) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FirstViewModel::class.java)){
            return FirstViewModel(text) as T
        }
        throw IllegalArgumentException("Unknown view model")
    }
}