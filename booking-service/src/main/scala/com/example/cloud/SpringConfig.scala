package com.example.cloud

import com.example.cloud.jackson.JacksonConfig
import com.example.cloud.logging.Logging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard
import org.springframework.context.annotation.{ComponentScan, Import}

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
@ComponentScan
@Import(Array(classOf[JacksonConfig]))
class SpringConfig extends Logging {}