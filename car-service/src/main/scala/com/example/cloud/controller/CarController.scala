package com.example.cloud.controller

import java.util.{List => JList}

import com.example.cloud.model.Car
import com.example.cloud.repository.CarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.{Page, PageRequest}
import org.springframework.web.bind.annotation._

@RequestMapping(path = Array("/car"))
@RestController
class CarController {
  @Autowired
  var userRepository: CarRepository = _

  @RequestMapping(path = Array("/{userId}"))
  def getUser(@PathVariable("userId") userId: String): Car = {
    userRepository.findOne(userId)
  }

  @RequestMapping(path = Array("/"))
  def getUsersByPage(@RequestParam("page") page: Int = 0): Page[Car] = {
    userRepository.findAll(new PageRequest(page, 20))
  }

  @RequestMapping(path = Array("/"), method = Array(RequestMethod.POST))
  def saveUser(@RequestBody user: Car): Car = {
    userRepository.save(user)
  }
}
