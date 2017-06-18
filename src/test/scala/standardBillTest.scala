import org.scalatest.FunSuite

/**
  * Created by lout on 18/06/2017.
  */
class standardBillTest extends FunSuite {

  test("Create list of purchased items from an array of string") {

    val myStandardBill = new standardBill(Array("Cola", "Coffee"))

    val expectedPurchasedItem = List( menuItem("Cola", 0.50, true, false),
                                      menuItem("Coffee", 1.00, true, true))

    assert(myStandardBill.purchasedItems == expectedPurchasedItem)
  }
}
