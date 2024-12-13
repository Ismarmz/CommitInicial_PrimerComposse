package com.example.primercomposse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.primercomposse.ui.theme.PrimerComposseTheme

//Esta es la clase principal que extiende ComponetActivity. Es el punto de entrada de la
//aplicación en composse
class MainActivity : ComponentActivity() {
    //método onCreate, se llama cuando la actividad se crea
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge permite que la interfaz ocupe toda la pantalla sin recortes
        enableEdgeToEdge()
        // SetContent es donde se define la interfaz de usuario de la actividad
        setContent {
            //PrimerComposseTheme es un tema que se aplica a toda la interfaz
            PrimerComposseTheme {
                //Scaffold es un contenedor básico de interfaz
                //innerPadding asegura que el contenido no se superponda
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp) // Espaciado alrededor
                ) { innerPadding ->

                    // Llamada a la función Greeting con un nombre editable
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    // Usamos estado para cambiar el texto dinámicamente
    val name = remember { mutableStateOf("Android") }

    // Contenedor de la interfaz
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Muestra el nombre actual con colores modificados
        Text(
            text = "Hello ${name.value}!",
            style = TextStyle(
                color = MaterialTheme.colorScheme.primary, // Color del texto basado en el esquema del tema
                fontSize = 24.sp
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Botón que cambia el nombre cuando se presiona
        Button(onClick = {
            name.value = if (name.value == "Android") "Compose" else "Android"
        }) {
            Text(
                text = "Change Name",
                style = TextStyle(
                    color = Color.Green, // Color blanco para el texto del botón
                    fontSize = 18.sp
                )
            )
        }
    }
}
//@Preview: Esta anotación permite ver cómo se verá el Composable en
// el diseño previo de Android Studio, sin necesidad de ejecutar la app en un dispositivo real.
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrimerComposseTheme {
        Greeting()
    }
}
