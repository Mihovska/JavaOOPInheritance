package pizza;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
      String[] pizzaItems = scanner.nextLine().split(" ");
      String pizzaName = pizzaItems[1];
      int numberOfToppings = Integer.parseInt(pizzaItems[2]);

      Pizza pizza = new Pizza(pizzaName, numberOfToppings);

      String[] doughItems = scanner.nextLine().split(" ");
      String flourType = doughItems[1];
      String bakingTechnique = doughItems[2];
      double doughWeight = Double.parseDouble(doughItems[3]);

      Dough dough = new Dough(flourType, bakingTechnique, doughWeight);
      pizza.setDough(dough);

      String line;
      while (!(line = scanner.nextLine()).equals("END")) {
        String[] toppingItems = line.split(" ");
        String toppingType = toppingItems[1];
        double toppingWeight = Double.parseDouble(toppingItems[2]);

        Topping topping = new Topping(toppingType, toppingWeight);
        pizza.addTopping(topping);
      }

      System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());

    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }
}
