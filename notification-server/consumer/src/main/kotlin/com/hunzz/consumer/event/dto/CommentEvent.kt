package com.hunzz.consumer.event.dto

import java.time.LocalDateTime
import java.util.*

data class CommentEvent(
    val postId: Long,
    val commentId: Long,
    val userId: UUID,
    val createdAt: LocalDateTime
)