package com.example.firstlanaapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstlanaapplication.R
import com.example.firstlanaapplication.components.ButtonComponent
import com.example.firstlanaapplication.components.MyTextFieldComponent
import com.example.firstlanaapplication.components.NormalTextComponent
import com.example.firstlanaapplication.components.PasswordTextFieldComponent

@ExperimentalMaterial3Api
@Composable
fun SignInScreen() {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(28.dp),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponent(value = stringResource(id = R.string.login))
            MyTextFieldComponent(labelValue = stringResource(id = R.string.username))
            PasswordTextFieldComponent(labelValue = stringResource(id = R.string.password))
            Spacer(modifier = Modifier.height(20.dp))
            ButtonComponent(value = stringResource(id = R.string.into))
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun DefaultPreviewOfSignInScreen(){
    SignInScreen()
}