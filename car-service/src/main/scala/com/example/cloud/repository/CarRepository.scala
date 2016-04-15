package com.example.cloud.repository

import com.example.cloud.model.Car
import org.springframework.data.mongodb.repository.MongoRepository

trait CarRepository extends MongoRepository[Car, String] {

}
