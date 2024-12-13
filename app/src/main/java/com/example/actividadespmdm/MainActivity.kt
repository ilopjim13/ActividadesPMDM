package com.example.actividadespmdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.actividadespmdm.navigation.Actividades
import com.example.actividadespmdm.screens.Actividad1
import com.example.actividadespmdm.screens.Actividad3
import com.example.actividadespmdm.screens.Actividad4
import com.example.actividadespmdm.screens.Actividad5
import com.example.actividadespmdm.screens.Inicio
import com.example.actividadespmdm.ui.theme.ActividadesPMDMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActividadesPMDMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Actividades(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Cabecera(navController:NavController, modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically, modifier = modifier.fillMaxWidth()) {
        IconButton(onClick = {navController.popBackStack()}) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Volver"
            )
        }

    }
}