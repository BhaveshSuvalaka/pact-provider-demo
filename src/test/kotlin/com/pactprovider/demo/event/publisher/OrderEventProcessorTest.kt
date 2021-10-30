package com.pactprovider.demo.event.publisher

import com.pactprovider.demo.anOrderReceivedEvent
import com.pactprovider.demo.event.publisher.model.OrderReceivedEvent
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.kotlin.spy
import org.mockito.kotlin.verify
import java.time.LocalDateTime
import java.util.*

class OrderEventProcessorTest {
    private val domainEvents = Mockito.mock(IDomainEvents::class.java)
    private val eventProcessor = OrderEventProcessor(listOf(domainEvents))

    @Test
    fun `it should publish Order Received event`(){
        val orderReceivedEvent = anOrderReceivedEvent
        eventProcessor.publish(orderReceivedEvent)
        verify(domainEvents).publishOrderEvent(orderReceivedEvent)
    }
}