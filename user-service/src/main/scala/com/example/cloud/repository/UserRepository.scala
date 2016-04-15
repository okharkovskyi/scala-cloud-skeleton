package com.example.cloud.repository

import com.example.cloud.model.User
import org.springframework.data.mongodb.repository.MongoRepository

trait UserRepository extends MongoRepository[User, String] {

}
