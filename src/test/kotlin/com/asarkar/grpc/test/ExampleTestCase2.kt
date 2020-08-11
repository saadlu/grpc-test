package com.asarkar.grpc.test

import io.grpc.inprocess.InProcessChannelBuilder
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import kotlin.random.Random

@ExtendWith(GrpcCleanupExtension::class)
class ExampleTestCase2 {
    private lateinit var resources: Resources
    private val setOfResources: MutableSet<Resources?> = mutableSetOf()
    private val set = Mockito.spy(setOfResources)

    @Test
    fun test1() {
        resources.register(randomChannel())
        assertThat(setOfResources.add(resources)).isTrue()
    }

    @Test
    fun test2() {
        resources.register(randomChannel())
        assertThat(setOfResources.add(resources)).isTrue()
    }

    @Test
    fun test3() {
        resources.register(randomChannel())
        assertThat(setOfResources.add(resources)).isTrue()
    }

    private fun randomChannel() = InProcessChannelBuilder
        .forName((1..4).map { ('a' + Random.nextInt(0, 26)) }.joinToString(""))
        .build()
}
