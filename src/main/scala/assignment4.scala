import org.apache.log4j.Logger

object Activity {

  def main(args: Array[String]): Unit = {

    val process = new Application
    val log = Logger.getLogger(this.getClass)
    val operation: String = "ints"
    val firstNumber: Int = 2
    val secondNumber: Int = 4
    val sumOfOperation: Int = process.sum(operation, firstNumber, secondNumber, (firstNumber, secondNumber) => firstNumber + secondNumber)
    log.info(sumOfOperation)
    val firstElement: Int = 2
    val secondElement: Int = 5
    val thirdElement: Int = 3
    val list: List[Int] = List(firstElement, secondElement, thirdElement)
    val functionPerformed: String = "max"
    val operate: Int = process.operateList(list, functionPerformed, list => list.head)
    log.info("\n")
    log.info(operate)
  }
}


class Application {

  def sum(operation: String, firstNumber: Int, secondNumber: Int, f:(Int, Int) => Int): Int = {
      val numOfTimes = 0
      operation.toLowerCase match {
        case "ints" => f(firstNumber * (numOfTimes + 1), secondNumber * (numOfTimes + 1))
        case "squares" => f(firstNumber * (numOfTimes + 2), secondNumber *(numOfTimes + 2))
        case "cubes" => f(firstNumber * (numOfTimes + 3), secondNumber * (numOfTimes + 3))
        case _ => -1
      }
  }

  def operateList(list: List[Int], functionPerformed: String, g:(List[Int]) => Int): Int = {
    list match {
      case head :: head2 :: tail if((head >= head2) & (functionPerformed == "max")) => g(head :: tail)
      case head :: head2 :: tail if((head <= head2) & (functionPerformed == "max")) => g(head2 :: tail)
      case head :: Nil => head
    }
  }
}
