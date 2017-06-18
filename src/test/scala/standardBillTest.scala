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

  test("Sum the total cost of purchased items") {
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

  test("Return correct service charge in percentage") {
    val onlyDrinks = standardBill(Array("Cola", "Coffee"))
    val drinkWithColdFood = standardBill(Array("Cola", "Cheese Sandwich"))
    val drinkWithHotFood = standardBill(Array("Cola",  "Steak Sandwich"))

    assert(onlyDrinks.serviceChargePercentage == 0)
    assert(drinkWithColdFood.serviceChargePercentage == 10)
    assert(drinkWithHotFood.serviceChargePercentage == 20)
  }

  test("Calculate total bill cost with correct service charge") {
    val onlyDrinks = standardBill(Array("Cola", "Coffee"))
    val drinkWithColdFood = standardBill(Array("Cola", "Cheese Sandwich"))
    val drinkWithHotFood = standardBill(Array("Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich"))
    val max20ServiceCharge = standardBill(Array("X"))

    assert(onlyDrinks.calculateBillWithServiceCharge == 1.5)
    assert(drinkWithColdFood.calculateBillWithServiceCharge == 2.75)
    assert(drinkWithHotFood.calculateBillWithServiceCharge == 9.6)
    assert(max20ServiceCharge.calculateBillWithServiceCharge == 220)
  }
}
