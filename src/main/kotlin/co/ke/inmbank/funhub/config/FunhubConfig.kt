package co.ke.inmbank.funhub.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "inmbank.funhub")
data class FunhubConfig(
    val imageFolder: String,
    val host: String,
    val sender: String,
)
