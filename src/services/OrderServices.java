package services;

// import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashMap;
import models.CartItem;
import models.Order;

public class OrderServices {
  // attributes
  private int currOrderId;
  ArrayList<Order> orders = new ArrayList<>();

  // constructor
  public OrderServices() {
    this.currOrderId = 1000;
  }

  // methods
  public void createOrder(
      HashMap<Integer, CartItem> cartItems, Order.PaymentMethods paymentMethod) {
    double orderTotal = calculateOrderTotal(cartItems);

    // for
    ArrayList<CartItem> currItems = new ArrayList<>(cartItems.values());

    orders.add(new Order(this.currOrderId, orderTotal, paymentMethod, currItems));

    this.currOrderId++;
  } // createOrder

  public double calculateOrderTotal(HashMap<Integer, CartItem> cartItems) {
    double total = 0;

    for (CartItem item : cartItems.values()) {
      total += item.getSubtotal();
    } // for

    return total;
  } // calculateOrderTotal

  public void printAllOrders() {
    if (this.orders.isEmpty()) {
      System.out.println("no orders have been made\n");
    }

    for (Order item : this.orders) {
      item.printOrderDetails();
    }
  } // printAllOrders
}
