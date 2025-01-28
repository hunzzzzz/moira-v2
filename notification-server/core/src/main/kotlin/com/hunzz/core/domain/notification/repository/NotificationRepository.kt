package com.hunzz.core.domain.notification.repository

import com.hunzz.core.domain.notification.model.Notification
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface NotificationRepository : MongoRepository<Notification, Long>