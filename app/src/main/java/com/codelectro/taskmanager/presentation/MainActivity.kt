package com.codelectro.taskmanager.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.lifecycleScope
import androidx.ui.tooling.preview.Preview
import com.codelectro.taskmanager.network.Resource
import com.codelectro.taskmanager.network.model.ErrorResponse
import com.codelectro.taskmanager.network.model.MessageResponse
import com.codelectro.taskmanager.network.model.SignupRequest
import com.codelectro.taskmanager.presentation.ui.TaskmanagerTheme
import com.codelectro.taskmanager.repository.AuthRepository
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var repository: AuthRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskmanagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }

        lifecycleScope.launchWhenCreated {
           val res: Resource<MessageResponse>
           = repository.signup(SignupRequest("Test5", "test5@test.com", "test123"))
            //println("Get DATA $res")
            when(res) {
                is Resource.Success -> println("Data ${res.data}")
                is Resource.Failure ->   println(Gson().fromJson(res.errorBody?.charStream(), ErrorResponse::class.java))
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
  Text(text = "Hello")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskmanagerTheme {
        Greeting("Android")
    }
}