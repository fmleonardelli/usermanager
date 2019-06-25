package controllers

import scalaz.{Failure, Success, Validation}
import scalaz.syntax.all._

object ValidationTest extends App {

  val ab : List[Validator] = List(new ZeroValidator(), new TenValidator())

  println(ab.map(_.validate(0)))
}

trait Validator {

  def validate(value : Int) : Validation[String, Boolean]
}

case class ZeroValidator() extends Validator {

  override def validate(value: Int): Validation[String, Boolean] = {

    value > 0 match {
      case true => Success(true)
      case false => Failure("Valor no mayor a 0")
    }
  }
}

case class TenValidator() extends Validator {

  override def validate(value: Int): Validation[String, Boolean] = {

    value > 10 match {
      case true => Success(true)
      case false => Failure("Valor no mayor a 10")
    }
  }
}
