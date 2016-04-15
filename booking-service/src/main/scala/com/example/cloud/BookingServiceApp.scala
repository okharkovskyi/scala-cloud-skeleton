package com.example.cloud

import org.springframework.boot.SpringApplication

object BookingServiceApp extends App with Logging {
  log.info(s"Starting ${getClass.getSimpleName}...")
  SpringApplication.run(classOf[SpringConfig], "")
}
