/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class Calculator {
  public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println("Usage: java Calculator operand1 operator operand2");
      System.exit(0);
    }

    if (!isNumeric(args[0]) || !isNumeric(args[2])) {
      System.out.println("Error: Non-numeric operand detected.");
      System.exit(1);
    }

    try {
      int operand1 = Integer.parseInt(args[0]);
      int operand2 = Integer.parseInt(args[2]);
      int result = 0;

      switch (args[1].charAt(0)) { 
        case '+': result = operand1 + operand2; break;
        case '-': result = operand1 - operand2; break;
        case '*': result = operand1 * operand2; break;
        case '/': result = operand1 / operand2; break;
      }

      System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result);
    } catch (NumberFormatException ex) {
      System.out.println("Error: Non-numeric operand detected.");
    }
  }

  private static boolean isNumeric(String str) {
    for (char c : str.toCharArray()) {
      if (!Character.isDigit(c) && c != '-') return false;
    }
    return true;
  }
}
