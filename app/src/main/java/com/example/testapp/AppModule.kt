package com.example.testapp

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Singleton

@Module
object AppModule {

    @Provides
    @Singleton
    fun provideIoScheduler() = Schedulers.io()

    @Provides
    @Singleton
    fun provideMainScheduler() = AndroidSchedulers.mainThread()
}