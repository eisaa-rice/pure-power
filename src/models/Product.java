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

  @Override
  public String toString() {
    return "Product{"
        + "id="
        + this.productId
        + ", name='"
        + this.productName
        + '\''
        + ", price="
        + this.price
        + '}';
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
}
