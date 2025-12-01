package co.ke.inmbank.funhub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling
import java.util.TimeZone

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableScheduling
@EnableAsync
class FunhubApplication

fun main(args: Array<String>) {
    TimeZone.setDefault(TimeZone.getTimeZone("EAT"))
    runApplication<FunhubApplication>(*args)
}
