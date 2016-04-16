package com.example.cloud.controller

import com.example.cloud.model.BookedCar
import com.example.cloud.remote.Car
import com.example.cloud.repository.BookedCarRepository
import com.example.cloud.service.CarService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RequestMapping(path = Array("/booking"))
@RestController
class BookedCarController {
  @Autowired
  var bookedCarRepository: BookedCarRepository = _
  @Autowired
  var carService: CarService = _

  @RequestMapping(path = Array("/bookedCars"))
  def getBookedCarIds: Seq[String] = {
    carService.getBookedCarIds
  }

  @RequestMapping(path = Array("/availableCars"))
  def getAvailableCars(): Seq[Car] = {
    carService.getAvailableCars.getOrElse(Seq())
  }

  @RequestMapping(path = Array("/bookCar"), method = Array(RequestMethod.GET))
  def bookCar(@RequestParam("userId") userId: String, @RequestParam("carId") carId: String): BookedCar = {
    carService.bookCar(userId, carId)
  }

  @RequestMapping(path = Array("/returnCar"), method = Array(RequestMethod.GET))
  def returnCar(@RequestParam("carId") carId:String) = {
    carService.returnCar(carId)
  }
}
