package com.example.cloud

import com.example.cloud.jackson.JacksonConfig
import com.example.cloud.logging.Logging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.{ComponentScan, Import}

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan
@Import(Array(classOf[JacksonConfig]))
class SpringConfig extends Logging {}