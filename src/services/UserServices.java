package services;

import java.util.HashMap;
import java.util.Objects;
import models.*;
import utils.Utils;

public class UserServices {
  // attributes
  private int currId;

  private boolean loggedIn;
  private int loggedInId;

  private HashMap<Integer, User> users = new HashMap<>();

  // constructor
  public UserServices() {
    this.currId = 1;

    this.register("Jesus Orozco", "1234 Lyon St", "jesusoro@umich.edu", "password");

    this.loggedIn = false;
    this.loggedInId = -1;
  } // UserServices

  // methods
  public boolean getLoggedIn() {
    return this.loggedIn;
  } // getLoggedIn

  public void printAllUsers() {
    for (User user : users.values()) {
      System.out.println("id: " + user.getUserId() + " name: " + user.getUserFullName() + "\n");
    }
  } // printAllUsers

  public void login(String email, String password) {
    for (User user : this.users.values()) {
      if (Objects.equals(user.getEmail(), email) && Objects.equals(user.getPassword(), password)) {
        this.loggedIn = true;
        this.loggedInId = user.getUserId();

        System.out.println("logged in\n");
        return;
      }
    } // for

    System.out.println("invalid email or password\n");
  } // login

  public void guest() {
    this.loggedIn = true;
    this.loggedInId = 0;

    System.out.println("logged in as guest\n");
  } // guest

  public void register(String name, String address, String email, String password) {
    while (checkIfEmailTaken(email)) {
      email = Utils.getEmail();
    } // while

    this.users.put(this.currId, new User(this.currId, name, address, email, password));

    this.loggedInId = currId;
    this.loggedIn = true;
    this.currId++;

    System.out.println("account registered\n");

    //    printAllUsers();
  } // register

  public boolean checkIfEmailTaken(String email) {
    for (User user : users.values()) {
      if (Objects.equals(email, user.getEmail())) {
        System.out.println("email: " + email + " already in use\n");
        return true;
      }
    } // for

    return false;
  } // checkIfEmailTaken

  public void logout(boolean print) {
    this.loggedIn = false;
    this.loggedInId = -1;

    if (print) {
      System.out.println("logged out\n");
    }
  } // logout

  public void deleteAccount() {
    System.out.println("account " + this.loggedInId + " has been deleted\n");

    this.users.remove(this.loggedInId);
    logout(false); // don't print for deleting an account, for logging out is presumed

    //    printAllUsers();
  } // deleteAccount
}
