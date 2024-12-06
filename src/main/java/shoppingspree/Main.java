package shoppingspree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Map<String, Person> people = new HashMap<>();
    Map<String, Product> products = new HashMap<>();

    try {
      String[] peopleInput = scanner.nextLine().split(";");

      for (String personInfo : peopleInput) {
        String[] details = personInfo.split("=");
        String name = details[0];
        double money = Double.parseDouble(details[1]);

        people.put(name, new Person(name, money));
      }

      String[] productsInput = scanner.nextLine().split(";");

      for (String productInfo : productsInput) {
        String[] details = productInfo.split("=");
        String name = details[0];
        double cost = Double.parseDouble(details[1]);

        products.put(name, new Product(name, cost));
      }

      String command = scanner.nextLine();
      while (!"END".equals(command)) {
        String[] purchase = command.split(" ");
        String personName = purchase[0];
        String productName = purchase[1];

        Person person = people.get(personName);
        Product product = products.get(productName);

        person.buyProduct(product);

        command = scanner.nextLine();
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    for (Person person : people.values()) {
      System.out.print(person.getName() + " - ");

      if (person.getProducts().isEmpty()) {
        System.out.println("Nothing bought");
      } else {
        String productsBought =
            String.join(
                ", ", person.getProducts().stream().map(Product::getName).toArray(String[]::new));
        System.out.println(productsBought);
      }
    }
  }
}
