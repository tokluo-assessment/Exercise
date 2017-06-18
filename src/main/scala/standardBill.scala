/**
  * standard Bill to calculate total bill
  */


object standardBill {
  def apply(purcachedItems: Array[String]) = new standardBill(cafeXMenu.MenuItems.filter( item => purcachedItems.contains(item.name)))
}

class standardBill(val purchasedItems: List[menuItem]) {

  def calculatePurchasedItemsCost : BigDecimal = 0.0

}
