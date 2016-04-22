package com.example.cloud.controller

import com.example.cloud.model.User
import com.example.cloud.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._
import scala.collection.JavaConversions._

@RequestMapping(path = Array("/user"))
@RestController
class UserController {
  @Autowired
  var userRepository: UserRepository = _

  @RequestMapping(path = Array("/{userId}"))
  def getUser(@PathVariable("userId") userId: String): User = {
    userRepository.findOne(userId)
  }

  @RequestMapping(path = Array("/"))
  def getUsersByPage(@RequestParam("page") page: Int = 0): Seq[User] = {
    userRepository.findAll()
  }

  @RequestMapping(path = Array("/"), method = Array(RequestMethod.POST))
  def saveUser(@RequestBody user: User): Unit = {
    userRepository.save(user)
  }
}
