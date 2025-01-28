package com.hunzz.consumer.event.dto

import java.time.LocalDateTime
import java.util.*

data class FollowEvent(
    val userId: UUID,
    val targetId: UUID,
    val createdAt: LocalDateTime
)