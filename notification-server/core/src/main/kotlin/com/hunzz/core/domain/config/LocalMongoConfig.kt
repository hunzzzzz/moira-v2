package com.hunzz.core.domain.config

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDatabaseFactory
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory
import org.testcontainers.containers.GenericContainer
import org.testcontainers.utility.DockerImageName

@Configuration
class LocalMongoConfig {
    private val logger = LoggerFactory.getLogger(this::class.java)

    companion object {
        private const val MONGODB_IMAGE_NAME = "mongo:5.0"
        private const val MONGODB_INNER_PORT = 27017
        private const val DATABASE_NAME = "notification"
        private val mongoDB = createMongoInstance()

        private fun createMongoInstance(): GenericContainer<*> {
            return GenericContainer(DockerImageName.parse(MONGODB_IMAGE_NAME))
                .withExposedPorts(MONGODB_INNER_PORT)
                .withReuse(true)
        }
    }

    @PostConstruct
    fun startMongo() {
        kotlin.runCatching { mongoDB.start() }
            .onSuccess {
                logger.info("[TestContainers] MongoDB 컨테이너 시작")
            }
            .onFailure {
                logger.error("[Error] MongoDB 컨테이너 시작 실패\n${it.message}")
            }
    }

    @PreDestroy
    fun stopMongo() {
        kotlin.runCatching { mongoDB.stop() }
            .onSuccess {
                logger.info("[TestContainers] MongoDB 컨테이너 종료")
            }
            .onFailure {
            logger.error("[Error] MongoDB 컨테이너 종료에 실패했습니다. \n${it.message}")
        }
    }

    @Bean
    fun notificationMongoFactory(): MongoDatabaseFactory {
        val host = mongoDB.host
        val port = mongoDB.getMappedPort(MONGODB_INNER_PORT)

        return SimpleMongoClientDatabaseFactory(
            "mongodb://$host:$port/${DATABASE_NAME}"
        )
    }
}