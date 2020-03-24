package ds4300

import scala.collection.mutable

class Graph(redis: Redis) {
  var nodes = List[String]()

  def addNode(v: String) = {
    if (!(nodes contains v))
      nodes = nodes :+ v
  }

  def addEdge(u: String, v: String): Unit = {
    addNode(u)
    addNode(v)
    redis.set(u, v)
    redis.set(v,u)
  }

  def adjacent(v: String): List[String] = {
    redis.get(v)
  }

  def shortestPath(u: String, v: String) = {
    var queue = mutable.Queue[String]
    var seen = List[String]
  }

}
