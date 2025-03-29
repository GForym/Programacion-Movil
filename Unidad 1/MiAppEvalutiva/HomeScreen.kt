package com.gustavo.miappevaluativa

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background // Para background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment // Para Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight // Para FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import android.widget.FrameLayout
import androidx.compose.ui.platform.ComposeView

@Composable
fun HomeScreen(
    navController: NavController,
    habitViewModel: HabitViewModel,
    sharedViewModel: SharedViewModel
) {
    val habits by habitViewModel.habits.observeAsState(emptyList())
    val context = LocalContext.current
    val backgroundColor by sharedViewModel.backgroundColor.observeAsState(Color(0xFFE3F2FD))

    AndroidView(
        factory = { ctx ->
            FrameLayout(ctx).apply {
                layoutParams = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )

                addView(ComposeView(ctx).apply {
                    layoutParams = FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.MATCH_PARENT
                    )

                    setContent {
                        MaterialTheme {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(backgroundColor)
                                    .padding(24.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Seguimiento de Hábitos",
                                    style = MaterialTheme.typography.headlineMedium.copy(
                                        fontWeight = FontWeight.Bold
                                    ),
                                    color = Color(0xFF1E88E5)
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                Column(
                                    modifier = Modifier.weight(1f),
                                    verticalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    habits.forEach { habit ->
                                        Button(
                                            onClick = { navController.navigate("details/${habit.name}") },
                                            modifier = Modifier.fillMaxWidth(),
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color.White,
                                                contentColor = Color.Black
                                            )
                                        ) {
                                            Text(text = habit.name)
                                        }
                                    }
                                }

                                Button(
                                    onClick = { navController.navigate("add_habit") },
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFFFFCA28)
                                    )
                                ) {
                                    Text(text = "Añadir Hábito", color = Color.Black)
                                }

                                Button(
                                    onClick = { navController.navigate("settings") },
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFF81C784)
                                    )
                                ) {
                                    Text(text = "Configuración", color = Color.White)
                                }
                            }
                        }
                    }
                })
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}
