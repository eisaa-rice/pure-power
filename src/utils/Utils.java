package utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Utils {
  public static int getNum(int start, int end) {
    Scanner scanner = new Scanner(System.in);

    int x = -1;

    while (x < start || x > end) {
      try {
        x = scanner.nextInt();

        if (x < 0) {
          System.out.println("no negative numbers please");

        } else if (x < start || x > end) {
          System.out.println("input is not found in menu");
        }

      } catch (Exception e) {
        System.out.println("unknown exception: " + e);
      } // try - catch
    } // while

    return x;
  } // getNum

  public static String getString(String label) {
    System.out.println("ENTER " + label + ":");

    Scanner scanner = new Scanner(System.in);

    String str = "";

    while (str.isEmpty()) {
      try {
        str = scanner.nextLine();

        if (str.isEmpty()) {
          System.out.println("invalid input");

        } else {
          System.out.println(label + ": " + str + "\n");

          break;
        }
      } catch (Exception e) {
        System.out.println("unknown exception: " + e);
      } // try - catch
    } // while

    return str;
  } // getString

  public static String getEmail() {
    System.out.println("ENTER EMAIL:");

    String EMAIL_REGEX = "^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,6}$";
    Scanner scanner = new Scanner(System.in);

    String email = "";

    while (!Pattern.matches(EMAIL_REGEX, email)) {
      try {
        email = scanner.nextLine();

        if (!Pattern.matches(EMAIL_REGEX, email)) {
          System.out.println("invalid email");

        } else {
          System.out.println("EMAIL: " + email + "\n");

          break;
        }
      } catch (Exception e) {
        System.out.println("unknown exception: " + e);
      } // try - catch
    } // while

    return email;
  } // getEmail

  public static String getPassword() {
    System.out.println("ENTER PASSWORD:");

    Scanner scanner = new Scanner(System.in);

    String password = "";

    while (password.length() < 8) {
      try {
        password = scanner.nextLine();

        if (password.length() < 8) {
          System.out.println("password too short");

        } else {
          System.out.println("PASSWORD: " + password + "\n");

          break;
        }
      } catch (Exception e) {
        System.out.println("unknown exception: " + e);
      } // try - catch
    } // while

    return password;
  } // getPassword
}
