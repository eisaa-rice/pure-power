import services.*;
import utils.*;

public class Main {
  public static void main(String[] args) {
    // create service instances
    UserServices userService = new UserServices();

    // login / register
    System.out.println("WELCOME TO PURE POWER\n1: LOGIN\n2: REGISTER\n\n0: QUIT");
    int x = Utils.getNum(2);

    switch (x) {
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

    // after signed in
    System.out.println("SIGNED IN\n1: BROWSE CATALOG\n2: VIEW CART\n\n0: LOGOUT\n");
    x = Utils.getNum(2);

    switch (x) {
      case 1:
        break;

      case 2:
        break;

      case 0: // exit program
        System.exit(0);
    } // switch

    // viewing cart
    // System.out.println("VIEWING CART\n\n1: BROWSE CATALOG\n2: VIEW CART\n0: LOGOUT\n");
  }
}
