package com.bcgdv.challenge2.repositories

import com.bcgdv.challenge2.models.Watch

class WatchRepository {
    fun getWatches(): List<Watch> = listOf(
        Watch("001", "Rolex", 100.0, 3, 200.0),
        Watch("002", "Michael Kors", 80.0, 2, 120.0),
        Watch("003", "Swatch", 50.0),
        Watch("004", "Casio", 30.0),
    )
}