package com.example.myquiz2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myquiz2.ui.theme.MyQuiz2Theme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextButton
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.input.PasswordVisualTransformation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyQuiz2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginPagePreview()
                }
            }
        }
    }
}

@Composable
fun LoginPage(modifier: Modifier = Modifier){
    var userInput by rememberSaveable { mutableStateOf("") }
    var passwordInput by rememberSaveable { mutableStateOf("") }
    val logo = painterResource(R.mipmap.logomahir)

    Column (
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 12.dp)
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,

    ){

        Column (
            modifier = Modifier
                .statusBarsPadding()
                .padding(horizontal = 12.dp)
                .safeDrawingPadding(),
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Image(
                painter = logo,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .padding(16.dp)
            )
        }

        Box(modifier = Modifier,
            Alignment.Center
        ) {
            Column (
                modifier = Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = userInput,
                    onValueChange = {userInput = it},
                    singleLine = true,
                    label = {Text(stringResource(R.string.nip))},
                    modifier = Modifier
                        .padding(bottom = 5.dp, top = 12.dp)
                )
                TextField(
                    value = passwordInput,
                    onValueChange = {passwordInput = it},
                    singleLine = true,
                    label = {Text(stringResource(R.string.password))},
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .padding(bottom = 5.dp, top = 12.dp)
                )
                val userValidation = LocalContext.current
                val passwordValidation = LocalContext.current
                val userPassValidation = LocalContext.current
                val login = LocalContext.current
                Button(onClick = {
                    if (userInput.isEmpty() && passwordInput.isEmpty()) {
                        Toast.makeText(userPassValidation, "NIP harus diisi dan Password harus diisi", Toast.LENGTH_SHORT).show()
                    }else if (userInput.isEmpty()) {
                        Toast.makeText(userValidation, "NIP harus diisi", Toast.LENGTH_SHORT).show()
                    } else if (passwordInput.isEmpty()) {
                        Toast.makeText(passwordValidation, "Password harus diisi", Toast.LENGTH_SHORT).show()
                    }else {
                        Toast.makeText(login, "Menuju Halaman Beranda…", Toast.LENGTH_SHORT).show()
                    }

                }) {
                    Text(stringResource(R.string.btn_login))
                }

                val csIkhwan = LocalContext.current
                TextButton(onClick={
                    Toast.makeText(csIkhwan, "Menghubungi CS Ikhwan…", Toast.LENGTH_SHORT).show()
                },
                ) {
                    Text("Hubungi CS Ikhwan")
                }
                val csAkhwat = LocalContext.current
                TextButton(onClick={
                    Toast.makeText(csAkhwat, "Menghubungi CS Akhwat…", Toast.LENGTH_SHORT).show()
                },
                ) {
                    Text("Hubungi CS Akhwat")
                }
            }
        }

        Column (
            verticalArrangement = Arrangement.Bottom
        ) {
            val faq = LocalContext.current
            OutlinedButton(onClick = { Toast.makeText(faq, "Menuju Halaman FAQ…", Toast.LENGTH_SHORT).show() }) {
                Text(stringResource(R.string.btn_faq))
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun LoginPagePreview() {
    MyQuiz2Theme {
        LoginPage()
    }
}