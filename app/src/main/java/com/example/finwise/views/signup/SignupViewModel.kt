package com.example.finwise.views.signup

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignupViewModel : ViewModel() {


    private val _uiState = MutableStateFlow<SignupUiState>(SignupUiState())
    val uiState = _uiState.asStateFlow()

    fun onChangeEmail(it: String) {
        _uiState.update { valor ->
            valor.copy(email = it)
        }
    }

    init {

        _uiState.update { currentState ->
            currentState.copy(
                onChangeName = { name ->
                    _uiState.update { it ->
                        it.copy(name = name)
                    }
                },

                onChangeEmail = { email ->
                    _uiState.update { it ->
                        it.copy(email = email)
                    }
                },

                onChangePassword = { password ->
                    _uiState.update { it ->
                        it.copy(password = password)
                    }
                },

                onChangeConfirmPassword = { confirm ->
                    _uiState.update { it ->
                        it.copy(confirmPassword = confirm)
                    }
                },

                onChangeMobileNumber = { mobileNumber ->
                    _uiState.update { it ->
                        it.copy(mobileNumber = mobileNumber)
                    }
                },

                onChangeDateOfBirth = { dateOfBirth ->
                    _uiState.update { it ->
                        it.copy(dateOfBirth = dateOfBirth)
                    }
                }
            )
        }

    }

}