package com.bcgdv.challenge2.models

data class Watch(
    val id: String?,
    val name: String,
    val unitPrice: Double,
    val discountQuantity: Int = 0,
    val discountPrice: Double = 0.0
)
