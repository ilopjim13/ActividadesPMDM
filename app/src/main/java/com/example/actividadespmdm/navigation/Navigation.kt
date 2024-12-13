package com.example.actividadespmdm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.actividadespmdm.screens.Actividad1
import com.example.actividadespmdm.screens.Actividad3
import com.example.actividadespmdm.screens.Actividad4
import com.example.actividadespmdm.screens.Actividad5
import com.example.actividadespmdm.screens.Inicio

@Composable
fun Actividades(modifier: Modifier = Modifier) {
    val navigationController = rememberNavController()
    NavHost(
        navController = navigationController,
        startDestination = Inicio
    ) {
        composable<Inicio> {
            Inicio(navigationController)
        }
        composable<Actividad1> {
            Actividad1(navigationController, modifier)
        }
        composable<Actividad2> {
            Actividad1(navigationController, modifier)
        }
        composable<Actividad3> {
            Actividad3(navigationController, modifier)
        }
        composable<Actividad4> {
            Actividad4(navigationController, modifier)
        }
        composable<Actividad5> {
            Actividad5(navigationController, modifier)
        }
    }
}