import scala.collection._
import scala.collection.mutable.ArrayBuffer

case class BinTree[T](value: T, left: Option[BinTree[T]], right: Option[BinTree[T]])

object MyTree {
  def topView[T <: Any](root: BinTree[T]): Seq[T] = {
    val map = mutable.Map.empty[Int, T]
    distView[T](root, map, 0)
    var array = new ArrayBuffer[T]
    map.keySet.toList.sorted foreach {
      case key: Int => array += map.get(key).get
    }
    array.seq
  }

  private def distView[T](root: BinTree[T], map: mutable.Map[Int, T], dist: Int): Unit = {
    if (map.get(dist).isEmpty) {
      map += (dist -> root.value)
    }
    root.right match {
      case Some(right) => distView(right, map, dist + 1)
      case None =>
    }
    root.left match {
      case Some(left) => distView(left, map, dist - 1)
      case None =>
    }
  }

  def main(args: Array[String]) {
    val root = BinTree(3,
      Some(BinTree(5,
        Some(BinTree(1,
          None,
          Some(BinTree(9, None, None)))),
        Some(BinTree(4, None, None)))),
      Some(BinTree(2,
        Some(BinTree(6, None, None)),
        Some(BinTree(7,
          Some(BinTree(8, None, None)),
          None)))))

    val map = mutable.Map.empty[Int, Int]
    distView(root, map, 0)
    map.toList.sorted foreach {
      case (key, value) => println(key + " = " + value)
    }
  }
}