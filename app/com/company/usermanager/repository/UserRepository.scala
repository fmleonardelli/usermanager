package com.company.usermanager.repository

import java.util

import com.company.usermanager.model.User
import javax.inject.Inject
import org.mongojack.JacksonMongoCollection

import scala.util.Try
import scala.collection.JavaConverters._

class UserRepository @Inject()(collection: JacksonMongoCollection[User]){

  def insertUser(user: User): Either[Throwable, Unit] = {

    Try(collection.insert(user)).toEither
  }

  def findAll(): Either[Throwable, List[User]] = {

    val users: List[User] = collection.find().into(new util.ArrayList[User]()).asScala.toList
    Try(users).toEither

  }
}
