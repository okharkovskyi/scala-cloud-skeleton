package com.example.cloud.jackson

import com.fasterxml.jackson.databind.{Module, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter


@Configuration
class JacksonConfig {
  @Bean
  def mappingJackson2HttpMessageConverter(objectMapper: ObjectMapper, defaultScalaModule: DefaultScalaModule) = {
    objectMapper.registerModule(defaultScalaModule)
    new MappingJackson2HttpMessageConverter(objectMapper)
  }

  @Bean
  def defaultScalaModule: Module = new DefaultScalaModule
}
