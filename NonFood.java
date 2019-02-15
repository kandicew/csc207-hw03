package com.mcfarevee.groceries;

public class NonFood implements Item {
  // fields
  String name;
  Weight weight;
  int price;

  // constructors
  public NonFood(String _name, Weight _weight, int _price) {
    this.name = _name;
    this.weight = _weight;
    this.price = _price;
  }// NonFood(String, Weight, int)

  /**
   * gei the weight of nonfood
   */
  public Weight getWeight() {
    return this.weight;
  }// getWeight()

  /**
   * get the price of nonfood
   */
  public int getPrice() {
    return this.price;
  }// getPrice()

  /**
   * give a string of the name of nonfood
   */
  public String toString() {
    return this.name;
  }// toString()

  /**
   * return true if the compared object is a nonfood with equal fields
   */
  public boolean equals(Object someitem) {
    if (someitem instanceof NonFood) {
      NonFood other = (NonFood) someitem;
      return (this.name.equals(other.name) && this.weight.equals(other.weight)
          && this.price == other.price);
    } else {
      return (someitem instanceof NonFood);
    }
  }// equals(Item)
}// class
