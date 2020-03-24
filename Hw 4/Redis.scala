package ds4300

import scala.collection.mutable

class Redis(var keyValue: mutable.HashMap[String, List[String]]){

    def get(key: String): List[String] = {
      this.keyValue.get(key) match{
        case Some(list: List[String]) => return list
        case None => return Nil
      }
    }
    def set(key: String, value: String) ={
      this.keyValue.put(key,List(value))
    }

    def lpush(key: String, value: String): Int = {
      keyValue.get(key) match {
        case Some(list: List[String]) => {
          val updatedList = value +: list
          keyValue.update(key, updatedList)
          return updatedList size
        }
        case None => {
          this.set(key, String)
          return 1
        }
      }
    }
    def rpush(key: String, value: String): Int = {
      val cValue = keyValue.get(key)
      cValue match {
        case Some(list: List[String]) => {
          val updatedList = list :+ value
          keyValue.update(key, updatedList)
          return updatedList size
        }
        case None => {
          this.set(key, String)
          return 1
        }
      }
    }
    def lpop(key: String): String = {
      val cValue = keyValue.get(key) 
      cValue match {
        case Some(list: List[String]) => {
          keyValue.update(key,list.drop(1))
          return list.head
        }
        case None => throw new Exception("key value not found")
      }
    }
  
    def rpop(key: String): String = {
      keyValue.get(key) match {
        case Some(list: List[String]) => {
          keyValue.update(key,list.dropRight(1))
          return list.last
        }
        case None => throw new Exception("key value not found")
      }
    }

    def lrange(key: String, start: Int, stop: Int) {
      val range = keyValue.get(key)
      if(start > stop || stop > range.size) {
        throw new Exception("Start and Stop Index are unusable")
      }
      else {
        return range.slice(start,stop)
      }

    }
    def llen(key: String): Int ={
      return keyValue.get(key) size
    }
    def flushall(): Unit = {
      keyValue.clear()
    }
}
