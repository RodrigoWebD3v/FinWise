package com.example.finwise.views.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel: ViewModel()
{
    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState())
    val uiState = _uiState.asStateFlow()

    init{
        _uiState.update { currentState ->
            currentState.copy(
                onChangeEmail = { email ->
                    _uiState.update { it ->
                        it.copy(email = email)
                    }
                },
                onChangePassword = { password ->
                    _uiState.update { it ->
                        it.copy(password = password)
                    }
                }
            )
        }
    }
}