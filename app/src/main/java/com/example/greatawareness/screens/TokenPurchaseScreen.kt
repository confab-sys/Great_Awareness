package com.example.greatawareness.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.greatawareness.data.TokenPackage
import com.example.greatawareness.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TokenPurchaseScreen(navController: NavController) {
    var tokenPackages by remember { mutableStateOf(listOf<TokenPackage>()) }

    LaunchedEffect(Unit) {
        tokenPackages = listOf(
            TokenPackage(
                id = "basic",
                name = "Basic",
                tokens = 50,
                price = 9.99,
                description = "Perfect for getting started"
            ),
            TokenPackage(
                id = "popular",
                name = "Popular",
                tokens = 150,
                price = 24.99,
                description = "Most popular choice",
                isPopular = true
            ),
            TokenPackage(
                id = "premium",
                name = "Premium",
                tokens = 300,
                price = 44.99,
                description = "Best value for frequent users"
            )
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Buy Tokens", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "Choose a Token Package",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            items(tokenPackages) { package ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { navController.navigate(Screen.Payment.createRoute(package.id)) }
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = package.name,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold
                            )
                            if (package.isPopular) {
                                Chip(
                                    onClick = { },
                                    colors = ChipDefaults.chipColors(
                                        containerColor = MaterialTheme.colorScheme.primary
                                    )
                                ) {
                                    Text("Popular")
                                }
                            }
                        }
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Text(
                            text = "${package.tokens} tokens",
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                        
                        Text(
                            text = "$${package.price}",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        
                        Text(
                            text = package.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        Button(
                            onClick = { navController.navigate(Screen.Payment.createRoute(package.id)) },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Buy Now")
                        }
                    }
                }
            }
        }
    }
} 