import org.scalatest.FlatSpec

class GeneralTest extends FlatSpec {

  "Questions" should "Questions Validated" in {

    Map("NPS" -> new NumberAnswer(4), "ACQUIRED_PRODUCTS_PROBLEMS" -> new MultipleSelectionAnswer(List("Vuelo a Barcelona")))
  }


  case class QuestionComplete(questionId : String, answers : Map[String, Answer]) {

    def validate() : Either[Throwable, Boolean] = ???
  }

  trait Question {

    def questionType: String
  }

  case class TextQuestion() extends Question {

    override def questionType: String = "TEXT"
  }

  case class NumberQuestion() extends Question {

    override def questionType: String = "NUMBER"
  }

  trait Answer {

    def answerType: String
  }

  case class NumberAnswer(value: Int) extends Answer {

    override def answerType: String = "Number"
  }

  case class MultipleSelectionAnswer(value: List[String]) extends Answer {

    override def answerType: String = "MultipleSelection"
  }

  trait Condition {

    def conditionType : String
  }


}
