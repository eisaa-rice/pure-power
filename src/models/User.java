package models;

import java.util.ArrayList;
import java.util.List;

public class User {
  // attributes
  private int userId;
  private String userFullName;
  private String address;

  private String email;
  private String password;

  private List<Product> cart;

  // constructor
  public User(int id, String name, String address, String email, String password) {
    this.userId = id;
    this.userFullName = name;
    this.address = address;
    this.email = email;
    this.password = password;

    this.cart = new ArrayList<>();
  }

  // methods
  public int getUserId() {
    return userId;
  }

  public String getUserFullName() {
    return userFullName;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public List<Product> getCart() {
    return cart;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public void setUserFullName(String userFullName) {
    this.userFullName = userFullName;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void changeEmail(String email) {
    this.email = email;
  }

  public void changePassword(String password) {
    this.password = password;
  }

  public void addItemToCart(Product item) {
    this.cart.add(item);
  }
}
