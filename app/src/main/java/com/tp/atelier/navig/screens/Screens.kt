package com.tp.atelier.navig.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tp.atelier.navig.ui.theme.Gradients

@Composable
fun HomeScreen(onNavigateToScreen1: () -> Unit) {
    ScreenLayout(title = "Home") {
        GradientButton(onClick = onNavigateToScreen1) {
            Text("Go to Screen 1")
        }
    }
}

@Composable
fun Screen1(onNavigateToScreen2: () -> Unit, onNavigateBack: () -> Unit) {
    ScreenLayout(title = "Screen 1") {
        GradientButton(onClick = onNavigateToScreen2) {
            Text("Go to Screen 2")
        }
        GradientButton(onClick = onNavigateBack) {
            Text("Back")
        }
    }
}

@Composable
fun Screen2(onNavigateToScreen3: () -> Unit, onNavigateBack: () -> Unit) {
    ScreenLayout(title = "Screen 2") {
        GradientButton(onClick = { onNavigateToScreen3() }) {
            Text("Go to Screen 3")
        }
        GradientButton(onClick = onNavigateBack) {
            Text("Back")
        }
    }
}

@Composable
fun Screen3(value: Int, onNavigateBack: () -> Unit) {
    ScreenLayout(title = "Screen 3") {
        Text("Value received: $value")
        GradientButton(onClick = onNavigateBack) {
            Text("Back")
        }
    }
}

@Composable
private fun ScreenLayout(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Gradients.backgroundGradient)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            AnimatedVisibility(
                visible = true,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    content()
                }
            }
        }
    }
}

@Composable
private fun GradientButton(
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
            .background(Gradients.primaryGradient),
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp
        )
    ) {
        content()
    }
}
