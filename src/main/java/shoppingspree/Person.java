package shoppingspree;

import java.util.ArrayList;
import java.util.List;

public class Person {
  private String name;
  private double money;
  private List<Product> products;

  public Person(String name, double money) {
    this.setName(name);
    this.setMoney(money);
    this.products = new ArrayList<>();
  }


  private void setName(String name) {
    if (name.isBlank()) {
      throw new IllegalArgumentException("Name cannot be empty");
    }
    this.name = name;
  }

  private void setMoney(double money) {
    if (money < 0) {
      throw new IllegalArgumentException("Money cannot be negative");
    }
    this.money = money;
  }

  public void buyProduct(Product product) {
    double productCost = product.getCost();
    if (this.money >= productCost) {
      this.products.add(product);
      this.money -= productCost;
      System.out.println(this.name + " bought " + product.getName());
    } else {
      throw new IllegalArgumentException(this.name + " can't afford " + product.getName());
    }
  }

  public String getName() {
    return this.name;
  }

  public List<Product> getProducts() {
    return this.products;
  }

  public double getMoney() {
    return this.money;
  }

}
