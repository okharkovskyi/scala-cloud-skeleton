package com.example.cloud

import java.util.{List => JList}

import com.fasterxml.jackson.databind.{Module, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.context.annotation.{Bean, ComponentScan}
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@ComponentScan
class SpringConfig extends Logging {
  @Bean
  def mappingJackson2HttpMessageConverter(objectMapper: ObjectMapper, defaultScalaModule: DefaultScalaModule) = {
    objectMapper.registerModule(defaultScalaModule)
    new MappingJackson2HttpMessageConverter(objectMapper)
  }

  @Bean
  def defaultScalaModule: Module = new DefaultScalaModule
}