package com.example.homemodule.di

import com.example.homemodule.clients.ClientsViewModel
import com.example.homemodule.maps.MapsViewModel
import com.example.homemodule.profile.ProfileViewModel
import com.example.homemodule.visits.VisitsViewModel
import org.koin.core.KoinApplication
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun KoinApplication.homeModule() {
    modules(
        module {
            viewModelOf(::VisitsViewModel)
            viewModelOf(::ProfileViewModel)
            viewModelOf(::MapsViewModel)
            viewModelOf(::ClientsViewModel)
        }
    )
}