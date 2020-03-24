import breeze.plot._
object Binary extends App {
  def toBinary(x: Int, bits: Int): String = {
    if (x ==0) "0" * bits
    else if (x == 1) "0" * (bits-1) + "1"
    else toBinary(x/2, bits-1) + (x%2).toString
  }

  def weight(b:String): Int = b.count(_ == '1')
  val bin = toBinary(1234567890, 32)
  print(bin)

  val xs = Range(0, 1025)
  val ys = xs.map(x=> weight(toBinary(x, 8)))
  print(xs)

  val fig = Figure()
  val plt = fig.subplot(0)
  plt += plot(xs, ys)
  fig.refresh()
}
