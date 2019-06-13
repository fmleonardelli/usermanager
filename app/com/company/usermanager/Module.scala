package com.company.usermanager

import com.company.usermanager.model.User
import com.company.usermanager.util.UserManagerMongoCollection
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility
import com.fasterxml.jackson.annotation.{JsonInclude, PropertyAccessor}
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper, PropertyNamingStrategy}
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import com.google.inject.{AbstractModule, Provides}
import com.mongodb.MongoClient
import org.mongojack.JacksonMongoCollection
import play.api.{Configuration, Environment}

class Module(environment: Environment, configuration: Configuration) extends AbstractModule {

  val mongoClient: MongoClient = new MongoClient(s"${configuration.get[String]("repository.mongodb.host")}")

  @Provides
  def usersMongoJackCollection: JacksonMongoCollection[User] = {
    val collection = UserManagerMongoCollection[User](mongoClient, "usermanager", "users")
    collection
  }
}
