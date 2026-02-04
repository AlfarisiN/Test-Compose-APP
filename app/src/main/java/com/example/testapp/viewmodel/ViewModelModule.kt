package com.example.testapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testapp.model.DaggerViewModelFactory
import com.example.testapp.model.userlogin.UserDTO
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
//    @ViewModelKey(UserDTO::class)
    abstract fun bindUserViewModel(viewModel: UserDTO): ViewModel
}
