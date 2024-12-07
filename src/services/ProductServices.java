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
    createProduct(Product.Brands.MAKITA, "Leaf Blower", Product.Departments.GARDEN, 149.00);
    createProduct(
        Product.Brands.RYOBI,
        "Grass Shear and Shrubber Trimmer",
        Product.Departments.GARDEN,
        149.00);
    createProduct(Product.Brands.RYOBI, "Hedge Trimmer", Product.Departments.GARDEN, 129.00);
    createProduct(Product.Brands.RYOBI, "Push Snow Blower", Product.Departments.GARDEN, 459.00);
    createProduct(Product.Brands.DEWALT, "Pruner", Product.Departments.GARDEN, 89.00);
    createProduct(Product.Brands.DEWALT, "Chainsaw", Product.Departments.GARDEN, 289.00);

    createProduct(
        Product.Brands.MILWAUKEE, "Compact Drill (Tool Only)", Product.Departments.HARDWARE, 69.99);
    createProduct(
        Product.Brands.MILWAUKEE, "18-Volt Battery", Product.Departments.HARDWARE, 159.99);
    createProduct(
        Product.Brands.DEWALT,
        "Drill, Battery, Charger, and Soft Bag",
        Product.Departments.HARDWARE,
        99.99);
    createProduct(
        Product.Brands.CRAFTSMAN,
        "Keyless Drill (Battery and Charger)",
        Product.Departments.HARDWARE,
        129.99);

    createProduct(
        Product.Brands.RIDGID, "Extended Flooring Saw", Product.Departments.FLOORING, 189.00);
    createProduct(Product.Brands.RIDGID, "Reciprocating Saw", Product.Departments.FLOORING, 69.56);
    createProduct(
        Product.Brands.CRAFTSMAN,
        "Multipurpose Steam Cleaner",
        Product.Departments.FLOORING,
        159.00);

    createProduct(Product.Brands.MAKITA, "Circular Saw", Product.Departments.LUMBER, 69.59);

    createProduct(Product.Brands.RIDGID, "", Product.Departments.ELECTRICAL, 4.47);

    createProduct(
        Product.Brands.RYOBI, "Crimp Press Ring Tool", Product.Departments.PLUMBING, 229.00);
    createProduct(
        Product.Brands.CRAFTSMAN, "Hybrid Drain Auger", Product.Departments.PLUMBING, 159.99);
    createProduct(
        Product.Brands.MILWAUKEE, "Copper Tubing Cutter", Product.Departments.PLUMBING, 149.00);
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
