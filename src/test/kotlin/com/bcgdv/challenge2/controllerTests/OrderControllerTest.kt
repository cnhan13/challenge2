package com.bcgdv.challenge2.controllerTests

import com.google.gson.Gson
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
@AutoConfigureRestDocs(outputDir = "target/snippets")
class OrderControllerTest(@Autowired val mockMvc: MockMvc) {

    private val gson: Gson = Gson()

    private fun checkoutTest(document: String, itemIds: List<String>, expectPrice: Double) {
        mockMvc.perform(
            post("/checkout")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(itemIds))
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.price").value(expectPrice))
            .andDo(document(document))
    }

    @Test
    fun `Checkout empty order`() {
        checkoutTest(
            "checkoutEmptyOrder",
            listOf(), 0.0
        )
    }

    @Test
    fun `Checkout order with no discount`() {
        checkoutTest(
            "checkoutOrderNoDiscount",
            listOf("001", "002", "001", "004", "003"), 360.0
        )
    }

    @Test
    fun `Checkout order with 3 rolex discount`() {
        checkoutTest(
            "checkoutOrder3RolexDiscount",
            listOf("001", "002", "001", "004", "003", "001"), 360.0
        )
    }

    @Test
    fun `Checkout order with 4 rolex discount`() {
        checkoutTest(
            "checkoutOrder4RolexDiscount",
            listOf("001", "002", "001", "004", "003", "001", "001"), 460.0
        )
    }

    @Test
    fun `Checkout order with 5 rolex discount`() {
        checkoutTest(
            "checkoutOrder5RolexDiscount",
            listOf("001", "002", "001", "004", "003", "001", "001", "001"), 560.0
        )
    }

    @Test
    fun `Checkout order with 5 rolex, 2 Michael Kors discount`() {
        checkoutTest(
            "checkoutOrder5Rolex2MichaelKorsDiscount",
            listOf("001", "002", "001", "004", "003", "001", "001", "001", "002"), 600.0
        )
    }
}