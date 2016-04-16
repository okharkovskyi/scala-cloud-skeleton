package com.example.cloud.service

import com.example.cloud.Logging
import com.example.cloud.model.BookedCar
import com.example.cloud.remote.{Car, RemoteCarService, RemoteUserService}
import com.example.cloud.repository.BookedCarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.collection.JavaConversions._
import scala.util.Try

@Service
class CarService extends Logging {
  @Autowired
  var bookedCarRepository: BookedCarRepository = _
  @Autowired
  var remoteCarService: RemoteCarService = _
  @Autowired
  var remoteUserService: RemoteUserService = _

  def getAvailableCars(): Try[List[Car]] = {
    Try {
      remoteCarService.getAllCars().filterNot(car => getBookedCarIds.contains(car.id))
    }
  }

  def getBookedCarIds: Seq[String] = {
    bookedCarRepository.findAll().map(bc => bc.carId)
  }

  def bookCar(userId: String, carId: String): BookedCar = {
    val user = remoteUserService.getUserById(userId)
    val car = remoteCarService.getCarById(carId)
    log.info(s"User: ${user} booked car: ${car}")
    bookedCarRepository.save(BookedCar(user.id, car.id))
  }

  def returnCar(carId: String) = {
    bookedCarRepository.deleteByCarId(carId)
  }
}
