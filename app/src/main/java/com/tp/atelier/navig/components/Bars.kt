package com.tp.atelier.navig.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.tp.atelier.navig.ui.theme.Gradients

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(onNavigateToHome: () -> Unit) {
    TopAppBar(
        title = { 
            Text(
                "Navigation",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            ) 
        },
        modifier = Modifier
            .background(Gradients.primaryGradient)
            .fillMaxWidth(),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@Composable
fun AppBottomBar(onNavigateToHome: () -> Unit, onNavigateToScreen2: () -> Unit) {
    NavigationBar(
        modifier = Modifier
            .background(Gradients.primaryGradient)
            .fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.95f)
    ) {
        NavigationBarItem(
            selected = false,
            onClick = onNavigateToHome,
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = false,
            onClick = onNavigateToScreen2,
            icon = { Text("2") },
            label = { Text("Screen 2") }
        )
    }
}
