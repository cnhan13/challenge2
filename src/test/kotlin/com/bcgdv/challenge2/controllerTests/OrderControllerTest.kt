package com.bcgdv.challenge2.controllerTests

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@WebMvcTest
class OrderControllerTest(@Autowired val mockMvc: MockMvc) {

    @Test
    fun `Checkout empty order`() {
        mockMvc.post("/checkout") {
            contentType = MediaType.APPLICATION_JSON
            content = "[]"
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            content { json("{price:0.0}") }
        }
    }

    @Test
    fun `Checkout order with no discount`() {
        mockMvc.post("/checkout") {
            contentType = MediaType.APPLICATION_JSON
            content = "[\"001\",\"002\",\"001\",\"004\",\"003\"]"
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            content { json("{price:360.0}") }
        }
    }

    @Test
    fun `Checkout order with 3 rolex discount`() {
        mockMvc.post("/checkout") {
            contentType = MediaType.APPLICATION_JSON
            content = "[\"001\",\"002\",\"001\",\"004\",\"003\",\"001\"]"
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            content { json("{price:360.0}") }
        }
    }

    @Test
    fun `Checkout order with 4 rolex discount`() {
        mockMvc.post("/checkout") {
            contentType = MediaType.APPLICATION_JSON
            content = "[\"001\",\"002\",\"001\",\"004\",\"003\",\"001\",\"001\"]"
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            content { json("{price:460.0}") }
        }
    }

    @Test
    fun `Checkout order with 5 rolex discount`() {
        mockMvc.post("/checkout") {
            contentType = MediaType.APPLICATION_JSON
            content = "[\"001\",\"002\",\"001\",\"004\",\"003\",\"001\",\"001\",\"001\"]"
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            content { json("{price:560.0}") }
        }
    }

    @Test
    fun `Checkout order with 5 rolex, 2 Michael Kors discount`() {
        mockMvc.post("/checkout") {
            contentType = MediaType.APPLICATION_JSON
            content = "[\"001\",\"002\",\"001\",\"004\",\"003\",\"001\",\"001\",\"001\",\"002\"]"
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            content { json("{price:600.0}") }
        }
    }
}