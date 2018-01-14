package edu.knoldus

import org.apache.log4j.Logger

object Activity extends App {
  def main(args: String): Unit = {
    val log = Logger.getLogger(this.getClass)
    val list = List()
    val inputValue1 = 27
    val inputValue2 = 38
    val inputValue3 = 17
    val process = new Application
    val list1: List[Int] = process.collatzEquation(inputValue1, list)
    log.info("New List1\n" + list1)
    val list2: List[Int] = process.collatzEquation(inputValue1, list1)
    log.info("Updating List2 using List1\n" + list2)
    val list3: List[Int] = process.collatzEquation(inputValue1, list2)
    log.info("Updated List3 using List2 \n" + list1)
  }
}

class Application {
  def collatzEquation(inputValue: Int, list: List[Int]): List[Int] = {
    list match {
      case Nil => list.::(inputValue)
      case head :: tail => computationPerformed(list)
    }
  }

  def computationPerformed(list: List[Int]): List[Int] = {

    val element = list(0)
    if (element != 1) {
      if (element % 2 == 0) {
        val newElement = element / 2
        list.::(newElement)
      }
      else {
        val newElement = 3 * element + 1
        list.::(newElement)
      }
    }
    List()
  }
}





