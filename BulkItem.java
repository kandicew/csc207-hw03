package com.mcfarevee.groceries;

public class BulkItem implements Item {

  // fields
  BulkFood food;
  Unit unit;
  int amount;

  // constructors
  public BulkItem(BulkFood _food, Unit _unit, int _amount) {
    this.food = _food;
    this.unit = _unit;
    this.amount = _amount;
  }// BulkItem(BlukFood, Unit, int)

  // methods

  /**
   * get the weight of the item
   */
  public Weight getWeight() {
    return new Weight(this.unit, this.amount);
  }// getWeight()

  /**
   * get the price of the item
   */
  public int getPrice() {
    return (this.food.pricePerUnit * this.amount);
  }// getPrice()

  /**
   * give a string of number of units, the units and the type of bulkfood
   */
  public String toString() {
    String amountstr = String.valueOf(this.amount);
    String unit = this.unit.tString();
    String all = amountstr.concat(" ").concat(unit).concat(" of ").concat(this.food.name);
    return all;
  }// toString()

  /**
   * return true if the compared object is a bulkitem with equal fields
   */
  public boolean equal(Object someitem) {
    if (someitem instanceof BulkItem) {
      BulkItem other = (BulkItem) someitem;
      return (this.food.equals(other.food) && this.unit.equals(other.unit)
          && this.amount == other.amount);
    } else {
      return (someitem instanceof BulkItem);
    }
  }// equals(Item)

  public BulkFood getFood() {
    return this.food;
  }

  public Unit getUnit() {
    return this.unit;
  }

  public int getAmount() {
    return this.amount;
  }
}// class
