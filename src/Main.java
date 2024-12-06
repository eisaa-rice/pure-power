import services.*;
import utils.*;

public class Main {
  public static void main(String[] args) {
    // create service instances
    UserServices userService = new UserServices();

    System.out.println("WELCOME TO PURE POWER\n");

    while (true) {
      // login / register
      System.out.println("1: LOGIN\n2: REGISTER\n\n0: QUIT");
      int choice = Utils.getNum(0, 2);

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

        case 0: // exit program
          System.exit(0);
      } // switch

      while (userService.getLoggedIn()) {
        // browse / cart / logout / delete
        System.out.println("1: BROWSE CATALOG\n2: VIEW CART\n3: LOGOUT\n4: DELETE ACCOUNT\n");
        choice = Utils.getNum(1, 4);

        switch (choice) {
          case 1: // browse items
            break;

          case 2: // view cart
            userService.printCartItems();

            break;

          case 3: // log out
            userService.logout(true);

            break;

          case 4: // delete account
            userService.deleteAccount();

            break;
        } // switch
      } // while
    } // while
  }
}
