import scala.collection._
import scala.collection.mutable.ArrayBuffer

case class BinTree[T](value: T, left: Option[BinTree[T]], right: Option[BinTree[T]])

case class CoordTree[T](value: T, dist: Int, depth: Int)

object MyTree {
  def topView[T <: Any](root: BinTree[T]): Seq[T] = {
    val map = mutable.Map.empty[Int, CoordTree[T]]
    distView[T](root, map, 0, 0)
    var array = new ArrayBuffer[T]
    map.keySet.toList.sorted foreach {
      case key: Int => array += map.get(key).get.value
    }
    array.seq
  }

  private def distView[T](root: BinTree[T], map: mutable.Map[Int, CoordTree[T]], dist: Int, depth: Int): Unit = {
    if (map.get(dist).isEmpty || depth < map.get(dist).get.depth) {
      map += (dist -> new CoordTree(root.value, dist, depth))
    }

    root.right match {
      case Some(right) => distView(right, map, dist + 1, depth + 1)
      case None =>
    }
    root.left match {
      case Some(left) => distView(left, map, dist - 1, depth + 1)
      case None =>
    }
  }

  def main(args: Array[String]) {
    val root = BinTree(3,
      Some(BinTree(5,
        None,
        Some(BinTree(1,
          Some(BinTree(4,
            None,
            Some(BinTree(10,
              None,
              Some(BinTree(9, None, None)))))),
          None)))),
      Some(BinTree(2,
        Some(BinTree(6,
          Some(BinTree(7,
            Some(BinTree(8, None, None)),
            None)),
          None)),
        None)))

    val map = mutable.Map.empty[Int, CoordTree[Int]]
    distView(root, map, 0, 0)
    map.keySet.toList.sorted foreach {
      case key => println(key + " = " + map.get(key).get.value)
    }
  }
}