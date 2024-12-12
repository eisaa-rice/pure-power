package models;

public class CartItem extends Product {
  // attributes
  private int quantity;
  private double subtotal;

  // constructor
  public CartItem(
      int id,
      Product.Brands brand,
      String name,
      Product.Departments department,
      double price,
      int quantity) {
    super(id, brand, name, department, price);

    this.quantity = quantity;
    this.subtotal = price * quantity;
  } // Cart

  // methods

  public int getQuantity() {
    return quantity;
  }

  public double getSubtotal() {
    return subtotal;
  }

  public void setQuantityAndSubTotal(int quantity) {
    this.quantity = quantity;
    this.subtotal = this.getPrice() * quantity;
  }

  public void printItemDetails() {
    System.out.println(
        "["
            + this.getProductId()
            + "] "
            + this.getProductBrand()
            + " "
            + this.getName()
            + " QUANTITY: "
            + this.quantity
            + " SUBTOTAL: $"
            + this.subtotal);
  } // printItemDetails
}
