package com.example.finwise.views.signup

data class SignupUiState(
    val name: String = "",
    val email: String = "",
    val mobileNumber: String = "",
    val dateOfBirth: String = "",
    val password: String = "",
    val confirmPassword: String = "",

    val onChangeName : (String) -> Unit = {},
    val onChangeEmail : (String) -> Unit = {},
    val onChangePassword : (String) -> Unit = {},
    val onChangeConfirmPassword : (String) -> Unit = {},
    val onChangeMobileNumber : (String) -> Unit = {},
    val onChangeDateOfBirth : (String) -> Unit = {}

) {



}