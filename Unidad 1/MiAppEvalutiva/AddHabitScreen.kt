//PRESENTADO POR: GUSTAVO FORY
package com.gustavo.miappevaluativa

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AddHabitScreen(navController: NavController, habitViewModel: HabitViewModel) {
    var habitName by remember { mutableStateOf("") }
    val colors = MaterialTheme.colorScheme

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Título
        Text(
            text = "Añadir un nuevo Hábito",
            style = MaterialTheme.typography.headlineLarge.copy(
                color = colors.primary,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Campo de entrada de texto
        OutlinedTextField(
            value = habitName,
            onValueChange = { habitName = it },
            label = { Text("Nombre del Hábito") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colors.primary,
                unfocusedBorderColor = colors.outline,
                focusedLabelColor = colors.primary,
                unfocusedLabelColor = colors.outline
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botón para añadir el hábito
        Button(
            onClick = {
                if (habitName.isNotEmpty()) {
                    habitViewModel.addHabit(Habit(habitName))
                    navController.popBackStack()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "Añadir Hábito",
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para cancelar
        OutlinedButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "Cancelar",
                fontWeight = FontWeight.Bold
            )
        }
    }
}
