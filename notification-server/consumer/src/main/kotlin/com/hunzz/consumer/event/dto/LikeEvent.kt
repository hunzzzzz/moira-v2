package com.hunzz.consumer.event.dto

import java.time.LocalDateTime
import java.util.*

data class LikeEvent(
    val postId: Long,
    val userId: UUID,
    val createdAt: LocalDateTime
)