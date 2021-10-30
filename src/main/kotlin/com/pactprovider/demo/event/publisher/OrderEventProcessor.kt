package com.pactprovider.demo.event.publisher

import com.pactprovider.demo.event.publisher.model.OrderReceivedEvent

/**
 *  Any messaging interface can be bind here, this is out of scope for this
 *  example
 */
class OrderEventProcessor(private val domainEvents : List<IDomainEvents>) {
    fun publish(orderReceivedEvent: OrderReceivedEvent) {
        domainEvents.forEach { domainEvent ->
            domainEvent.publishOrderEvent(orderReceivedEvent)
        }
    }

}
