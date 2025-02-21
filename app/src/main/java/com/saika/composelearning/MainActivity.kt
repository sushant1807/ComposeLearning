package com.saika.composelearning

import SampleData
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saika.composelearning.navigation.ScreenA
import com.saika.composelearning.navigation.ScreenB
import com.saika.composelearning.navigation.ScreenC
import com.saika.composelearning.navigation.ScreenNavigationLearning
import com.saika.composelearning.scroll.ScrollableStateLearning
import com.saika.composelearning.sideeffects.DerivedStateOfLearning
import com.saika.composelearning.sideeffects.DisposableEffectLearning
import com.saika.composelearning.ui.theme.ComposeLearningTheme
import com.saika.composelearning.ui.theme.Purple40

class MainActivity : ComponentActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[UserStateViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeLearningTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    //MessageCard(card = Message("Sushant", "Compose Learning"))
                    //MessageUseCase("Something")
                    //ModifiersExamples()
                    //UserStateExample(viewModel)
                    //UserText()
                    //UserCustomCardLearning()
                    //UserButtons()
                    //UserTextField()
                    //LoginScreenView()
                    //AnimationLearning()
                    //ScaffoldLearning()

                    //Types of Side Effect
                    //Counter(10, onCountChange = { Log.e("Test", it.toString()) })
                    //RememberCoroutineScope()
                    //DisposableEffectLearning()
                    //DerivedStateOfLearning()

                    //ScrollableStateLearning()

                    ScreenNavigationLearning()
//                Conversation(SampleData.conversationSample)
                }
            }
        }
    }
}

@Composable
fun ModifiersExamples() {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(15.dp))
                //.border(3.dp, color = Color.Red)
                .background(color = Purple40)
                .clickable {
                    Log.e("Button", "Clicked here")
                },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Click Me", color = Color.White)
        }
    }

}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
    )
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(card: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {

        //Spacer(modifier =  Modifier.width(80.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Contact Image",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
            label = ""
        )

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = card.author,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.width(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = card.body,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}


@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    ComposeLearningTheme {
        //MessageCard(card = Message("Preview", "Message"))
        Conversation(SampleData.conversationSample)
    }
}