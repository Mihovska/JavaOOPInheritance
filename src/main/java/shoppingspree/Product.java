package shoppingspree;


public class Product {
  private String name;
  private double cost;

  public Product(String name, double cost) {
    this.setName(name);
    this.setCost(cost);
  }

  private void setCost(double cost) {
    this.cost = cost;
  }

  private void setName(String name) {
    if (name.isBlank()) {
      throw new IllegalArgumentException("Name cannot be empty");
    }
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public double getCost() {
    return this.cost;
  }
}
