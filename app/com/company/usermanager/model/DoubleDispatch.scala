package com.company.usermanager

package object DoubleDispatch {


  trait validator {

    def validate(value : String)
  }

  case class StringValidator() extends validator {

    override def validate(value: String): Unit = {

    }
  }

  trait question {

    def validate() : Unit
  }

  case class textQuestion(value : String, validator : validator) extends question {

    override def validate(): Unit = {
        validator.validate(value)
    }
  }



  trait Trabajador {

    def trabajar(material : Material) : Unit = ???

    def trabajar(cuero : Cuero) : Unit
  }

  case class Artesano() extends Trabajador {

    override def trabajar(cuero: Cuero): Unit = {
      println("Trabajador de Cuero")
    }
  }

  trait Material {

    def decimeQuienSos(trabajador: Trabajador): Unit = {
      trabajador.trabajar(this)
    }
  }

  case class Cuero() extends Material {

    override def decimeQuienSos(trabajador: Trabajador): Unit = {
      trabajador.trabajar(this)
    }
  }


}
