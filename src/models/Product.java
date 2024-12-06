package models;

public class Product {
  // attributes
  private int productId;
  private String productBrand;
  private String productName;

  public enum Departments {
    GARDEN,
    FLOORING,
    HARDWARE,
    LUMBER,
    PLUMBING,
    ELECTRICAL
  }

  Departments department;
  private double price;

  // constructor
  public Product(int id, String brand, String name, Departments department, double price) {
    this.productId = id;
    this.productBrand = brand;
    this.productName = name;
    this.department = department;
    this.price = price;
  } // Product

  // methods
  public int getProductId() {
    return productId;
  }

  public String getName() {
    return productName;
  }

  public String getProductBrand() {
    return productBrand;
  }

  public Departments getDepartment() {
    return department;
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

  public void setProductBrand(String productBrand) {
    this.productBrand = productBrand;
  }

  public void setDepartment(Departments department) {
    this.department = department;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void printDetails() {
    System.out.println(
        "Product ID: "
            + this.productId
            + "\nName: "
            + this.productName
            + "\n Description: "
            + this.productBrand
            + "\nPrice: $"
            + this.price);
  }
}
