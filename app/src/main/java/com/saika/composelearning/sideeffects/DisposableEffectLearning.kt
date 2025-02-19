package com.saika.composelearning.sideeffects

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

@Composable
fun DisposableEffectLearning() {
    var screen by remember {
        mutableStateOf("Login")
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {
            screen = "Home"
        }) {

            Text(text = "Go to Home")

        }
    }

    when (screen) {
        "Login" -> LoginScreen()
        "Home" -> HomeScreen()
    }
}

@Composable
fun LoginScreen(){
    LifecycleListener(
        onResume = {
            Log.e("Test", "On Resume")
        }
    )
}

@Composable
fun HomeScreen(){

}

@Composable
fun LifecycleListener(
    onCreate:(() -> Unit)? = null,
    onStart:(() -> Unit)? = null,
    onResume:(() -> Unit)? = null,
    onPause:(() -> Unit)? = null,
    onStop:(() -> Unit)? = null,
    onDestroy:(() -> Unit)? = null,
    onAny:(() -> Unit)? = null,
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(
        key1 = lifecycleOwner,
        effect = {
            val lifecycleObserver = LifecycleEventObserver { _, event ->
                when(event) {
                    Lifecycle.Event.ON_CREATE -> onCreate?.invoke()
                    Lifecycle.Event.ON_START -> onStart?.invoke()
                    Lifecycle.Event.ON_RESUME -> onResume?.invoke()
                    Lifecycle.Event.ON_PAUSE -> onPause?.invoke()
                    Lifecycle.Event.ON_STOP -> onStop?.invoke()
                    Lifecycle.Event.ON_DESTROY -> onDestroy?.invoke()
                    Lifecycle.Event.ON_ANY -> onAny?.invoke()
                }
            }
            lifecycleOwner.lifecycle.addObserver(lifecycleObserver)
            onDispose {
                Log.e("Test","Remove observer")
                lifecycleOwner.lifecycle.removeObserver(lifecycleObserver)
            }
        }
    )
}