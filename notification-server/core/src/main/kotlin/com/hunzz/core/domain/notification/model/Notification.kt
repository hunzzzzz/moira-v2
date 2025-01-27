package com.hunzz.core.domain.notification.model

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

enum class NotificationType {
    LIKE, COMMENT, FOLLOW
}

@Entity
class Notification(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id", nullable = false, unique = true)
    val id: Long? = null,

    @Column(name = "user_id", nullable = false)
    val userId: UUID,

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    val type: NotificationType,

    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "deleted_at", nullable = true)
    val deletedAt: LocalDateTime = LocalDateTime.now().plusDays(90)
)