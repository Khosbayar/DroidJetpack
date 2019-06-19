package hs.khosbayar.droidjetpack.second

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class SecondViewModelProviderFactory(private val app: Application, private val chosenNumber: Int) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SecondViewModel::class.java))
            return SecondViewModel(app, chosenNumber) as T

        throw IllegalArgumentException("Unknown view model class")
    }
}