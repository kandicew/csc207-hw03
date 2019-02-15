package com.mcfarevee.groceries;

public class ManyPackage implements Item {
  // fields
  Package type;
  int count;

  // constructors
  public ManyPackage(Package _type, int _count) {
    this.type = _type;
    this.count = _count;
  }// ManyPackage(Package, int)

  /**
   * get the total weight of many packages
   */
  public Weight getWeight() {
    int total = this.type.getWeight().amount * this.count;
    Weight totalweight = new Weight(this.type.getWeight().unit, total);
    return totalweight;
  }// getWeight()

  /**
   * get the total price of many packages
   */
  public int getPrice() {
    return (this.type.getPrice() * this.count);
  }// getPrice()

  /**
   * give a string with the quantity, a time sign and the description of the package
   */
  public String toString() {
    String quantitystr = String.valueOf(this.count);
    String all = quantitystr.concat(" x ").concat(this.type.toString());
    return all;
  }// toString()

  /**
   * return true if the compared object occupies the same memory location
   */
  public boolean equals(Item otherpackage) {
    return (this == otherpackage);
  }// equals(Item)

  /**
   * return the count of many packages
   */  
  public int getCount() {
    return this.count;
  }//getCount()
}// class
