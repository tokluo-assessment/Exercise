import org.scalatest.FunSuite

/**
  * Created by lout on 18/06/2017.
  */
class standardBillTest extends FunSuite {

  test("Create list of purchased items from an array of string") {

    val myStandardBill = standardBill(Array("Cola", "Coffee"))

    val expectedPurchasedItem = List( menuItem("Cola", 0.50, true, false),
                                      menuItem("Coffee", 1.00, true, true))

    assert(myStandardBill.purchasedItems == expectedPurchasedItem)
  }

  test("Correctly Sum total cost of purchased items") {
    val standBill = standardBill(Array("Cola", "Coffee"))
    assert(standBill.calculatePurchasedItemsCost == 1.5)
  }

  test("Return true if purchased items only contains drinks") {
    val myStandardBill = standardBill(Array("Cola", "Coffee"))
    assert(myStandardBill.purchasedDrinksOnly.equals(true))
  }

  test("Return false if purchased items contains food") {
    val myStandardBill = standardBill(Array("Cola", "Coffee", "Cheese Sandwich"))
    assert(myStandardBill.purchasedDrinksOnly.equals(false))
  }

  test("Return true if purchased items contains hot food") {
    val myStandardBill = standardBill(Array("Cola", "Coffee", "Cheese Sandwich"))
    assert(myStandardBill.purchasedHotFood.equals(false))
  }

  test("Return false if purchased items do not contains hot food") {
    val myStandardBill = standardBill(Array("Cola", "Coffee", "Steak Sandwich"))
    assert(myStandardBill.purchasedHotFood.equals(true))
  }

  test("Return correct service charge") {
    val onlyDrinks = standardBill(Array("Cola", "Coffee"))
    val drinkwithColdFood = standardBill(Array("Cola", "Cheese Sandwich"))
    val drinkwithHotFood = standardBill(Array("Cola",  "Steak Sandwich"))

    assert(onlyDrinks.serviceChargePercentage == 0)
    assert(drinkwithColdFood.serviceChargePercentage == 10)
    assert(drinkwithHotFood.serviceChargePercentage == 20)
  }

  test("Calculate total bill with service charge Price") {
    val onlyDrinks = standardBill(Array("Cola", "Coffee"))
    val drinkwithColdFood = standardBill(Array("Cola", "Cheese Sandwich"))
    val drinkwithHotFood = standardBill(Array("Cola", "Coffee", "Steak Sandwich", "Steak Sandwich"))

    assert(onlyDrinks.calcluateBillWithServiceCharge == 1.5)
    assert(drinkwithColdFood.calcluateBillWithServiceCharge == 3.3)
    assert(drinkwithHotFood.calcluateBillWithServiceCharge == 9.6)
  }
}
