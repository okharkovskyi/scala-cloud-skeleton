package com.example.cloud.controller

import com.example.cloud.Logging
import com.example.cloud.model.Car
import com.example.cloud.repository.CarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

import scala.collection.JavaConversions._

@RequestMapping(path = Array("/car"))
@RestController
class CarController extends Logging {
  @Autowired
  var carRepository: CarRepository = _

  @RequestMapping(path = Array("/{carId}"))
  def getCar(@PathVariable("carId") carId: String): Car = {
    carRepository.findOne(carId)
  }

  @RequestMapping(path = Array("/"))
  def getAllCars(): Seq[Car] = {
    log.info("CarController.getAllCars")
    carRepository.findAll()
  }

  @RequestMapping(path = Array("/"), method = Array(RequestMethod.POST))
  def saveCar(@RequestBody user: Car): Car = {
    carRepository.save(user)
  }
}
