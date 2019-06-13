package com.company.usermanager.util

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility
import com.fasterxml.jackson.annotation.{JsonInclude, PropertyAccessor}
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper, PropertyNamingStrategy}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection
import org.mongojack.JacksonMongoCollection
import org.mongojack.JacksonMongoCollection.JacksonMongoCollectionBuilder

import scala.reflect.{ClassTag, _}

object UserManagerMongoCollection {
  def apply[T: ClassTag](client: MongoClient, databaseName: String, collectionName: String): JacksonMongoCollection[T] = {

    val om = {
      val m = new ObjectMapper() with ScalaObjectMapper
      m.registerModule(new DefaultScalaModule)

      m.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
      m.configure(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES, true)
      m.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true)
      m.setSerializationInclusion(JsonInclude.Include.NON_ABSENT)

      m.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE)

      m.setVisibility(PropertyAccessor.ALL, Visibility.NONE)
      m.setVisibility(PropertyAccessor.FIELD, Visibility.ANY)
    }

    val mongoCollection: MongoCollection[T] = client.getDatabase(databaseName).getCollection(collectionName, classTag[T].runtimeClass.asInstanceOf[Class[T]])
    val builder: JacksonMongoCollectionBuilder[T] = JacksonMongoCollection.builder()
    val jacksonMongoCollection: JacksonMongoCollection[T] = {
      builder.withObjectMapper(om).build(mongoCollection, classTag[T].runtimeClass.asInstanceOf[Class[T]])
    }

    jacksonMongoCollection
  }
}


