# App de Seguimiento de Hábitos
# PRESENTADO POR: GUSTAVO FORY

Aplicación Android para registrar y monitorear el progreso de hábitos diarios, desarrollada con Jetpack Compose y arquitectura MVVM.

## Características
- 📝 Añadir nuevos hábitos
- 📊 Visualizar progreso diario
- 🎨 Personalizar color de fondo

## Paso a Paso Instalacion

## Paso 1: Configuracion de Android Studio
1. **Abrir Android Studio**  
   Inicia Android Studio y selecciona:  
   `File → New → New Project`

2. **Seleccionar Plantilla**  
   Elige la plantilla:  
   `Empty Activity` (Actividad Vacía)

3. **Configurar Proyecto**  
   Completa los campos con estos valores exactos:

   | Campo | Valor Requerido |
   |-------|-----------------|
   | **Name** | `MiAppEvaluativa` |
   | **Package name** | `com.gustavo.miappevaluativa` |
   | **Language** | `Kotlin` |
   | **Minimum SDK** | `API 26: Android 8.0 (Oreo)` |

4. **Finalizar**  
   Haz clic en el botón:  
   `Finish`

   ⏳ Espera a que Android Studio termine de configurar el proyecto (puede tomar 1-2 minutos).


## 📂 Paso 2: Estructura de Archivos

### Directorio Principal: `app/`
**Crear cada archivo en la ruta que se muestra a continuación:**

![image](https://github.com/user-attachments/assets/08a49944-bfa0-4426-b695-b259ead9deb4)


### 📝 Instrucciones para cada archivo:

1. **AddHabitScreen.kt**
   - Ruta: `app/src/main/java/com/gustavo/miappevaluativa/`
   - Contenido:AddHabitScreen.kt
     ```kotlin
     @Composable
     fun AddHabitScreen(
         navController: NavController,
         viewModel: HabitViewModel
     ) {
         // Copiar implementación completa desde GitHub
     }
     ```

2. **DetailsScreen.kt**
   - Ruta: Mismo paquete
   - Contenido:DetailsScreen.kt
     ```kotlin
     @Composable
     fun DetailsScreen(
         habitName: String,
         viewModel: HabitViewModel
     ) {
         // Copiar implementación completa desde GitHub
     }
     ```

3. **HabitViewModel.kt**
   - Ruta: Mismo paquete
   - Estructura clave: HabitViewModel.kt
     ```kotlin
     class HabitViewModel : ViewModel() {
         // Variables y métodos de tu implementación Copiar implementación completa desde GitHub
     }
     ```

4. **HomeScreen.kt**
   - Ruta: Mismo paquete
   - Debe contener: HomeScreen.kt
     ```kotlin
     @Composable
     fun HomeScreen(
         navController: NavController
     ) {
         // UI principal con lista de hábitos Copiar implementación completa desde GitHub
     }
     ```

5. **MainActivity.kt**
   - Ruta: Mismo paquete
   - Esqueleto básico: MainActivity.kt
     ```kotlin
     class MainActivity : ComponentActivity() {
         override fun onCreate(savedInstanceState: Bundle?) {
             // Configuración inicial Copiar implementación completa desde GitHub
         }
     }
     ```

6. **NavGraph.kt**
   - Ruta: Mismo paquete
   - Estructura de navegación: NavGraph.kt
     ```kotlin
     @Composable
     fun NavGraph(
         navController: NavHostController
     ) {
         // Definición de rutas Copiar implementación completa desde GitHub
     }
     ```

7. **SharedViewModel.kt**
   - Ruta: Mismo paquete
   - Para compartir estado: SharedViewModel.kt
     ```kotlin
     class SharedViewModel : ViewModel() {
         // Estado compartido (ej: color de fondo) Copiar implementación completa desde GitHub
     }
     ```

### 🔄 Cómo importar desde GitHub:
1. Para cada archivo:
   ```bash
   1. Crear archivo vacío en la ruta especificada
   2. Copiar TODO el contenido del archivo correspondiente en GitHub
   3. Verificar que las importaciones sean correctas

## 🛠️ Paso 2.1: Configuración de Recursos XML

### 📂 Estructura requerida en `res/`

![image](https://github.com/user-attachments/assets/d396166c-4400-4f34-a00e-ecbedafd5d38)

### 📝 Instrucciones detalladas:

#### 1. Crear directorio layout (si no existe):
1. En Android Studio:
   - Haz clic derecho en la carpeta `res/`
   - Selecciona: `New → Android Resource Directory`
   - En "Resource type": elige `layout`
   - Haz clic en `OK`

#### 2. Crear archivo activity_home.xml:
1. Haz clic derecho en la nueva carpeta `layout/`
2. Selecciona: `New → File`
3. Nombre: `activity_home.xml` (exactamente así)
4.  Haz clic en `OK`

#### 3. Copiar contenido desde GitHub:
- Abre el archivo `activity_home.xml` de tu repositorio GitHub
- Copia TODO el contenido (desde `<?xml` hasta la etiqueta de cierre)
- Pega en el archivo recién creado en Android Studio

## ⚙️ Paso 3: Configuración de Dependencias Gradle

### 📂 Ubicación de los archivos de configuración de las imlementaciones 

![image](https://github.com/user-attachments/assets/cd248ff8-ddbf-457a-b099-8e6eed1795b6)

1. Ubica el archivo `dependencies.gradle` en el repositorio
2. Copia **todas las implementaciones** listadas en el archivo
3. Pégalas en el bloque `dependencies` de tu `app/build.gradle.kts`
4. Asegúrate de incluir todas las que comienzan con `implementation`
5. Guardar cambios:
   Windows/Linux: Ctrl + S
   Mac: ⌘ + 
6. Sincronizar proyecto:
   Haz clic en el botón "Sync Now" que aparece en la barra superior amarilla
   O ve a: File > Sync Project with Gradle Files
   
## 🚀 Paso 4: Ejecutar la Aplicación
   Haz clic en el botón verde ▶️ "Run"

   
## Capturas de Pantalla
**Pantalla de Inicio** 

*Muestra la lista de hábitos registrados y botones de acción*

![image](https://github.com/user-attachments/assets/1e739edf-4faa-43ee-9cf0-936c59d18943)



**Pantalla de Configuración**

*Permite modificar el color de fondo de la aplicación*

![image](https://github.com/user-attachments/assets/f6df1d19-7f64-4f05-84e2-35d16ac2ce5e)



**Pantalla para Añadir Hábitos**

*Interfaz para registrar nuevos hábitos con campo de texto*

![image](https://github.com/user-attachments/assets/b505471b-830b-4001-81e2-4ae83410a033)



**Pantalla de Detalles y Progreso**  
*Muestra el historial de progreso y permite añadir nuevos registros*

![image](https://github.com/user-attachments/assets/cc2b07f3-650a-4031-a7ab-7e0c11126e5e)


