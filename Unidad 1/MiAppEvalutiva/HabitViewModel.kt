//PRESENTADO POR: GUSTAVO FORY
package com.gustavo.miappevaluativa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Habit(val name: String, val progress: List<Int> = listOf()) // Define los hábitos con su nombre y su progreso

class HabitViewModel : ViewModel() {
    // Inicializamos _habits con una lista no nula.
    private val _habits = MutableLiveData<List<Habit>>(listOf(
        Habit("Ejercicio"),
        Habit("Meditación"),
        Habit("Lectura")
    ))
    val habits: LiveData<List<Habit>> = _habits

    // Método para añadir un nuevo hábito.
    fun addHabit(habit: Habit) {
        val currentHabits = _habits.value?.toMutableList() ?: mutableListOf() // Si la lista es null, crea una lista vacía.
        currentHabits.add(habit) // Añadir el nuevo hábito.
        _habits.value = currentHabits // Actualiza el LiveData con la nueva lista.
    }

    // Método para añadir progreso a un hábito específico.
    fun addProgressToHabit(habitName: String, progress: Int) {
        // Actualizamos el progreso de un hábito específico.
        val updatedHabits = _habits.value?.map { habit ->
            if (habit.name == habitName) {
                // Si encontramos el hábito, añadimos el progreso.
                habit.copy(progress = habit.progress + progress)
            } else {
                // Si no es el hábito buscado, lo dejamos tal como está.
                habit
            }
        } ?: listOf() // En caso de que _habits sea null, retornamos una lista vacía (aunque nunca será null debido a la inicialización).

        _habits.value = updatedHabits // Actualizamos el LiveData con la lista modificada.
    }
}
