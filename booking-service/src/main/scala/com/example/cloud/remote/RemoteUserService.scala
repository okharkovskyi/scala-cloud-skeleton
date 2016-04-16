package com.example.cloud.remote

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.{PathVariable, RequestMapping, RequestMethod}

@FeignClient(name = "user-service")
trait RemoteUserService {
  @RequestMapping(
    method = Array(RequestMethod.GET),
    value = Array("/user/{userId}"),
    consumes = Array(MediaType.APPLICATION_JSON_UTF8_VALUE))
  def getUserById(@PathVariable("userId") userId: String): User
}

case class User(id: String,
                username: String,
                email: String)
