package com.hunzz.core.domain.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDatabaseFactory
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.convert.MongoConverter
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongoRepositories(
    basePackages = ["com.hunzz.core"],
    mongoTemplateRef = "notificationMongoTemplate"
)
class MongoTemplateConfig {
    @Bean(name = ["notificationMongoTemplate"])
    fun notificationMongoTemplate(
        mongoDatabaseFactory: MongoDatabaseFactory,
        mongoConverter: MongoConverter
    ): MongoTemplate {
        return MongoTemplate(mongoDatabaseFactory, mongoConverter)
    }
}