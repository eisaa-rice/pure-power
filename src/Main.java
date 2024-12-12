import models.*;
import services.*;
import utils.*;

public class Main {
  public static void main(String[] args) {
    // create service instances
    UserServices userService = new UserServices();
    ProductServices productService = new ProductServices();
    CartServices cartService = new CartServices();
    OrderServices orderServices = new OrderServices();

    System.out.println("WELCOME TO PURE POWER\n");

    while (true) {
      // login / register
      System.out.println("1: LOGIN\n2: REGISTER\n3: GUEST\n\n0: QUIT");
      int choice = Utils.getNum(0, 3);

      switch (choice) {
        case 1: // login
          if (userService.getLoggedIn()) {
            System.out.println("log out first");
          } else {
            while (!userService.getLoggedIn()) {
              String email = Utils.getEmail();
              String password = Utils.getPassword();

              userService.login(email, password);
            } // while
          }
          break;

        case 2: // register
          if (userService.getLoggedIn()) {
            System.out.println("log out first");
          } else {
            while (!userService.getLoggedIn()) {
              String name = Utils.getString("FULL NAME");
              String address = Utils.getString("ADDRESS");

              String email = Utils.getEmail();
              String password = Utils.getPassword();

              userService.register(name, address, email, password);
            } // while
          }
          break;

        case 3:
          userService.guest();
          break;

        case 0: // exit program
          System.exit(0);
      } // switch

      while (userService.getLoggedIn()) {
        // browse / cart / logout / delete
        System.out.println(
            "1: BROWSE CATALOG\n2: VIEW CART\n3: SEE ORDER HISTORY\n4: LOGOUT\n5: DELETE ACCOUNT\n");
        choice = Utils.getNum(1, 5);

        boolean viewing = true;

        switch (choice) {
          case 1: // browse items
            while (viewing) {
              System.out.println(
                  "1: SEE ALL PRODUCTS\n2: VIEW BY BRAND\n3: BROWSE BY DEPARTMENT\n4: STOP VIEWING\n");

              choice = Utils.getNum(1, 4);

              switch (choice) {
                case 1:
                  productService.listAllProducts();
                  cartService.promptToCart();

                  break;

                case 2:
                  System.out.println(
                      "WHAT BRAND WOULD YOU LIKE TO SEE?\n1: RYOBI\n2: RIDGID\n3: MAKITA\n4: CRAFTSMAN\n5: DEWALT\n6: MILWAUKEE\n0: BACK");

                  choice = Utils.getNum(0, 6);

                  switch (choice) {
                    case 1:
                      productService.listBrandProducts(Product.Brands.RYOBI);
                      cartService.promptToCart();

                      break;

                    case 2:
                      cartService.promptToCart();
                      productService.listBrandProducts(Product.Brands.RIDGID);

                      break;

                    case 3:
                      productService.listBrandProducts(Product.Brands.MAKITA);
                      cartService.promptToCart();

                      break;

                    case 4:
                      productService.listBrandProducts(Product.Brands.CRAFTSMAN);
                      cartService.promptToCart();

                      break;

                    case 5:
                      productService.listBrandProducts(Product.Brands.DEWALT);
                      cartService.promptToCart();

                      break;

                    case 6:
                      productService.listBrandProducts(Product.Brands.MILWAUKEE);
                      cartService.promptToCart();

                      break;

                    case 0:
                      break;
                  } // switch
                  break;

                case 3:
                  System.out.println(
                      "WHAT DEPARTMENT ARE YOU INTERESTED IN?\n1: HARDWARE\n2: FLOORING\n3: GARDEN\n4: LUMBER\n5: PLUMBING\n6: ELECTRICAL\n0: BACK");

                  choice = Utils.getNum(0, 6);

                  switch (choice) {
                    case 1:
                      productService.listDepartmentProducts(Product.Departments.HARDWARE);
                      cartService.promptToCart();

                      break;

                    case 2:
                      productService.listDepartmentProducts(Product.Departments.FLOORING);
                      cartService.promptToCart();

                      break;

                    case 3:
                      productService.listDepartmentProducts(Product.Departments.GARDEN);
                      cartService.promptToCart();

                      break;

                    case 4:
                      productService.listDepartmentProducts(Product.Departments.LUMBER);
                      cartService.promptToCart();

                      break;

                    case 5:
                      productService.listDepartmentProducts(Product.Departments.PLUMBING);
                      cartService.promptToCart();

                      break;

                    case 6:
                      productService.listDepartmentProducts(Product.Departments.ELECTRICAL);
                      cartService.promptToCart();

                      break;

                    case 0:
                      break;
                  } // switch
                  break;

                case 4:
                  viewing = false;
                  break;
              }
            } // while

            break;

          case 2: // view cart
            cartService.printCartItems();

            if (!cartService.isCartEmpty()) {
              System.out.println("1: CHECKOUT\n2: CHANGE QUANTITY\n3: REMOVE ITEM\n4: BACK");
              choice = Utils.getNum(1, 4);

              while (viewing) {
                switch (choice) {
                  case 1: // checkout
                    System.out.println("HOW ARE YOU PAYING?");
                    System.out.println("1: CASH\n2: CARD\n3: TAP-TO-PAY\n0: NEVER MIND");

                    choice = Utils.getNum(0, 3);

                    switch (choice) {
                      case 1:
                        orderServices.createOrder(cartService.getCart(), Order.PaymentMethods.CASH);
                        cartService.emptyCart();

                        break;

                      case 2:
                        orderServices.createOrder(cartService.getCart(), Order.PaymentMethods.CARD);
                        cartService.emptyCart();

                        break;

                      case 3:
                        orderServices.createOrder(
                            cartService.getCart(), Order.PaymentMethods.TAP_TO_PAY);
                        cartService.emptyCart();

                        break;
                    }

                    viewing = false;
                    break;

                  case 2: // change quantity
                    cartService.changeQuantity();

                    viewing = false;
                    break;

                  case 3: // remove item
                    cartService.removeFromCart();

                    if (cartService.isCartEmpty()) {
                      viewing = false;
                    }
                    break;

                  case 4: // back
                    viewing = false;
                    break;
                }
              }
            }

            break;

          case 3: // order history
            orderServices.printAllOrders();

            break;

          case 4: // log out
            userService.logout(true);

            break;

          case 5: // delete account
            userService.deleteAccount();

            break;
        } // switch
      } // while
    } // while
  }
}
