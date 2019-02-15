package com.mcfarevee.groceries;

public class Package implements Item {

  // fields
  String name;
  Weight weight;
  int price;

  // constructor
  public Package(String _name, Weight _weight, int _price) {
    this.name = _name;
    this.weight = _weight;
    this.price = _price;
  }

  /**
   * get the weight of the package
   */
  public Weight getWeight() {
    return this.weight;
  }// getWeight()

  /**
   * get the price of the package
   */
  public int getPrice() {
    return this.price;
  }// getPrice()

  /**
   * give a string with weight, package and the name
   **/
  public String toString() {
    String amountstr = String.valueOf(this.weight.amount);
    String unit = this.weight.unit.toString();
    String all = amountstr.concat(" ").concat(unit).concat(" of ").concat(this.name);
    return all;
  }// toString()

  /**
   * return true if the compared object is a package with equal fields
   */
  public boolean equals(Object someitem) {
    if (someitem instanceof Package) {
      Package otherpackage = (Package) someitem;
      return (this.name.equals(otherpackage.name) && this.weight.equals(otherpackage.weight)
          && this.price == otherpackage.price);
    } else {
      return (someitem instanceof Package);
    }

    }// equals(Item)
  
  public String getName() {
    return this.name;
  }

}// class
