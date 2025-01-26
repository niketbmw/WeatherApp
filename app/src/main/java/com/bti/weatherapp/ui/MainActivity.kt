package com.bti.weatherapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.bti.weatherapp.utils.UiState
import com.bti.weatherapp.ui.theme.WeatherAppTheme
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.material3.CircularProgressIndicator
import com.bti.weatherapp.domain.entities.Post
import com.bti.weatherapp.ui.viewmodel.PostViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ElevatedCard
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import com.bti.weatherapp.ui.theme.PurpleGrey40
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: PostViewModel by viewModels()
                    val uiState by viewModel.demoUiStates.collectAsStateWithLifecycle()
                    UserListScreen(uiState = uiState)
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun UserListScreen(
    uiState: UiState<Post>,
    modifier: Modifier = Modifier,
) {

    AnimatedContent(uiState) { animatedUiState ->
        when (animatedUiState) {
            is UiState.Success -> {
                // Do on UiState.Success case here
                val post = animatedUiState.data
                Surface {
                    Column(
                        modifier = modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Random Post",
                            modifier = Modifier.padding(12.dp),
                            style = MaterialTheme.typography.titleLarge
                        )
                        ElevatedCard(
                            modifier = Modifier
                                .padding(8.dp)
                                .wrapContentHeight()
                        ) {
                            Column(
                                modifier = Modifier
                                    .background(PurpleGrey40)
                                    .padding(vertical = 20.dp, horizontal = 10.dp)
                                    .wrapContentHeight()
                            ) {
                                Text(post.title, style = MaterialTheme.typography.titleMedium)
                                Spacer(modifier = Modifier.padding(4.dp))
                                Text(post.body, style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                    }
                }
            }

            is UiState.Failure -> {
                // Do on UiState.Failure case here
                Text("Unexpected error! Reason: ${animatedUiState.throwable.message}")
            }

            is UiState.Loading -> {
                Box(contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            is UiState.Empty -> {
                // Do on UiState.Empty case here
            }

        }
    }
}