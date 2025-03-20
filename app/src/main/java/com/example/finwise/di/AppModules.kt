package com.example.finwise.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finwise.views.signup.SignupViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = {

}

val viewModelsModule = module  {
    viewModelOf(::SignupViewModel)
}