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
    createProduct("Ryobi", "Leaf Blower", Product.Departments.GARDEN, 149.00);
    createProduct("Ryobi", "Grass Shear and Shrubber Trimmer", Product.Departments.GARDEN, 149.00);
    createProduct("DeWalt", "Pruner", Product.Departments.GARDEN, 89.00);
    createProduct("DeWalt", "Chainsaw", Product.Departments.GARDEN, 289.00);
    createProduct("Ryobi", "Hedge Trimmer", Product.Departments.GARDEN, 129.00);
    createProduct("Ryobi", "Push Snow Blower", Product.Departments.GARDEN, 459.00);

    createProduct("Milwaukee", "Compact Drill (Tool Only)", Product.Departments.HARDWARE, 79.99);
    createProduct("Milwaukee", "18-Volt Battery", Product.Departments.HARDWARE, 159.99);
    createProduct(
        "DeWalt", "Drill, Battery, Charger, and Soft Bag", Product.Departments.HARDWARE, 99.99);
    createProduct(
        "Craftsman", "Keyless Drill (Battery and Charger)", Product.Departments.HARDWARE, 79.99);

    createProduct("Ryobi", "Extended Flooring Saw", Product.Departments.FLOORING, 189.00);

    createProduct("Ryobi", "Circular Saw", Product.Departments.LUMBER, 69.59);

    createProduct("Ryobi", "", Product.Departments.ELECTRICAL, 4.47);

    createProduct("Ryobi", "Crimp Press Ring Tool", Product.Departments.PLUMBING, 229.00);
    createProduct("Craftsman", "Hybrid Drain Auger", Product.Departments.PLUMBING, 159.99);
    createProduct("Milwaukee", "Copper Tubing Cutter", Product.Departments.PLUMBING, 149.00);
  } // ProductServices

  // methods
  public void createProduct(String brand, String name, Product.Departments dept, double price) {
    this.products.put(this.currId, new Product(this.currId, brand, name, dept, price));

    this.currId++;
  } // createProduct
}
