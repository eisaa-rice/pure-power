package services;

import java.util.HashMap;
import models.Product;

public class ProductServices {
  // attributes
  private int currId;
  private HashMap<Integer, Product> products = new HashMap<>();

  // constructor
  ProductServices() {
    this.currId = 101;

    // only cordless battery-powered tools for products
    createProduct(Product.Brands.RYOBI, "Leaf Blower", Product.Departments.GARDEN, 149.00);
    createProduct(
        Product.Brands.RIDGID,
        "Grass Shear and Shrubber Trimmer",
        Product.Departments.GARDEN,
        149.00);
    createProduct(Product.Brands.MAKITA, "Hedge Trimmer", Product.Departments.GARDEN, 129.00);
    createProduct(Product.Brands.CRAFTSMAN, "Push Snow Blower", Product.Departments.GARDEN, 459.00);
    createProduct(Product.Brands.DEWALT, "Pruner", Product.Departments.GARDEN, 89.00);
    createProduct(Product.Brands.MILWAUKEE, "Chainsaw", Product.Departments.GARDEN, 289.00);

    createProduct(Product.Brands.RYOBI, "Compact Drill", Product.Departments.HARDWARE, 69.99);
    createProduct(Product.Brands.RIDGID, "18-Volt Battery", Product.Departments.HARDWARE, 159.99);
    createProduct(
        Product.Brands.MAKITA,
        "Drill, Battery, Charger, and Soft Bag",
        Product.Departments.HARDWARE,
        99.99);
    createProduct(
        Product.Brands.CRAFTSMAN,
        "Dual-Bevel Sliding Guide Miter Saw",
        Product.Departments.HARDWARE,
        649.00);
    createProduct(
        Product.Brands.DEWALT,
        "Keyless Drill (Battery and Charger)",
        Product.Departments.HARDWARE,
        129.99);
    createProduct(Product.Brands.MILWAUKEE, "Brad Nailer", Product.Departments.HARDWARE, 249.00);

    createProduct(
        Product.Brands.RYOBI, "Extended Flooring Saw", Product.Departments.FLOORING, 189.00);
    createProduct(Product.Brands.RIDGID, "Reciprocating Saw", Product.Departments.FLOORING, 69.56);
    createProduct(
        Product.Brands.MAKITA, "Multipurpose Steam Cleaner", Product.Departments.FLOORING, 159.00);
    createProduct(Product.Brands.CRAFTSMAN, "Jamb Saw", Product.Departments.FLOORING, 246.25);
    createProduct(
        Product.Brands.DEWALT, "Pneumatic Floor Stapler", Product.Departments.FLOORING, 398.39);
    createProduct(
        Product.Brands.MILWAUKEE, "Gauge Finish Nailer", Product.Departments.FLOORING, 169.74);

    createProduct(
        Product.Brands.RYOBI, "Wet/Dry Dust Extractor/Vacuum", Product.Departments.LUMBER, 224.00);
    createProduct(
        Product.Brands.RIDGID, "Drum Sander with Stand", Product.Departments.LUMBER, 1499.99);
    createProduct(Product.Brands.MAKITA, "Circular Saw", Product.Departments.LUMBER, 69.59);
    createProduct(Product.Brands.CRAFTSMAN, "Jig Saw", Product.Departments.LUMBER, 129.00);
    createProduct(Product.Brands.DEWALT, "Compact Bandsaw", Product.Departments.LUMBER, 329.00);
    createProduct(Product.Brands.MILWAUKEE, "Table Saw Kit", Product.Departments.LUMBER, 449.49);

    createProduct(Product.Brands.RYOBI, "Reciprocating Saw", Product.Departments.ELECTRICAL, 79.0);
    createProduct(Product.Brands.RIDGID, "Impact Driver", Product.Departments.ELECTRICAL, 99.99);
    createProduct(Product.Brands.MAKITA, "Skill Saw", Product.Departments.ELECTRICAL, 59.98);
    createProduct(
        Product.Brands.CRAFTSMAN, "Oscillating Saw", Product.Departments.ELECTRICAL, 99.90);
    createProduct(Product.Brands.DEWALT, "Hammer Drill", Product.Departments.ELECTRICAL, 199.47);
    createProduct(
        Product.Brands.MILWAUKEE, "Framing Drill", Product.Departments.ELECTRICAL, 189.79);

    createProduct(
        Product.Brands.RYOBI, "Crimp Press Ring Tool", Product.Departments.PLUMBING, 229.00);
    createProduct(Product.Brands.RIDGID, "No-hub Driver", Product.Departments.PLUMBING, 269.09);
    createProduct(
        Product.Brands.MAKITA, "Copper Tubing Cutter", Product.Departments.PLUMBING, 149.00);
    createProduct(
        Product.Brands.CRAFTSMAN, "Hybrid Drain Auger", Product.Departments.PLUMBING, 159.99);
    createProduct(
        Product.Brands.DEWALT, "Paddle Switch Angle Grinder", Product.Departments.PLUMBING, 96.99);
    createProduct(
        Product.Brands.MILWAUKEE,
        "Drain Cleaning Airsnake Gun Kit",
        Product.Departments.PLUMBING,
        399.0);
  } // ProductServices

  // methods
  public void listAllProducts() {
    for (Product product : this.products.values()) {
      System.out.println(
          "id: "
              + product.getProductId()
              + " brand: "
              + product.getProductBrand()
              + " name: "
              + product.getName()
              + " dept: "
              + product.getDepartment());
    } // for
  } // listAllProducts

  public void listDepartmentProducts(Product.Departments dept) {
    for (Product product : this.products.values()) {
      if (product.getDepartment() == dept) {

        System.out.println(
            "id: "
                + product.getProductId()
                + " brand: "
                + product.getProductBrand()
                + " name: "
                + product.getName()
                + " dept: "
                + product.getDepartment());
      }
    } // for
  } // listDepartmentProducts

  public void listBrandProducts(Product.Brands brand) {
    for (Product product : this.products.values()) {
      if (product.getProductBrand() == brand) {

        System.out.println(
            "id: "
                + product.getProductId()
                + " brand: "
                + product.getProductBrand()
                + " name: "
                + product.getName()
                + " dept: "
                + product.getDepartment());
      }
    } // for} // listBrandProducts
  }

  public void createProduct(
      Product.Brands brand, String name, Product.Departments dept, double price) {
    this.products.put(this.currId, new Product(this.currId, brand, name, dept, price));

    this.currId++;
  } // createProduct
}
