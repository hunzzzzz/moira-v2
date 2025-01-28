package com.hunzz.consumer.event.consumer

import com.hunzz.consumer.event.dto.FollowEvent
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component
class FollowEventConsumer {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @Bean
    fun follow(): Consumer<FollowEvent> {
        return Consumer { event -> logger.info(event.toString()) }
    }
}