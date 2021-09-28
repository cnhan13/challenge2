package com.bcgdv.challenge2.repositoryTests

import com.bcgdv.challenge2.models.Watch
import com.bcgdv.challenge2.repositories.WatchRepository
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc

@WebMvcTest
class WatchRepositoryTest(@Autowired val mockMvc: MockMvc) {
//    @MockkBean
//    private lateinit var watchRepository: WatchRepository
//
//    @Test
//    fun `Repo watches`() {
//        watchRepository = WatchRepository()
//        val rolex = Watch("001", "Rolex", 100.0, 3, 200.0)
//        val michaelKors = Watch("002", "Michael Kors", 80.0, 2, 120.0)
//        val swatch = Watch("003", "Swatch", 50.0)
//        val casio = Watch("004", "Casio", 30.0)
//        every { watchRepository.getWatches() } returns listOf(rolex, michaelKors, swatch, casio)
//    }
}