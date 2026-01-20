package com.example.musicalinstrumentsound.ui.theme
import com.example.musicalinstrumentsound.screens.SplashScreen
import com.example.musicalinstrumentsound.screens.HomeScreen
import com.example.musicalinstrumentsound.screens.InstrumentDetailScreen
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
data class Song(
    val title: String,
    val artist: String,
    val audioResId: Int
)

@Serializable
object SplashRoute

@Serializable
object SelectionRoute

@Serializable
object LyricalCategoryRoute

@Serializable
object ProfileRoute

@Serializable
data class InstrumentDetailRoute(val name: String)

data class Instrument(val name: String, val image: Int, val color: Color)

data class Selection(val name: String, val subname: String, val image: Int, val color: Color)


@Composable
fun InsrtumentNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = SplashRoute,
        modifier = modifier
    ) {
        composable<SplashRoute>(
            exitTransition = {
                androidx.compose.animation.fadeOut(animationSpec = tween(600))
            }
        ) {
            SplashScreen(onAnimationFinished = {
                navController.navigate(ProfileRoute) {
                    popUpTo(SplashRoute) { inclusive = true }
                }
            })
        }

        composable<ProfileRoute>(
            enterTransition = {
                androidx.compose.animation.fadeIn(animationSpec = tween(600))
            }
        ){

            HomeScreen(onInstrumentClick = { name ->
                navController.navigate(InstrumentDetailRoute(name))
            })
        }
        composable<InstrumentDetailRoute> { backStackEntry ->
            val route: InstrumentDetailRoute = backStackEntry.toRoute()
            InstrumentDetailScreen(instrumentName = route.name)
        }
    }
}
