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
  var carRepository: CarRepository = _

  @RequestMapping(path = Array("/{carId}"))
  def getUser(@PathVariable("carId") carId: String): Car = {
    carRepository.findOne(carId)
  }

  @RequestMapping(path = Array("/"))
  def getUsersByPage(@RequestParam("page") page: Int = 0): Page[Car] = {
    carRepository.findAll(new PageRequest(page, 20))
  }

  @RequestMapping(path = Array("/"), method = Array(RequestMethod.POST))
  def saveUser(@RequestBody user: Car): Car = {
    carRepository.save(user)
  }
}
