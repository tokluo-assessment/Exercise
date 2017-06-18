/**
  * standard Bill to calculate total bill
  */


object standardBill {
  def apply(purcachedItems: Array[String]) = new standardBill(cafeXMenu.MenuItems.filter( item => purcachedItems.contains(item.name)))
}

class standardBill(val purchasedItems: List[menuItem]) {

  def calculatePurchasedItemsCost : BigDecimal = purchasedItems.map(_.price).sum

  def purchasedDrinksOnly : Boolean = purchasedItems.map(_.isDrink).forall(_ == true)

  def purchasedHotFood : Boolean = purchasedItems.filter(_.isDrink == false).exists(_.isHot == true)

  def serviceChargePercentage : Double = {
    if (purchasedDrinksOnly.equals(true)) 0
    else if (purchasedHotFood.equals(true)) 20
    else 10
  }
}
