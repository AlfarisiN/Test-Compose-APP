package com.example.testapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.internal.Provider
import javax.inject.Inject

class DaggerViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass]
            ?: creators.entries.first { modelClass.isAssignableFrom(it.key) }.value
        return creator.get() as T
    }
}