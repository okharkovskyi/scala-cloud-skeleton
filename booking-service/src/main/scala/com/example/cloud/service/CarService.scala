package com.example.cloud.service

import com.example.cloud.Logging
import com.example.cloud.model.BookedCar
import com.example.cloud.remote.{Car, RemoteCarService}
import com.example.cloud.repository.BookedCarRepository
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.collection.JavaConversions._

@Service
class CarService extends Logging {


  @Autowired
  var bookedCarRepository: BookedCarRepository = _
  @Autowired
  var remoteCarService: RemoteCarService = _

  @HystrixCommand(fallbackMethod = "defaultCarsResponse")
  def getAllCars(): List[Car] = {
    remoteCarService.getAllCars().filterNot(car => getBookedCarIds.contains(car.id))

  }

  def getBookedCarIds: Seq[String] = {
    bookedCarRepository.findAll().map(bc => bc.id)
  }

  def bookCar(bookedCar: BookedCar): BookedCar = {
    bookedCarRepository.save(bookedCar)
  }

  private def defaultCarsResponse: List[Car] = {
    log.error("Failed to call remote car-service! Falling back to defaultCarsResponse")
    List()
  }

}
