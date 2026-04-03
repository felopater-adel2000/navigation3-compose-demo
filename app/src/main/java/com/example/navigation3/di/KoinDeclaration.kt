package com.example.navigation3.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.KoinApplication
import org.koin.core.annotation.Module


@KoinApplication(modules = [AppModule::class])
class KoinApplication

@Module
@ComponentScan("com.example")
class AppModule {

}