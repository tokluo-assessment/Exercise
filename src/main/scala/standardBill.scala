import java.text.DecimalFormat

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

  def calcluateBillWithServiceCharge : Double = {
    val itemsCost = calculatePurchasedItemsCost
    val serviceCharge = serviceChargePercentage
    val serviceChargePrice = CalculateServiceChargeCost(itemsCost, serviceCharge)
    val df = new DecimalFormat("#.##")
    df.format(itemsCost + serviceChargePrice).toDouble
  }

  private def CalculateServiceChargeCost(itemsPrice: BigDecimal, serviceChargePercentage: Double) : BigDecimal = {
    val serviceCharge = itemsPrice * (serviceChargePercentage/100)
    if (serviceCharge > 20) 20 else serviceCharge
  }
}
