package com.example.cloud.controller

import java.util.{List => JList}

import com.example.cloud.model.BookedCar
import com.example.cloud.repository.BookedCarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.{Page, PageRequest}
import org.springframework.web.bind.annotation._

@RequestMapping(path = Array("/booking"))
@RestController
class BookedCarController {
  @Autowired
  var bookedCarRepository: BookedCarRepository = _

  @RequestMapping(path = Array("/"))
  def getUsersByPage(@RequestParam("page") page: Int = 0): Page[BookedCar] = {
    bookedCarRepository.findAll(new PageRequest(page, 20))
  }

  @RequestMapping(path = Array("/bookCar"), method = Array(RequestMethod.POST))
  def bookCar(@RequestBody bookedCar: BookedCar): BookedCar = {
    bookedCarRepository.save(bookedCar)
  }
}
