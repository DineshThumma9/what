package com.example.experiment.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.experiment.ui.theme.ExperimentTheme

data class Message(val text: String, val isFromUser: Boolean)

val chatMessages = mutableStateListOf(
    Message("Hello!", isFromUser = true),
    Message("Hi, how can I assist you today?", isFromUser = false)
)

@Composable
fun ChatScreen() {
    val userInput = remember { mutableStateOf("") }
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dynamicPadding(screenWidth)) // Dynamic padding based on screen size
    ) {
        // Chat Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Sanjeevani AI Assistant", style = MaterialTheme.typography.titleLarge)
            Text("Online", style = MaterialTheme.typography.bodyMedium, color = Color.Green)
        }

        // Chat Bubbles Section (Scrollable)
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            reverseLayout = true // Ensures new messages are displayed at the bottom
        ) {
            items(chatMessages) { message ->
                if (message.isFromUser) {
                    UserMessageBubble(message.text, screenWidth)
                } else {
                    BotMessageBubble(message.text, screenWidth)
                }
            }
        }

        // Input Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = userInput.value,
                onValueChange = { newValue -> userInput.value = newValue },
                placeholder = { PlaceholderText() },
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Transparent),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedPlaceholderColor = Color.Gray
                ),
                shape = RoundedCornerShape(12.dp)
            )
            IconButton(onClick = {
                if (userInput.value.isNotBlank()) {
                    chatMessages.add(0, Message(userInput.value, true)) // Add user message to the start
                    userInput.value = ""
                    simulateBotResponse() // Simulate bot response
                }
            }) {
                Icon(Icons.Filled.Person, contentDescription = "Send")
            }
        }
    }
}

@Composable
fun PlaceholderText() {
    Text("Ask your question…", fontSize = 16.sp)
}

private fun simulateBotResponse() {
    // Simulate a response from the bot
    chatMessages.add(0, Message("This is a simulated response from the bot.", false)) // Add bot response to the start
}

@Composable
fun UserMessageBubble(text: String, screenWidth: Dp) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Text(
            text = text,
            modifier = Modifier
                .widthIn(max = screenWidth * 0.7f) // Limit max width to 70% of the screen width
                .background(color = Color.Blue, shape = RoundedCornerShape(12.dp))
                .padding(12.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )
    }
}

@Composable
fun BotMessageBubble(text: String, screenWidth: Dp) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = text,
            modifier = Modifier
                .widthIn(max = screenWidth * 0.7f) // Limit max width to 70% of the screen width
                .background(color = Color.LightGray, shape = RoundedCornerShape(12.dp))
                .padding(12.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun dynamicPadding(screenWidth: Dp): Dp {
    return when {
        screenWidth < 600.dp -> 16.dp  // Mobile
        screenWidth < 840.dp -> 24.dp  // Small tablet
        else -> 32.dp                  // Large tablet
    }
}

@Composable
@Preview(showBackground = true)
@Preview(showBackground = true, device = "id:pixel_4")
@Preview(showBackground = true, device = "id:pixel_xl")
@Preview(showBackground = true, device = "id:pixel_5")
@Preview(showBackground = true, device = "id:pixel_c", name = "pixel_c")
fun PreviewChatScreen() {
    ExperimentTheme {
        ChatScreen()
    }
}
