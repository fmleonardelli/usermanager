package com.company.usermanager.model

object Hints extends App {


  val question : Question = new TextQuestion("COMMENT", StringValidator.Equals("HOLA"))
  val answers : Answers = Map("COMMENT" -> TextAnswer("HOLA"))
  println(question.validate(answers))

  type Answers = Map[String, Answer]


  trait Question {

    def id : String

    def validate(answers: Answers): Either[Throwable, Boolean]
  }

  case class TextQuestion(id : String, validator: Validator) extends Question {

    override def validate(answers: Answers): Either[Throwable, Boolean] = {
      val answer : Answer = answers.get(id).get

      validator.validate(answer.asString().getOrElse(""))
    }
  }

  trait Answer {

    def asString() : Either[Throwable, String]
  }

  case class TextAnswer(value : String) extends Answer {

    override def asString(): Either[Throwable, String] = {
      Right(value)
    }
  }

  trait Validator {

    def validate(value : String) : Either[Throwable, Boolean] = Left(new RuntimeException("The validator for string does not apply"))
  }

  object StringValidator {

    case class Equals(enteredValue : String) extends Validator {

      override def validate(expectedValue: String): Either[Throwable, Boolean] = {
        expectedValue.contains(enteredValue) match {
          case true => Right(true)
          case _ => Left(new RuntimeException("The value entered does not match the expected"))
        }
      }
    }
  }



}
