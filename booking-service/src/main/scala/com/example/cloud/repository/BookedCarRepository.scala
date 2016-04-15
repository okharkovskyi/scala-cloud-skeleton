package com.example.cloud.repository

import com.example.cloud.model.BookedCar
import org.springframework.data.mongodb.repository.MongoRepository

trait BookedCarRepository extends MongoRepository[BookedCar, String] {

}
