package com.gustavo.miappevaluativa

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun SettingsScreen(navController: NavController, viewModel: SharedViewModel) {
    val colors = listOf(Color.White, Color.LightGray, Color.Yellow, Color.Cyan, Color.Magenta)
    val backgroundColor by viewModel.backgroundColor.observeAsState(Color.White)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor) // Aplicamos el color de fondo
            .padding(16.dp)
    ) {
        Text(
            text = "Selecciona un color de fondo:",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            color = Color(0xFF1E88E5), // Color de texto atractivo
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Mostrar los colores como botones clicables con diseño mejorado
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            colors.forEach { color ->
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .padding(4.dp)
                        .background(color, shape = RoundedCornerShape(12.dp)) // Bordes redondeados
                        .clickable { viewModel.setBackgroundColor(color) } // Cambiar el color de fondo al hacer clic
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp)) // Espaciado entre los colores y el botón

        // Botón para regresar a la pantalla de inicio
        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF42A5F5)), // Color de fondo
            shape = RoundedCornerShape(12.dp) // Bordes redondeados
        ) {
            Text(
                text = "Volver al Inicio",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                color = Color.White
            )
        }
    }
}
