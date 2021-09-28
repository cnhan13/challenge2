package com.bcgdv.challenge2.controllerTests

import com.bcgdv.challenge2.models.Watch
import com.bcgdv.challenge2.repositories.WatchRepository
import com.ninjasquad.springmockk.MockkBean
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
@AutoConfigureRestDocs(outputDir = "target/snippets")
class WatchControllerTest(@Autowired val mockMvc: MockMvc) {
    @MockkBean
    private lateinit var watchRepository: WatchRepository

    @Test
    fun `get watches`() {
        watchRepository = WatchRepository()
        val rolex = Watch("001", "Rolex", 100.0, 3, 200.0)
        val michaelKors = Watch("002", "Michael Kors", 80.0, 2, 120.0)
        val swatch = Watch("003", "Swatch", 50.0)
        val casio = Watch("004", "Casio", 30.0)

        mockMvc.perform(get("/watches"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.[0].id").value(rolex.id))
            .andExpect(jsonPath("\$.[0].name").value(rolex.name))
            .andExpect(jsonPath("\$.[0].unitPrice").value(rolex.unitPrice))
            .andExpect(jsonPath("\$.[0].discountQuantity").value(rolex.discountQuantity))
            .andExpect(jsonPath("\$.[0].discountPrice").value(rolex.discountPrice))
            .andExpect(jsonPath("\$.[1].name").value(michaelKors.name))
            .andExpect(jsonPath("\$.[2].name").value(swatch.name))
            .andExpect(jsonPath("\$.[3].name").value(casio.name))
            .andDo(document("getWatches"))
    }
}