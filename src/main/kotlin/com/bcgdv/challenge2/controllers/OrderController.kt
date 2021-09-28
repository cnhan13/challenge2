package com.bcgdv.challenge2.controllers

import com.bcgdv.challenge2.models.Watch
import com.bcgdv.challenge2.repositories.OrderRepository
import com.bcgdv.challenge2.repositories.WatchRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
public class OrderController {

    private lateinit var watchRepo: WatchRepository

    @PostMapping("/checkout")
    fun checkout(@RequestBody orderItemIds: List<String>): Map<String, Double> {
        watchRepo = WatchRepository()
        val watches: List<Watch> = watchRepo.getWatches()

        val orderRepo = OrderRepository(watches)
        val order = orderRepo.newOrder(orderItemIds)

        return mapOf(
            "price" to orderRepo.getTotalPrice(order)
        )
    }
}