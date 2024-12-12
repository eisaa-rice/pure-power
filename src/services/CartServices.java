package services;

import java.util.HashMap;
import models.CartItem;
import utils.*;

public class CartServices extends ProductServices {
  // attributes
  private HashMap<Integer, CartItem> cart = new HashMap<>();

  // constructor
  public CartServices() {} // CartServices

  // methods
  public boolean isCartEmpty() {
    return this.cart.isEmpty();
  } // isCartEmpty

  public void promptToCart() {
    System.out.println("WOULD YOU LIKE TO ADD ANY OF THESE ITEMS TO CART?\n1: YES\n2: NO");
    int x = Utils.getNum(1, 2);

    if (x == 1) {
      System.out.println("ENTER THE ID OF THE ITEM YOU WOULD LIKE TO ADD TO CART");
      int id = Utils.getNum(101, getCurrId() - 1);

      System.out.println("HOW MANY WOULD YOU LIKE?");
      int quantity = Utils.getNum(1, 100);
      double subtotal = quantity * this.getProducts().get(id).getPrice();

      CartItem item =
          new CartItem(
              id,
              this.getProducts().get(id).getProductBrand(),
              this.getProducts().get(id).getName(),
              this.getProducts().get(id).getDepartment(),
              subtotal,
              quantity);

      if (this.cart.containsKey(id)) {
        this.cart.get(id).setQuantityAndSubTotal(quantity);
      } else {
        this.cart.put(id, item);
      }
    }
  } // promptToCart

  public void changeQuantity() {
    if (this.cart.isEmpty()) {
      System.out.println("cannot change quantity of items in an empty cart\n");
      return;
    }

    System.out.println("ENTER THE ID OF THE ITEM YOU WOULD LIKE TO CHANGE QUANTITY FOR");
    int id = Utils.getNum(101, getCurrId() - 1);

    if (!this.cart.containsKey(id)) {
      System.out.println("item not in cart\n");

      return;
    }

    System.out.println("ENTER THE NEW QUANTITY (0 TO REMOVE)");
    int quantity = Utils.getNum(0, 100);

    if (quantity == 0) {
      this.cart.remove(id);
    } else {
      this.cart.get(id).setQuantityAndSubTotal(quantity);
      this.cart.get(id).printItemDetails();
    }
  } // changeQuantity

  public void removeFromCart() {
    if (this.cart.isEmpty()) {
      System.out.println("cannot remove items from an empty cart\n");
      return;
    }

    System.out.println("ENTER THE ID OF THE ITEM YOU WOULD LIKE TO REMOVE FROM CART");
    int id = Utils.getNum(101, getCurrId() - 1);

    if (!this.cart.containsKey(id)) {
      System.out.println("item not in cart\n");
      return;
    }

    this.cart.remove(id);
  } // removeFromCart

  public void printCartItems() {
    if (this.cart.isEmpty()) {
      System.out.println("cart is empty\n");
      return;
    }

    System.out.println("CART:");
    for (CartItem item : this.cart.values()) {
      item.printItemDetails();
    }
    System.out.println();
  } // printCartItems

  public void checkout() {} // checkout
}
