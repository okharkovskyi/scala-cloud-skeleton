package com.example.cloud

import com.example.cloud.logging.Logging
import org.springframework.boot.SpringApplication

object UserServiceApp extends App with Logging {
  log.info(s"Starting ${getClass.getSimpleName}...")
  SpringApplication.run(classOf[SpringConfig], "")
}
