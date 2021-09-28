package com.bcgdv.challenge2.repositories

import com.bcgdv.challenge2.models.Order
import com.bcgdv.challenge2.models.Watch

class OrderRepository(private val items: List<Watch>) {
    private var mockId = 1

    fun newOrder(itemIds: List<String>): Order {
        val order = Order(mockId.toString(), itemIds)
        mockId++
        return order
    }

    fun getTotalPrice(order: Order): Double {
        val itemsMap = mutableMapOf<String, Watch>()
        for (watch: Watch in items) {
            if (watch.id != null) {
                itemsMap[watch.id] = watch
            }
        }
        var total = 0.0
        val orderItemsMap = mutableMapOf<String, Int>()
        for (itemId: String in order.itemIds) {
            orderItemsMap[itemId] = orderItemsMap[itemId]?.plus(1) ?: 1
        }
        for ((itemId, count) in orderItemsMap) {
            if (itemsMap.containsKey(itemId)) {
                val watch = itemsMap[itemId]!!
                if (watch.discountQuantity in 1..count) {
                    total += count / watch.discountQuantity * watch.discountPrice
                    total += (count % watch.discountQuantity) * watch.unitPrice
                } else {
                    total += count * watch.unitPrice
                }
            }
        }
        return total
    }
}