package com.example.finwise.views.login

data class LoginUiState(
    val email: String = "",
    val password: String = "",

    val onChangeEmail : (String) -> Unit = {},
    val onChangePassword : (String) -> Unit = {}
) {
}