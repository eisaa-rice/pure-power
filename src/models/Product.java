package models;

public class Product {
  // attributes
  private int productId;
  private String productName;
  private double price;

  // constructor
  public Product(int id, String name, double price) {
    this.productId = id;
    this.productName = name;
    this.price = price;
  }

  // methods
  public int getId() {
    return productId;
  }

  public String getName() {
    return productName;
  }

  public double getPrice() {
    return price;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void printDetails() {
    System.out.println(
        "Product ID: "
            + this.productId
            + "\nname: "
            + this.productName
            + "\nprice: $"
            + this.price);
  }
}
