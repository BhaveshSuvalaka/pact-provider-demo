package com.pactprovider.demo

import com.pactprovider.demo.event.publisher.model.OrderReceivedEvent
import java.time.LocalDate
import java.util.UUID

val products = listOf<UUID>(UUID.randomUUID())
val anOrderReceivedEvent: OrderReceivedEvent = OrderReceivedEvent(UUID.randomUUID(), products,  250.00, "username", LocalDate.now())