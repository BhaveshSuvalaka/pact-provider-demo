package com.pactprovider.demo

import au.com.dius.pact.provider.PactVerifyProvider
import au.com.dius.pact.provider.junit5.MessageTestTarget
import au.com.dius.pact.provider.junit5.PactVerificationContext
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider
import au.com.dius.pact.provider.junitsupport.Provider
import au.com.dius.pact.provider.junitsupport.loader.PactFolder
import au.com.dius.pact.provider.junitsupport.target.TestTarget
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestTemplate
import org.junit.jupiter.api.extension.ExtendWith
import java.text.SimpleDateFormat

@Provider("order-service")
//@PactBroker(url = "brokerUrl")
@PactFolder("src/test/resources")
class PactProvider {

    @TestTarget
    private val target = MessageTestTarget()

    @BeforeEach
    fun before(context: PactVerificationContext) {
        context.target = target
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider::class)
    fun pactVerificationTestTemplate(context: PactVerificationContext) {
        context.verifyInteraction()
    }

    @PactVerifyProvider("OrderReceivedEvent")
    fun verifyOrderReceivedEvent(): String? {
        val df = SimpleDateFormat("yyyy-MM-dd")
        val objectMapper = ObjectMapper().findAndRegisterModules()
        objectMapper.dateFormat = df
        return objectMapper.writeValueAsString(anOrderReceivedEvent)
    }
}