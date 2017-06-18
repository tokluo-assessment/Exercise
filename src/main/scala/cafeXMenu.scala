/**
  * Create Cafe X Menu with a list of menuItems
  */

object cafeXMenu {

  val MenuItems = List(
    menuItem("Cola", 0.50, true, false),
    menuItem("Coffee", 1.00, true, true),
    menuItem("Cheese Sandwich", 2.00, false, false),
    menuItem("Steak Sandwich", 4.50, false, true),
    menuItem("X", 200, false, true)
  )
}
