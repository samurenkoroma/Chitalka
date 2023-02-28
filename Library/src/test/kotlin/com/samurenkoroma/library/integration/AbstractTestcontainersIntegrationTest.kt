package com.samurenkoroma.library.integration

import com.samurenkoroma.library.integration.annotation.IT
import org.junit.jupiter.api.BeforeAll
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.context.jdbc.Sql
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.utility.DockerImageName

@IT
@Sql("classpath:sql/data.sql")
abstract class AbstractTestcontainersIntegrationTest {
//    @Sql("classpath:sql/data.sql")
    companion object {

        private val postgres: PostgreSQLContainer<*> = PostgreSQLContainer(DockerImageName.parse("postgres:14.6-alpine"))
//            .apply {
//                this.withDatabaseName("tiun_db").withUsername("test").withPassword("test")
//            }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", postgres::getJdbcUrl)
        }

        @JvmStatic
        @BeforeAll
        internal fun setUp() {
            postgres.start()
        }
    }
}