package models;

import java.util.ArrayList;

public class Order {
  // attributes
  public enum PaymentMethods {
    CASH,
    CARD,
    TAP_TO_PAY
  }

  private int orderId;
  private double orderTotal;
  private PaymentMethods paymentMethod;

  ArrayList<CartItem> orderItems = new ArrayList<>();

  // constructor
  public Order(
      int id, double orderTotal, PaymentMethods paymentMethod, ArrayList<CartItem> orderItems) {
    this.orderId = id;
    this.orderTotal = orderTotal;
    this.paymentMethod = paymentMethod;

    this.orderItems = orderItems;
  }

  // methods
  public void printOrderDetails() {
    System.out.println(
        "ORDER #" + this.orderId + " PAYED $" + this.orderTotal + " WITH " + this.paymentMethod);

    for (CartItem item : this.orderItems) {
      item.printItemDetails();
    }
    System.out.println();
  } // printOrderDetails

  public int getOrderId() {
    return orderId;
  }

  public double getOrderTotal() {
    return orderTotal;
  }

  public PaymentMethods getPaymentMethod() {
    return paymentMethod;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public void setOrderTotal(double orderTotal) {
    this.orderTotal = orderTotal;
  }

  public void setPaymentMethod(PaymentMethods paymentMethod) {
    this.paymentMethod = paymentMethod;
  }
}
