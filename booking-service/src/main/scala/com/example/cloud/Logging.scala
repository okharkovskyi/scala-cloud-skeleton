package com.example.cloud

import org.slf4j.LoggerFactory

trait Logging {
  def log = LoggerFactory.getLogger(this.getClass.getName.replace("$", ""))
}
