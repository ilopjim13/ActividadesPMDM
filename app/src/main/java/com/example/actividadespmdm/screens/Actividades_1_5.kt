package com.example.actividadespmdm.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.actividadespmdm.Cabecera
import com.example.actividadespmdm.viewModel.ViewModel

/*
Actividad 1:
Hacer que el texto del botón muestre "Cargar perfil", pero cambie a "Cancelar"
cuando se muestre la línea de progreso... Cuando pulsemos "Cancelar" vuelve al texto por defecto.
*/

@Composable
fun Actividad1(navController: NavController, modifier: Modifier = Modifier) {
    var showLoading by rememberSaveable { mutableStateOf(false) }

    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (showLoading) {
            CircularProgressIndicator(
                color = Color.Red,
                strokeWidth = 10.dp
            )
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Red,
                trackColor = Color.LightGray
            )
            Spacer(Modifier.height(30.dp))
        }

        Button(
            onClick = { showLoading = !showLoading }
        ) {
            Text(text = if(showLoading)"Cancelar" else "Cargar perfil")
        }
    }

    Cabecera(navController, modifier)
}

/*
Actividad 2:
Modifica ahora también que se separe el botón de la línea de progreso 30 dp,
pero usando un estado... es decir, cuando no sea visible no quiero que tenga la separación
aunque no se vea.
*/


/*
Actividad 3:
- Separar los botones entre ellos 10 dp, del indicador de progreso 15 dp y centrarlos horizontalmente.
- Cuando se clique el botón Incrementar, debe añadir 0.1 a la propiedad progress y quitar 0.1
  cuando se pulse el botón Decrementar.
- Evitar que nos pasemos de los márgenes de su propiedad progressStatus (0-1)
*/
@Composable
fun Actividad3(navController: NavController, modifier: Modifier = Modifier) {
    var progress by rememberSaveable { mutableFloatStateOf(0f) }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(progress = progress)


        Spacer(Modifier.height(15.dp))

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = { if(progress in (0f..0.99f)) progress += 0.1f }) {
                Text(text = "Incrementar")
            }
            Spacer(Modifier.width(10.dp))
            Button(onClick = { if(progress in (0.01f..1.1f)) progress -= 0.1f }) {
                Text(text = "Reducir")
            }
        }
    }

    Cabecera(navController, modifier)
}


/*
Actividad 4:
Sitúa el TextField en el centro de la pantalla y haz que reemplace el valor de una coma por un punto
y que no deje escribir más de un punto decimal...
*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Actividad4(navController: NavController, modifier: Modifier = Modifier) {
    val viewModel by remember {  mutableStateOf(ViewModel()) }
    val myVal by rememberSaveable { viewModel.text }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = myVal,
            onValueChange = { viewModel.onValueChangeText(it) },
            label = { Text(text = "Importe") }
        )
    }

    Cabecera(navController, modifier)
}


/*
Actividad 5:
Haz lo mismo, pero elevando el estado a una función superior y usando un componente OutlinedTextField
al que debes añadir un padding alrededor de 15 dp y establecer colores diferentes en los bordes
cuando tenga el foco y no lo tenga.
A nivel funcional no permitas que se introduzcan caracteres que invaliden un número decimal.
*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Actividad5(navController: NavController, modifier: Modifier = Modifier) {
    var myVal by rememberSaveable { mutableStateOf("") }

    InputText(myVal) {
        val regex = Regex("^[0-9,]*\\.?[0-9]?\$")

        myVal = if (it.isBlank() || regex.matches(it)) {
            it.replace(",", ".")
        } else {
            it.take(it.length - 1)
        }
    }

    Cabecera(navController, modifier)
}

@Composable
fun InputText(myVal:String, onValueChange:(String)->Unit) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = myVal,
            onValueChange = onValueChange ,
            label = { Text(text = "Importe") },
            colors = customColors()
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun customColors(): TextFieldColors {
    return TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = Color.Green,
        unfocusedBorderColor = Color.Red )
}
