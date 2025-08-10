package com.example.greatawareness.data

import java.time.LocalDateTime

// User model
data class User(
    val id: String,
    val name: String,
    val email: String,
    val phoneNumber: String,
    val tokenBalance: Int = 0,
    val profileImageUrl: String? = null
)

// Call booking model
data class CallBooking(
    val id: String,
    val userId: String,
    val expertId: String,
    val expertName: String,
    val expertImageUrl: String?,
    val scheduledTime: LocalDateTime,
    val duration: Int, // in minutes
    val status: CallStatus,
    val tokensRequired: Int,
    val topic: String,
    val notes: String? = null
)

// Call status enum
enum class CallStatus {
    SCHEDULED,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED,
    NO_SHOW
}

// Token package model
data class TokenPackage(
    val id: String,
    val name: String,
    val tokens: Int,
    val price: Double,
    val currency: String = "USD",
    val description: String,
    val isPopular: Boolean = false
)

// Payment model
data class Payment(
    val id: String,
    val userId: String,
    val amount: Double,
    val currency: String,
    val tokenPackageId: String,
    val status: PaymentStatus,
    val timestamp: LocalDateTime,
    val paymentMethod: String
)

// Payment status enum
enum class PaymentStatus {
    PENDING,
    COMPLETED,
    FAILED,
    REFUNDED
}

// Expert model
data class Expert(
    val id: String,
    val name: String,
    val specialization: String,
    val bio: String,
    val imageUrl: String?,
    val rating: Float,
    val totalCalls: Int,
    val tokensPerMinute: Int,
    val isAvailable: Boolean = true
) 