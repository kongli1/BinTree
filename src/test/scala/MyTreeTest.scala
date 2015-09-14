import org.scalatest.FunSuite

class MyTreeTest extends FunSuite {

  test("testTopView") {
    val data = BinTree(3,
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
    val data2 = BinTree(3, None, None)
    assert(MyTree.topView(data) == Seq(1, 5, 3, 2, 7))
    assert(MyTree.topView(data2) == Seq(3))
  }

}