package com.example.actividadespmdm.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.actividadespmdm.navigation.Actividad1
import com.example.actividadespmdm.navigation.Actividad3
import com.example.actividadespmdm.navigation.Actividad4
import com.example.actividadespmdm.navigation.Actividad5

@Composable
fun Inicio(navController: NavController) {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Row {
            Button(onClick = {navController.navigate(Actividad1)}) {
                Text("Actividad 1")
            }
            Button(onClick = {navController.navigate(Actividad1)}) {
                Text("Actividad 2")
            }
        }
        Row {
            Button(onClick = {navController.navigate(Actividad3)}) {
                Text("Actividad 3")
            }
            Button(onClick = {navController.navigate(Actividad4)}) {
                Text("Actividad 4")
            }
        }
        Button(onClick = {navController.navigate(Actividad5)}) {
            Text("Actividad 5")
        }

    }
}
