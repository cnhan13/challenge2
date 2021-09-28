package com.bcgdv.challenge2.controllers

import com.bcgdv.challenge2.models.Watch
import com.bcgdv.challenge2.repositories.WatchRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
public class WatchController {

    @GetMapping("/watches")
    fun watches(): List<Watch> {
        val watchRepo = WatchRepository()
        return watchRepo.getWatches()
    }
}