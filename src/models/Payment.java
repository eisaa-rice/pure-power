package models;

public class Payment {
  public enum paymentMethod {
    CASH,
    DEBIT_CARD,
    CREDIT_CARD,
    APPLE_PAY,
    GOOGLE_PAY
  }

  // attributes
  private int orderId; // foreign key
  private double amountPayed;
  private paymentMethod payMethod;

  // constructor
  Payment(int orderId, double amtPayed, paymentMethod payMethod) {
    this.orderId = orderId;
    this.amountPayed = amtPayed;
    this.payMethod = payMethod;
  }

  // methods

}
