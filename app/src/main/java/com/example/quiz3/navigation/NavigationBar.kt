package com.example.quiz3.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter


@Composable
fun NavigationBar(navIcon: Painter ,navDescription: String, modifier: Modifier = Modifier, tint: Color = colorScheme.onSurface, textColor: Color = colorScheme.onSurface) {
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Icon(painter = navIcon, contentDescription = navDescription, tint = tint)
        Text(text = navDescription, style = MaterialTheme.typography.bodyLarge, color = textColor)
    }
}