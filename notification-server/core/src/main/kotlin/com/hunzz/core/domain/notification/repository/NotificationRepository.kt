package com.hunzz.core.domain.notification.repository

import com.hunzz.core.domain.notification.model.Notification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NotificationRepository : JpaRepository<Notification, Long>