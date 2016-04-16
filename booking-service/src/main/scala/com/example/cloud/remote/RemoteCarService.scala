package com.example.cloud.remote

import java.util.{ArrayList => JArrayList, List => JList}

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}

@FeignClient(name = "car-service")
trait RemoteCarService {
  @RequestMapping(
    method = Array(RequestMethod.GET),
    value = Array("/car/"),
    consumes = Array(MediaType.APPLICATION_JSON_UTF8_VALUE))
  def getAllCars(): List[Car]


}

case class Car(id: String,
               model: String,
               year: Int,
               price: Int)