package com.example.finwise.di

import com.example.finwise.views.login.LoginViewModel
import com.example.finwise.views.signup.SignupViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = {

}

val viewModelsModule = module  {
    viewModelOf(::SignupViewModel)
    viewModelOf(::LoginViewModel)

}