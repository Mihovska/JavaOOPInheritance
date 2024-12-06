package animals;

public class Animal {
  private String name;
  private int age;
  private String gender;

  public Animal(String name, int age, String gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  public String produceSound() {
    return null;
  }

  public String getName() {
    return name;
  }

  private void setName(String name) {
    if (name.trim().isEmpty() || name == null) {
      throw new IllegalArgumentException("Invalid input");
    }
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  private void setAge(int age) {
    if (age < 0) {
      throw new IllegalArgumentException("Invalid input");
    }
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  private void setGender(String gender) {
    if (gender.trim().isEmpty() || gender == null) {
      throw new IllegalArgumentException("Invalid input");
    }
    this.gender = gender;
  }

  @Override
  public String toString() {
    return String.format("%s%n%s %d %s%n%s", this.getClass().getSimpleName(),
                                             this.name, this.age,
                                             this.gender, this.produceSound());
  }

}
