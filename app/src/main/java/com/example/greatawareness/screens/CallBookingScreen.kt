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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.greatawareness.data.Expert
import com.example.greatawareness.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CallBookingScreen(navController: NavController) {
    var experts by remember { mutableStateOf(listOf<Expert>()) }

    LaunchedEffect(Unit) {
        experts = listOf(
            Expert(
                id = "expert1",
                name = "Dr. Sarah Johnson",
                specialization = "Career Coach",
                bio = "10+ years experience in career development",
                imageUrl = null,
                rating = 4.8f,
                totalCalls = 150,
                tokensPerMinute = 1.5f,
                isAvailable = true
            ),
            Expert(
                id = "expert2",
                name = "Mike Chen",
                specialization = "Business Strategy",
                bio = "Former Fortune 500 executive",
                imageUrl = null,
                rating = 4.9f,
                totalCalls = 89,
                tokensPerMinute = 2.0f,
                isAvailable = true
            )
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Book a Call", fontWeight = FontWeight.Bold) },
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
            items(experts) { expert ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { navController.navigate(Screen.ExpertDetail.createRoute(expert.id)) }
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                        
                        Spacer(modifier = Modifier.width(16.dp))
                        
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = expert.name,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                text = expert.specialization,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    Icons.Default.Star,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    tint = Color(0xFFFFD700)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "${expert.rating}",
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                        
                        Button(
                            onClick = { navController.navigate(Screen.ExpertDetail.createRoute(expert.id)) }
                        ) {
                            Text("Book")
                        }
                    }
                }
            }
        }
    }
} 