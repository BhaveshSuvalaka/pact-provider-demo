package com.pactprovider.demo.event.publisher

import com.pactprovider.demo.event.publisher.model.OrderReceivedEvent

interface IDomainEvents  {
    fun publishOrderEvent(orderReceivedEvent: OrderReceivedEvent)
}