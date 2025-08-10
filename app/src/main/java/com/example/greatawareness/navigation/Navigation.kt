package com.example.greatawareness.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.greatawareness.screens.*

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Home : Screen("home")
    object CallBooking : Screen("call_booking")
    object ExpertDetail : Screen("expert_detail/{expertId}") {
        fun createRoute(expertId: String) = "expert_detail/$expertId"
    }
    object TokenPurchase : Screen("token_purchase")
    object CallHistory : Screen("call_history")
    object Profile : Screen("profile")
    object Payment : Screen("payment/{packageId}") {
        fun createRoute(packageId: String) = "payment/$packageId"
    }
}

@Composable
fun GreatAwarenessNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }
        
        composable(Screen.Register.route) {
            RegisterScreen(navController)
        }
        
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        
        composable(Screen.CallBooking.route) {
            CallBookingScreen(navController)
        }
        
        composable(Screen.ExpertDetail.route) { backStackEntry ->
            val expertId = backStackEntry.arguments?.getString("expertId")
            ExpertDetailScreen(navController, expertId ?: "")
        }
        
        composable(Screen.TokenPurchase.route) {
            TokenPurchaseScreen(navController)
        }
        
        composable(Screen.CallHistory.route) {
            CallHistoryScreen(navController)
        }
        
        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
        
        composable(Screen.Payment.route) { backStackEntry ->
            val packageId = backStackEntry.arguments?.getString("packageId")
            PaymentScreen(navController, packageId ?: "")
        }
    }
} 