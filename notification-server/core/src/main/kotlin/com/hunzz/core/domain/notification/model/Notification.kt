package com.hunzz.core.domain.notification.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

enum class NotificationType {
    LIKE, COMMENT, FOLLOW
}

@Document(collection = "notifications")
class Notification(
    @Id
    val id: String? = null,

    val userId: String,

    val type: NotificationType,

    val createdAt: LocalDateTime = LocalDateTime.now(),

    val deletedAt: LocalDateTime = LocalDateTime.now().plusDays(90)
)