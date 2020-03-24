package ds4300

object Partition extends App {
  def moved(records:Int, startN: Int, endN:Int): Double = {
    var rePart = 0
    for ( i <- 0 to records) {
      val initalPart =  i % startN
      val newPart =  i % endN
      if (initalPart != newPart) {
        rePart+=1
      }
    }
    return rePart.toDouble/records.toDouble
  }
  println(moved(1000000, 100,107))
}
