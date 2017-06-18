import java.text.DecimalFormat

/**
  * standard Bill to calculate total bill
  */


object standardBill {
  def apply(purcachedItems: Array[String]) = new standardBill(
    purcachedItems.flatMap(item => cafeXMenu.MenuItems.filter(_.name == item) ).toList
  )
}

class standardBill(val purchasedItems: List[menuItem]) {

  val purchasedDrinksOnly : Boolean = purchasedItems.map(_.isDrink).forall(_ == true)

  val purchasedHotFood : Boolean = purchasedItems.filter(_.isDrink == false).exists(_.isHot == true)

  def calculatePurchasedItemsCost : BigDecimal = purchasedItems.map(_.price).sum


  def serviceChargePercentage : Double = {
    if (purchasedDrinksOnly.equals(true)) 0
    else if (purchasedHotFood.equals(true)) 20
    else 10
  }

  def calculateBillWithServiceCharge : Double = {
    val purchasedItemsCost = calculatePurchasedItemsCost
    val serviceChargeInPercentage = serviceChargePercentage
    val serviceChargeCost = calculateServiceChargeCost(purchasedItemsCost, serviceChargeInPercentage)
    val df = new DecimalFormat("#.##")
    df.format(purchasedItemsCost + serviceChargeCost).toDouble
  }

  private def calculateServiceChargeCost(itemsPrice: BigDecimal, serviceChargePercentage: Double) : BigDecimal = {
    val serviceCharge = itemsPrice * (serviceChargePercentage/100)
    if (serviceCharge > 20) 20 else serviceCharge
  }
}
